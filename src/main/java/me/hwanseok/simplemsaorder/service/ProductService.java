package me.hwanseok.simplemsaorder.service;

import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.model.entity.Product;
import me.hwanseok.simplemsaorder.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product create(Product request){
        return productRepository.save(
                Product.builder()
                        .description(request.getDescription())
                        .build());
    }

    public Product update(Product request){
        Optional<Product> prev = productRepository.findById(request.getId());
        if(prev.isPresent()){
            Product product = prev.get();
            product.setDescription(request.getDescription());
            return productRepository.save(product);
        }else{
            return null;
        }
    }

    public HttpStatus delete(Long id){
        Optional<Product> prev = productRepository.findById(id);
        if(prev.isPresent()){
            productRepository.delete(prev.get());
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }

}

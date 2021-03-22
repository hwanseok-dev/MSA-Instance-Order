package me.hwanseok.simplemsaorder.service;

import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.exception.OrderGroupNotFoundException;
import me.hwanseok.simplemsaorder.model.dto.common.ResponseDto;
import me.hwanseok.simplemsaorder.model.dto.request.LineItemRequestDto;
import me.hwanseok.simplemsaorder.model.dto.request.OrderGroupRequestDto;
import me.hwanseok.simplemsaorder.model.dto.response.OrderGroupResponseDto;
import me.hwanseok.simplemsaorder.model.dto.response.ProductResponseDto;
import me.hwanseok.simplemsaorder.model.dto.response.ProductResponseListDto;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderGroupService {
    private final OrderGroupRepository orderGroupRepository;

    @Value("${product.api.url}")
    private String productApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * OrderGroup 조회
     */
    public ResponseEntity<OrderGroupResponseDto> findById(Long id) {
        Optional<OrderGroup> option = orderGroupRepository.findById(id);
        return option.map(orderGroup -> ResponseEntity
                .ok()
                .body(orderGroup.entity2ResponseDto())
        ).orElseThrow(OrderGroupNotFoundException::new);
    }

    /**
     * OrderGroup 생성
     */
    public ResponseEntity<OrderGroupResponseDto> create(OrderGroupRequestDto request) {
        String productIds = request.getLineItemRequestDtos().stream()
                .map(LineItemRequestDto::getProductId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(productIds);
        ProductResponseDto responseDto = getProductById(productIds).getBody();
        System.out.println(responseDto);
        throw new OrderGroupNotFoundException();
//        OrderGroup newOrderGroup = orderGroupRepository.save(request.requestDto2Entity());
//        return ResponseEntity
//                .ok()
//                .body(newOrderGroup.entity2ResponseDto());
    }

    /**
     * OrderGroup 수정
     */
    public ResponseEntity<OrderGroupResponseDto> update(OrderGroupRequestDto request) {
        Optional<OrderGroup> optional = orderGroupRepository.findById(request.getId());
        if (optional.isPresent()) {
            OrderGroup updateOrderGroup = orderGroupRepository.save(request.requestDto2Entity());
            return ResponseEntity.ok().body(updateOrderGroup.entity2ResponseDto());
        } else {
            throw new OrderGroupNotFoundException();
        }
    }

    /**
     * OrderGroup 삭제
     */
    public ResponseEntity<ResponseDto> delete(Long id) {
        Optional<OrderGroup> option = orderGroupRepository.findById(id);
        if (option.isPresent()) {
            orderGroupRepository.deleteById(id);
            return ResponseEntity.ok().body(ResponseDto.builder()
                    .msg("Successfully deleted orderGroup")
                    .build());
        } else {
            throw new OrderGroupNotFoundException();
        }
    }

    /**
     * @param productId @PathVariable로 전달될 productId
     * @return
     */
    public ResponseEntity<ProductResponseDto> getProductById(String productId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(productApiUrl)
                .path("/{productId}");
//                .queryParam("ids", productId);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE); // 원하는 데이터 형식
//        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE); // 요청과 응답의 데이터 형식
//
//        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        System.out.println(builder.build(productId).toString());
        ResponseEntity<ProductResponseDto> ret = restTemplate.getForEntity(
                builder.build(productId).toString(),
                ProductResponseDto.class
        );
//        ResponseEntity<String> ret = restTemplate.getForEntity(
//                builder.build(productId).toString(),
//                String.class
//        );
        System.out.println(ret.getBody().getDescription());
        System.out.println(ret);
        throw new OrderGroupNotFoundException();
    }

}

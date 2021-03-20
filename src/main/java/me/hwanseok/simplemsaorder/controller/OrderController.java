package me.hwanseok.simplemsaorder.controller;


import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.service.OrderGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderGroupService orderGroupService;

    @GetMapping("/{id}")
    public OrderGroup findById(@PathVariable("id") Long id){
        return orderGroupService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderGroup create(@RequestBody OrderGroup request){
        return orderGroupService.create(request);
    }

//    @PutMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public Product update(@giRequestBody Product request){
//        return productService.update(request);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable("id") Long id){
//        return productService.delete(id);
//    }
}

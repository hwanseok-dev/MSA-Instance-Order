package me.hwanseok.simplemsaorder.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.model.dto.request.OrderGroupRequestDto;
import me.hwanseok.simplemsaorder.model.dto.response.OrderGroupResponseDto;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.service.OrderGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderGroupService orderGroupService;


    /**
     * 주문 생성
     * TODO return type ResponseDto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderGroupResponseDto create(@RequestBody OrderGroupRequestDto request){
        return orderGroupService.create(request);
    }

    /**
     * 주문 조회
     * TODO return type ResponseDto
     */
    @GetMapping("/{id}")
    public OrderGroupResponseDto findById(@PathVariable("id") Long id){
        return orderGroupService.findById(id);
    }

    /**
     * 주문 수정
     * TODO return type ResponseDto
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderGroupResponseDto update(@RequestBody OrderGroupRequestDto request){
        System.out.println("update request"+request);
        return orderGroupService.update(request);
    }

    /**
     * 주문 삭제
     * TODO return type ResponseDto
     */
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id){
        return orderGroupService.delete(id);
    }
}

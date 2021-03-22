package me.hwanseok.simplemsaorder.service;

import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.exception.OrderGroupNotFoundException;
import me.hwanseok.simplemsaorder.model.dto.common.ErrorDto;
import me.hwanseok.simplemsaorder.model.dto.common.ResponseDto;
import me.hwanseok.simplemsaorder.model.dto.request.OrderGroupRequestDto;
import me.hwanseok.simplemsaorder.model.dto.response.OrderGroupResponseDto;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.repository.OrderGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderGroupService {
    private final OrderGroupRepository orderGroupRepository;

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
        OrderGroup newOrderGroup = orderGroupRepository.save(request.requestDto2Entity());
        return ResponseEntity
                .ok()
                .body(newOrderGroup.entity2ResponseDto());
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

}

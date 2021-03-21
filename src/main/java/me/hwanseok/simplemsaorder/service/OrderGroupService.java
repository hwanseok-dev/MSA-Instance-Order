package me.hwanseok.simplemsaorder.service;

import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.model.dto.request.OrderGroupRequestDto;
import me.hwanseok.simplemsaorder.model.dto.response.OrderGroupResponseDto;
import me.hwanseok.simplemsaorder.model.entity.LineItem;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.repository.OrderGroupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderGroupService {
    private final OrderGroupRepository orderGroupRepository;

    /**
     * OrderGroup 조회
     */
    public OrderGroupResponseDto findById(Long id) {
        // orderGroup 조회
        Optional<OrderGroup> option = orderGroupRepository.findById(id);
        // 존재하면 ResponseDto로 변환, 없으면 null
        return option.map(OrderGroup::entity2ResponseDto).orElse(null);
    }

    /**
     * OrderGroup 생성
     */
    public OrderGroupResponseDto create(OrderGroupRequestDto request) {
        // requestDto -> entity 변환
        OrderGroup orderGroup = request.requestDto2Entity();
        // entitiy 저장
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        // entity -> requestDto
        return newOrderGroup.entity2ResponseDto();
    }

    /**
     * OrderGroup 수정
     */
    public OrderGroupResponseDto update(OrderGroupRequestDto request) {
        // orderGroup 조회
        Optional<OrderGroup> optional = orderGroupRepository.findById(request.getId());
        // 존재하면 Update
        if (optional.isPresent()) {
            // requestDto -> entity 변환
            OrderGroup orderGroup = request.requestDto2Entity();
            orderGroupRepository.save(orderGroup);
            return findById(request.getId());
        } else {
            // 없으면 생성
            return create(request);
        }
    }

    /**
     * OrderGroup 삭제
     */
    public HttpStatus delete(Long id) {
        Optional<OrderGroup> option = orderGroupRepository.findById(id);
        if (option.isPresent()) {
            orderGroupRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

}

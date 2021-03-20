package me.hwanseok.simplemsaorder.service;

import lombok.RequiredArgsConstructor;
import me.hwanseok.simplemsaorder.model.entity.OrderGroup;
import me.hwanseok.simplemsaorder.repository.OrderGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderGroupService {
    private final OrderGroupRepository orderGroupRepository;

    public OrderGroup findById(Long id){
        Optional<OrderGroup> order = orderGroupRepository.findById(id);
        return order.orElse(null);
    }

    public OrderGroup create(OrderGroup request){
        request.getLineItems().forEach(lineItem -> lineItem.setOrderGroup(request));
        orderGroupRepository.save(request);
        return null;
    }

}

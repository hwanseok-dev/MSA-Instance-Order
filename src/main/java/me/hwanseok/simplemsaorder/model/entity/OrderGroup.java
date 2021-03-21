package me.hwanseok.simplemsaorder.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import me.hwanseok.simplemsaorder.model.dto.response.LineItemResponseDto;
import me.hwanseok.simplemsaorder.model.dto.response.OrderGroupResponseDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 주문 그룹
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Accessors(chain = true)
@ApiModel
public class OrderGroup {
    /**
     * 주문 그룹 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 주문 그룹 설명
     */
    private String description;

    /**
     * 개별 주문 리스트
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "orderGroup", cascade = CascadeType.ALL)
    private List<LineItem> lineItems;

    public OrderGroupResponseDto entity2ResponseDto(){
        return OrderGroupResponseDto.builder()
                .id(this.id)
                .description(this.description)
                .lineItemResponseDtos(this.lineItems.stream()
                        .map(lineItem -> LineItemResponseDto.builder()
                                .id(lineItem.getId())
                                .description(lineItem.getDescription())
                                .productId(lineItem.getProductId())
                                .build())
                        .collect(Collectors.toList())
                ).build();
    }
}

package me.hwanseok.simplemsaorder.model.entity;


import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 상품
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Accessors(chain = true)
@ApiModel
@ToString(exclude = "orderGroup")
public class LineItem implements Serializable {
    /**
     * 개별 주문 번호
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 상품 이름
     */
    private String name;

//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_group_id")
    private OrderGroup orderGroup;

    private Long productId;

    public void updateOrder(OrderGroup orderGroup){
        this.orderGroup = orderGroup;
    }
}

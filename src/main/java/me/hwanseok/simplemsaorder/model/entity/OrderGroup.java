package me.hwanseok.simplemsaorder.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
public class OrderGroup {
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

    @JsonManagedReference
    @OneToMany(mappedBy = "orderGroup", cascade = CascadeType.ALL)
    private List<LineItem> lineItems;

    public void addLineItem(LineItem lineItem){
        this.lineItems.add(lineItem);
        lineItem.updateOrder(this);
    }
}

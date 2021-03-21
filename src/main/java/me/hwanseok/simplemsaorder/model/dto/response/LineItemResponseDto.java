package me.hwanseok.simplemsaorder.model.dto.response;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 개별 주문
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel
@ToString(exclude = "orderGroup")
public class LineItemResponseDto implements Serializable {
    /**
     * 개별 주문 번호
     */
    private Long id;
    /**
     * 개별 주문 설명
     */
    private String description;
    /**
     * 상품 번호
     */
    private Long productId;
}

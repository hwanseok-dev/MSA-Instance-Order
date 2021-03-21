package me.hwanseok.simplemsaorder.model.dto.response;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * 주문 응답 DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel
public class OrderGroupResponseDto {
    /**
     * 주문 그룹 번호
     */
    private Long id;
    /**
     * 주문 그룹 설명
     */
    private String description;
    /**
     * 개별 주문 리스트
     */
    private List<LineItemResponseDto> lineItemResponseDtos;
}

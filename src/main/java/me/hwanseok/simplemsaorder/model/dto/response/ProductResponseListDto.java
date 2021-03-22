package me.hwanseok.simplemsaorder.model.dto.response;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 상품 응답 리스트 DTO
 */
@Data
@Accessors(chain = true)
@ApiModel
@Builder
public class ProductResponseListDto {
    /**
     * 상품 응답 리스트
     */
    private List<ProductResponseDto> productResponseListDtoList;
}

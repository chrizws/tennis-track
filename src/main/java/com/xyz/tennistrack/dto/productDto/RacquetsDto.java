package com.xyz.tennistrack.dto.productDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RacquetsDto {

    private String price;
    private String list_price;
    private String quantity_total;
    private String link;
    private String sku;
    private OptionsDto options;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class OptionsDto {
        private String size;
        private String color;
        private String width;
    }

}

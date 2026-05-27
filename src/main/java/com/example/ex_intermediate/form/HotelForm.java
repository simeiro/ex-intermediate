package com.example.ex_intermediate.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString
public class HotelForm {
    /**
     * ホテルの金額.
     * 下限値は0、上限値は299999。
     * また、文字列の際はmessage.propertiesからエラーを発生させる。
     */
    @Min(value = 0, message = "値段は0円以上にしてください")
    @Max(value = 2999999, message = "値段は299999円以下にしてください")
    private Integer price;
}

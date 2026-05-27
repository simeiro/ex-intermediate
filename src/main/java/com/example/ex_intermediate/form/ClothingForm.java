package com.example.ex_intermediate.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 衣類検索のフォーム.
 */
@Getter
@Setter
@ToString
public class ClothingForm {
    /**
     * 性別.
     * 入力がない場合はnull。
     */
    @NotNull(message = "性別を入力してください")
    private Integer gender;
    /**
     * 色.
     */
    private String color;
}

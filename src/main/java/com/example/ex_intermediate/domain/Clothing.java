package com.example.ex_intermediate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 衣類情報のドメイン.
 */
@Getter
@Setter
@ToString
public class Clothing {
    /**
     * 性別.
     * 0は男性、1は女性。
     */
    private Integer gender;
    /**
     * 色.
     */
    private String color;
    /**
     * ジャンル.
     */
    private String genre;
    /**
     * サイズ.
     * S, M, L の三段階。
     */
    private String size;
    /**
     * 価格.
     */
    private Integer price;
}

package com.example.ex_intermediate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ホテルのドメイン.
 */
@Getter
@Setter
@ToString
public class Hotel {
    /**
     * id.
     */
    private Long id;
    /**
     * ホテル名.
     */
    private String hotelName;
    /**
     * 最寄駅.
     */
    private String nearestStation;
    /**
     * 金額.
     */
    private Integer price;
}

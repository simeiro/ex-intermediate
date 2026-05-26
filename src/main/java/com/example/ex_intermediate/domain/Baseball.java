package com.example.ex_intermediate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 野球のドメイン.
 */
@Getter
@Setter
@ToString
public class Baseball {
    /**
     * id.
     */
    private Long id;
    /**
     * リーグの名前.
     */
    private String leagueName;
    /**
     * チームの名前.
     */
    private String teamName;
    /**
     * 本拠地.
     */
    private String headquarters;
    /**
     * 発足.
     */
    private String inauguration;
    /**
     * 歴史.
     */
    private String history;
}

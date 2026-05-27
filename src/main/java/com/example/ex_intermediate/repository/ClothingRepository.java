package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Clothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリ.
 */
@Repository
public class ClothingRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothing> CLOTHING_ROW_MAPPER = new BeanPropertyRowMapper<>(Clothing.class);

    /**
     * 指定した性別、色に一致する衣類情報一覧を取得する.
     *
     * @param gender 性別 (0:男性, 1:女性)
     * @param color  色
     * @return　衣類情報の検索結果一覧
     */
    public List<Clothing> findByGenderAndColor(Integer gender, String color) {
        //language=sql
        String sql = """
                SELECT
                    genre,
                    size,
                    price
                FROM
                    clothes
                WHERE
                    gender = :gender AND
                    color = :color
                ORDER BY
                    price DESC
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("gender", gender)
                .addValue("color", color);

        return template.query(sql, param, CLOTHING_ROW_MAPPER);
    }
}

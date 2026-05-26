package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ホテルのリポジトリ
 */
@Repository
public class HotelRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    /**
     * ホテル情報一覧を取得する.
     *
     * @return ホテル情報一覧
     */
    public List<Hotel> findAll() {
        //language=sql
        String sql = """
                SELECT
                    id,
                    hotel_name,
                    nearest_station,
                    price
                FROM
                    hotels
                """;

        return template.query(sql, HOTEL_ROW_MAPPER);
    }

    /**
     * 指定された金額以下のホテル情報一覧を取得する.
     *
     * @param maxPrice 金額（上限）
     * @return 指定された金額以下のホテル情報一覧
     */
    public List<Hotel> findUnderPrice(Integer maxPrice) {
        //language=sql
        String sql = """
                SELECT
                    id,
                    hotel_name,
                    nearest_station,
                    price
                FROM
                    hotels
                WHERE
                    price <= :price
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", maxPrice);

        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }
}

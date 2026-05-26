package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Baseball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 野球のリポジトリ.
 */
@Repository
public class BaseballRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Baseball> BASEBALL_ROW_MAPPER = new BeanPropertyRowMapper<>(Baseball.class);

    /**
     * 野球チームの情報一覧を取得する.
     *
     * @return 野球チームの情報一覧
     */
    public List<Baseball> findAll() {
        //language=sql
        String sql = """
                SELECT
                    id,
                    league_name,
                    team_name,
                    headquarters,
                    inauguration,
                    history
                FROM
                    teams
                """;

        return template.query(sql, BASEBALL_ROW_MAPPER);
    }

    /**
     * 指定したIDの野球チーム情報を取得する.
     *
     * @param id ID
     * @return 指定したIDの野球チーム情報
     */
    public Baseball findById(Long id) {
        //language=sql
        String sql = """
                SELECT
                    id,
                    league_name,
                    team_name,
                    headquarters,
                    inauguration,
                    history
                FROM
                    teams
                WHERE
                    id = :id
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        return template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
    }
}

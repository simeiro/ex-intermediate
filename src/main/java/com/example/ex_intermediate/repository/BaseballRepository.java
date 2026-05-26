package com.example.ex_intermediate.repository;

import com.example.ex_intermediate.domain.Baseball;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseballRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Baseball> BASEBALL_ROW_MAPPER = new BeanPropertyRowMapper<>(Baseball.class);

    public List<Baseball> findAllTeamName() {
        return null;
    }

    public Baseball findById(Long id) {
        return null;
    }
}

package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Baseball;
import com.example.ex_intermediate.repository.BaseballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 野球のサービス.
 */
@Service
@Transactional
public class BaseballService {

    @Autowired
    private BaseballRepository repository;

    /**
     * 野球チームの情報一覧を取得する.
     *
     * @return 野球チームの情報一覧
     */
    public List<Baseball> showList() {
        return repository.findAll();
    }

    /**
     * 指定したIDの野球チームの情報を取得する.
     *
     * @param id ID
     * @return 指定したIDの野球チームの情報
     */
    public Baseball showDetail(Long id) {
        return repository.findById(id);
    }
}

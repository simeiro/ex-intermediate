package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Clothing;
import com.example.ex_intermediate.repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類情報を操作するサービス.
 */
@Service
@Transactional
public class ClothingService {

    @Autowired
    private ClothingRepository repository;

    /**
     * 指定した性別、色に一致する衣類情報一覧を取得する.
     *
     * @param gender 性別(0:男性, 1:女性)
     * @param color  色
     * @return　指定した性別、色に一致する衣類情報一覧
     */
    public List<Clothing> searchByGenderAndColor(Integer gender, String color) {
        return repository.findByGenderAndColor(gender, color);
    }
}

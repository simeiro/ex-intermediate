package com.example.ex_intermediate.service;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテルのサービス.
 */
@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository repository;

    /**
     * ホテル情報の一覧を取得する.
     *
     * @return ホテル情報一覧
     */
    public List<Hotel> showList() {
        return repository.findAll();
    }

    /**
     * 上限金額以下のホテル情報一覧を取得する.
     *
     * @param maxPrice 上限金額
     * @return 上限金額以下のホテル情報一覧
     */
    public List<Hotel> searchByMaxPrice(Integer maxPrice) {
        return repository.findUnderPrice(maxPrice);
    }
}

package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Hotel;
import com.example.ex_intermediate.form.HotelForm;
import com.example.ex_intermediate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル情報を操作するコントローラー.
 * <p>
 * 検索画面を表示し、検索結果を表示する操作を管理する。
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    /**
     * ホテルの検索画面を表示する.
     *
     * @return　ホテルの検索画面
     */
    @GetMapping("")
    public String index(HotelForm hotelForm) {
        return "hotel/search";
    }

    /**
     * ホテルの検索結果を表示する.
     *
     * @return ホテルの検索結果
     */
    @PostMapping("/search")
    public String search(@Validated HotelForm hotelForm, BindingResult result, Model model) {
        // バリデーションエラー + 文字列を除外する
        if (result.hasErrors()) {
            return "hotel/search";
        }

        //サービス内で一つにまとめる
        // 未入力時は全件表示
        Integer price = hotelForm.getPrice();
        if (price == null) {
            model.addAttribute("hotels", service.showList());
            return "hotel/search";
        }

        // 検索結果なし
        List<Hotel> hotelList = service.searchByMaxPrice(price);
        if (hotelList.isEmpty()) {
            model.addAttribute("message", "%d円以下のホテル情報は存在しません".formatted(price));
            return "hotel/search";
        }

        // 検索結果あり
        model.addAttribute("hotels", hotelList);
        return "hotel/search";
    }
}

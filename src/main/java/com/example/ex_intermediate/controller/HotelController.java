package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ホテルのコントローラー.
 * <p>
 * 検索画面を表示し、検索結果を表示する操作を管理する。
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    /**
     *
     * @return
     */
    @GetMapping("")
    public String index() {
        return "hotel/search";
    }

    /**
     *
     * @return
     */
    @PostMapping("/search")
    public String search(String price, Model model) {
        if (price.isEmpty()) {
            model.addAttribute("hotels", service.showList());
            return "hotel/search";
        }

        String errorMessage = null;
        Integer integerPrice = 0;
        try {
            integerPrice = Integer.parseInt(price);

            if (integerPrice < 0) {
                errorMessage = "値段は0円以上にしてください";
                model.addAttribute("errorMessage", errorMessage);
                return "hotel/search";
            }
            if (integerPrice >= 300000) {
                errorMessage = "値段は299999円以下にしてください";
                model.addAttribute("errorMessage", errorMessage);
                return "hotel/search";
            }

        } catch (NumberFormatException e) {
            errorMessage = "数値を入力してください";
            model.addAttribute("errorMessage", errorMessage);
            return "hotel/search";
        }

        model.addAttribute("hotels", service.searchByMaxPrice(integerPrice));

        return "hotel/search";
    }
}

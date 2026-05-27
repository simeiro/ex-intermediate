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
    public String index(HotelForm hotelForm) {
        return "hotel/search";
    }

    /**
     *
     * @return
     */
    @PostMapping("/search")
    public String search(@Validated HotelForm hotelForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "hotel/search";
        }

        Integer price = hotelForm.getPrice();
        if (price == null) {
            model.addAttribute("hotels", service.showList());
            return "hotel/search";
        }

        List<Hotel> hotelList = service.searchByMaxPrice(price);
        if (hotelList.isEmpty()) {
            model.addAttribute("message", "%d円以下のホテル情報は存在しません".formatted(price));
            return "hotel/search";
        }

        model.addAttribute("hotels", hotelList);
        return "hotel/search";
    }
}

package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Clothing;
import com.example.ex_intermediate.form.ClothingForm;
import com.example.ex_intermediate.service.ClothingService;
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
 * 衣類情報を操作するコントローラー.
 */
@Controller
@RequestMapping("/clothing")
public class ClothingController {

    @Autowired
    private ClothingService service;

    /**
     * 衣類検索画面を表示する.
     *
     * @return 衣類検索画面
     */
    @GetMapping("")
    public String index(ClothingForm clothingForm) {
        return "clothing/search";
    }

    /**
     * 衣類検索結果画面を表示する.
     *
     * @param clothingForm 衣類検索用のフォーム
     * @param result       エラーを確認するためのresult
     * @param model        requestスコープ
     * @return　衣類検索結果画面
     */
    @PostMapping("/search")
    public String search(@Validated ClothingForm clothingForm, BindingResult result, Model model) {
        //ラジオボタンが未入力
        if (result.hasErrors()) {
            return "clothing/search";
        }

        List<Clothing> clothingList = service.searchByGenderAndColor(
                clothingForm.getGender(),
                clothingForm.getColor()
        );
        //検索結果なし
        if (clothingList.isEmpty()) {
            model.addAttribute("message", "検索結果がありませんでした");
            return "clothing/search";
        }

        //検索結果あり
        model.addAttribute("clothes", clothingList);

        return "clothing/search";
    }
}

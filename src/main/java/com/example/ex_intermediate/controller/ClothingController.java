package com.example.ex_intermediate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 衣類情報を操作するコントローラー.
 */
@Controller
@RequestMapping("/clothing")
public class ClothingController {

    /**
     *
     * @return
     */
    @GetMapping("")
    public String index() {
        return "clothing/search";
    }

    /**
     *
     * @return
     */
    @PostMapping("/search")
    public String search() {
        return "clothing/search";
    }
}

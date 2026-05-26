package com.example.ex_intermediate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 野球のコントローラー.
 */
@Controller
@RequestMapping("/baseball")
public class BaseballController {

    /**
     *
     * @return
     */
    @GetMapping("")
    public String index() {
        return "team-list";
    }

    /**
     *
     * @return
     */
    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }
}

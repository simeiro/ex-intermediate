package com.example.ex_intermediate.controller;

import com.example.ex_intermediate.domain.Baseball;
import com.example.ex_intermediate.service.BaseballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 野球チームを操作するコントローラー.
 */
@Controller
@RequestMapping("/baseball")
public class BaseballController {

    @Autowired
    private BaseballService service;

    /**
     * 野球チーム一覧画面を表示する.
     *
     * @param model requestスコープ
     * @return 野球チーム一覧画面
     */
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("teams", service.showList());

        return "baseball/team-list";
    }

    /**
     * 野球チーム画面を表示する.
     *
     * @param model requestスコープ
     * @return 野球チーム画面
     */
    @GetMapping("/detail")
    public String detail(Long id, Model model) {
        Baseball baseball = service.showDetail(id);
        if (baseball == null) {
            return "redirect:/baseball";
        }

        model.addAttribute("team", baseball);

        return "baseball/detail";
    }
}

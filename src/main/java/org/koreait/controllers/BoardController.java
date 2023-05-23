package org.koreait.controllers;


import org.koreait.models.board.Board;
import org.koreait.models.board.ListService;
import org.koreait.models.board.SaveService;
import org.koreait.models.board.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private SaveService saveService;

    @Autowired
    private ListService listService;

    @Autowired
    private ViewService viewService;
    @GetMapping("/write")
    public String write(BoardFrom boardFrom, Model model){
        model.addAttribute("boardFrom",boardFrom);
        return "board/write";
    }
    @PostMapping("/write")
    public String save(BoardFrom boardFrom, Model model){
        model.addAttribute("boardFrom",boardFrom);
        saveService.save(boardFrom);

        return "redirect:/board/list";
    }


    @GetMapping("/list")
    public String list(Model model){
        List<Board> board = listService.list();
        model.addAttribute("board",board);

        return "board/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model){
        Board board = viewService.view(id);
        model.addAttribute("board",board);
        System.out.println("안녕하세요"+board);
        return "board/view";
    }

}

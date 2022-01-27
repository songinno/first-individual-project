package com.spring.individualProject.board.controller;

import com.spring.individualProject.board.domain.Board;
import com.spring.individualProject.board.dto.ModBoard;
import com.spring.individualProject.board.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //게시글 작성화면 요청
   @GetMapping("/write")
    public String write() {
        log.info("/board/write GET!");
        return "board/write";
    }
    //게시글 등록 요청
    @PostMapping("/write")
    public String writePost(Board board) {
        log.info("/board/write POST! -> " + board);

        boardService.register(board);
        return "redirect:/";
    }

    //게시글 상세보기 화면 요청
    @GetMapping("/content")
    public String getContent(Long boardNo, Model model) {
        Board board = boardService.getOne(boardNo);
        model.addAttribute("article", board);
       return "board/content";
    }

    //게시글 수정화면 요청
    @GetMapping("/modify")
    public String modify(Long boardNo, Model model) {
        Board board = boardService.getOne(boardNo);
        model.addAttribute("article", board);
        return "board/modify";
    }

    //게시글 수정 요청
    @PostMapping("/modify")
    public String modifyPost(ModBoard modBoard) {
       boardService.modify(modBoard);

       return "redirect:/board/content?boardNo=" + modBoard.getBoardNo();
    }

    //게시글 삭제
    @GetMapping("/delete")
    public String delete(Long boardNo) {
       boardService.remove(boardNo);

       return "redirect:/";
    }
}

package com.spring.individualProject;

import com.spring.individualProject.board.domain.Board;
import com.spring.individualProject.board.repository.BoardMapper;
import com.spring.individualProject.board.service.BoardService;
import com.spring.individualProject.common.Page;
import com.spring.individualProject.common.PageMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class HomeController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Page page, Model model) {
        log.info("page " + page);
        List<Board> boardList = boardService.getList(page);
        model.addAttribute("articles", boardList);

        PageMaker pageMaker = new PageMaker(page, boardService.getCount());
        model.addAttribute("pageInfo", pageMaker);

        return "index";
    }
}

package com.spring.individualProject.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class ModBoard {
    //수정시 필요한 필드만 생성
    private Long boardNo;
    private String writer;
    private String title;
    private String content;

    public ModBoard(Long boardNo, String title, String content) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}

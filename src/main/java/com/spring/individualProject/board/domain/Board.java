package com.spring.individualProject.board.domain;

import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Board {
    private Long boardNo; // 게시글 번호
    private String writer; // 작성자
    private String title; // 게시글 제목
    private String content; // 글내용

    private int viewCount; // 조회수
    private Date regDate; // 작성일자

    private boolean newFlag; // 신규글 여부
    private Date lastUpdateDate; // 최종 수정시간



}

package com.spring.individualProject.board.repository;

import com.spring.individualProject.board.domain.Board;
import com.spring.individualProject.board.dto.ModBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {
    @Autowired BoardMapper boardMapper;

    @Test
    @DisplayName("신규 게시글 정상 등록되어야 한다.")
    void insert() {
        System.out.println("====================================");
        Board board = Board.builder().writer("이승철").title("가입인사드립니다3").content("저는 가수입니다.").build();
//        Board board = new Board();
        boardMapper.insert(board);
        System.out.println("====================================");
    }

    @Test
    @DisplayName("게시글 정상 삭제되어야 함.")
    void delete() {
        boardMapper.delete(2L);
    }


    @Test
    @DisplayName("게시글 번호에 따라, 제목과 내용이 정상 수정되어야 함.")
    void update() {
        ModBoard modBoard = new ModBoard(1L, "제목 수정합니다222", "내용도 수정합니다222");
        boardMapper.update(modBoard);
    }

    @Test
    @DisplayName("게시글 번호로, 해당 게시글 상세 조회가 정상 출력되어야 함.")
    void getContent() {
        Board content = boardMapper.getContent(3L);
        System.out.println("-------------------------------");
        System.out.println(content);
    }

//    @Test
//    @DisplayName("게시글 전체 목록 정상 출력되어야 함.")
//    void getArticles() {
//        List<Board> articles = boardMapper.getArticles();
//        System.out.println("=====================================");
//        System.out.println("");
//        System.out.println(articles);
//        System.out.println("");
//        System.out.println("=====================================");
//    }
    
    @Test
    @DisplayName("게시글 100개 생성")
    void insert2() {
        for (int i = 0; i < 100; i++) {
            Board board = Board.builder().title("제목 " + i).writer("작성자 " + i).content("내용내용 " + i).build();
            boardMapper.insert(board);
        }
    }
}
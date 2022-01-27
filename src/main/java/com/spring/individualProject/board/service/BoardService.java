package com.spring.individualProject.board.service;

import com.spring.individualProject.board.domain.Board;
import com.spring.individualProject.board.dto.ModBoard;
import com.spring.individualProject.board.repository.BoardMapper;
import com.spring.individualProject.common.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    //+신규글 여부 표시하기
    private List<Board> judgeNewArticle(List<Board> articles) {
        for (Board article : articles) {
//            Date regDate = article.getRegDate(); // 연월시분일초
            long regTimeDate = article.getRegDate().getTime(); // 게시글 등록 밀리초

            long nowTimeDate = System.currentTimeMillis(); // 현재 밀리초

            long timeDifference = nowTimeDate - regTimeDate; // 시간차

            long limitTime = 24 * 60 * 60 * 1000; // 하루를 밀리초로

            if (timeDifference < limitTime) {
                article.setNewFlag(true);
            }
        }
        return articles;
    }

    //게시물 목록 조회 중간처리
    public List<Board> getList(Page page) {
        //+신규글 여부 표시하기
        List<Board> articles = boardMapper.getArticles(page);
        return judgeNewArticle(articles);
    }


    //게시물 등록 중간처리
    public boolean register(Board board) {
        return boardMapper.insert(board);
    }

    //게시글 상세보기 중간처리
    public Board getOne(Long boardNo) {
        return boardMapper.getContent(boardNo);
    }

    //게시글 삭제 중간처리
    public boolean remove(Long boardNo) {
        return boardMapper.delete(boardNo);
    }

    //게시글 수정 중간처리
    public boolean modify(ModBoard board) {
        return boardMapper.update(board);
    }

    //총 게시물수 조회 중간처리
    public int getCount() {
        return boardMapper.getTotalCount();
    }
}

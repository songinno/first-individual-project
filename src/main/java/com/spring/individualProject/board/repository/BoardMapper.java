package com.spring.individualProject.board.repository;

import com.spring.individualProject.board.domain.Board;
import com.spring.individualProject.board.dto.ModBoard;
import com.spring.individualProject.common.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //게시글 목록 조회
    List<Board> getArticles(Page page);

    //게시글 상세 조회
    Board getContent(Long boardNo);

    //게시글 등록
    boolean insert(Board board);

    //게시글 삭제
    boolean delete(Long boardNo);

    //게시글 수정
    boolean update(ModBoard board);

    //총 게시물 수 조회
    int getTotalCount();
}

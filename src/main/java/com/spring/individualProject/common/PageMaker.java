package com.spring.individualProject.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PageMaker {
    //한 화면에 배치할 페이지 수
    private static final int PAGE_COUNT = 10;

    //시작, 끝 페이지 번호
    private int beginPage, endPage;

    //prev, next 버튼
    private boolean prev, next;

    //외부에서 받아올 데이터들
    private Page page;
    private int totalCount; // 총게시물 수

    //생성자
    public PageMaker(Page page, int totalCount) {
        this.page = page;
        this.totalCount = totalCount;
        makePageInfo();
    }
    //페이지 정보 생성 메서드
    private void makePageInfo() {
        //끝 페이지번호 계산
        this.endPage = (int) Math.ceil(page.getPageNum() / (double)PAGE_COUNT) * PAGE_COUNT;
        //시작 페이지번호 계산
        this.beginPage = endPage - PAGE_COUNT + 1;
        //총 게시물 수에 따른, 실제 끝페이지번호 계산
        int realEndPage = (int) Math.ceil(totalCount /(double) page.getAmount());
        //마지막 구간에만 실제 끝페이지번호 적용
        if(endPage > realEndPage) {
            this.endPage = realEndPage;
        }
        //prev버튼 활성화 (1~10구간만 빼고 모두 활성화)
        this.prev = this.beginPage > 1;
        //next버튼 활성화(마지막 구간 빼고 모두 활성화)
        this.next = this.endPage < realEndPage;
    }
}

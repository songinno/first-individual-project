package com.spring.individualProject.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Page {
    private int pageNum; // 페이지 번호
    private int amount; // 1페이지당 게시물 수

    //첫 화면 기본값
    public Page() {
        this.pageNum = 1;
        this.amount = 10;
    }

    //이상한 값 못넣게 방어
    public void setPageNum(int pageNum) {
        if (pageNum <= 0) {
            this.pageNum = 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public void setAmount(int amount) {
        if (amount <= 0 || amount > 100) {
            this.amount = 10;
            return;
        }
        this.amount = amount;
    }


}

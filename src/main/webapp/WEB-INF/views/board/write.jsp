<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="../include/static-head.jsp" %>

    <style>
        .write-container {
            width: 60%;
            margin: 100px auto;
            padding: 100px 50px;

            border: 3px solid gray;
            border-radius: 80px / 40px;
        }

        .write-container h1 {
            width: 50%;
            /* background: yellow; */
            margin: 0 auto 50px;
            text-align: center;
            font-weight: bold;
            font-size: 2em;
        }
    </style>
</head>

<body>
    <div class="wrap">
        <div class="write-container">
            <h1>게시글 작성</h1>
            <form action="/board/write" method="post" autocomplete="off">
                <div class="mb-3">
                    <label for="Input1" class="form-label">제목</label>
                    <input type="text" class="form-control" id="input1" placeholder="게시글 제목을 입력하세요." name="title">
                </div>

                <div class="mb-3">
                    <label for="Input2" class="form-label">작성자</label>
                    <input type="text" class="form-control" id="input2" placeholder="작성자 이름을 입력하세요." name="writer">
                </div>

                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
                </div>

                <div class="write-btn-box">
                    <button type="submit">작성완료</button>
                    <button><a href="/">작성취소</a></button>
                </div>

            </form>
        </div>
    </div>


    <script>
        //***빈칸으로 글 작성시, 반려하기
        const [$title, $writer] = [...document.querySelectorAll('input[id^=input]')];
        // console.log(`$title: `, $title);
        // console.log(`$writer: `, $writer);

        const $submitBtn = document.querySelector('button[type]');
        // console.log($submitBtn);

        $submitBtn.addEventListener('click', function (e) {
            e.preventDefault();

            const $form = e.target.parentNode.parentNode;
            console.log($form);

            if ($title.value !== '' && $writer.value !== '') {
                $form.submit();

            } else {
                alert('제목과 작성자 칸을 모두 채워주세요');
            }
        });
    </script>

</body>

</html>
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
      <h1>게시글 수정</h1>
      <form action="/board/modify" method="post" autocomplete="off">

        <input type="hidden" name="boardNo" value="${article.boardNo}">

        <div class="mb-3">
          <label for="Input1" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" value="${article.title}" name="title">
        </div>

        <div class="mb-3">
          <label for="Input2" class="form-label">작성자: ${article.writer}</label>
          <input type="hidden" value="${article.writer}" name="writer">
        </div>

        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
          <textarea class="form-control" id="content" rows="3"
            name="content">${article.content}</textarea>
        </div>

        

        <div class="write-btn-box">
          <button type="submit" id="submitBtn">수정완료</button>
          <button><a href="/">수정취소</a></button>
        </div>

      </form>
    </div>
  </div>


  <script>
    const $title = document.getElementById('title');

    const $submitBtn = document.querySelector('#submitBtn');

    const $form = $submitBtn.parentNode.parentNode;
    $submitBtn.addEventListener('click', e => {
      console.log($title);
      console.log($submitBtn);
      console.log($form);
      e.preventDefault();

      if ($title.value === '') {
        alert('제목을 적어주세요');
      } else {
        $form.submit();
      }
    });
  </script>

</body>

</html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <%@ include file="../include/static-head.jsp" %>

  <style>
    .content-container {
      width: 60%;
      margin: 100px auto;
      padding: 100px 50px;

      border: 3px solid #000;
    }

    .content-container h1 {
      width: 50%;
      /* background: yellow; */
      margin: 0 auto 50px;
      text-align: center;
      font-weight: bold;
      font-size: 2em;
    }
    .content-container h2 {
      font-size: 1.6em;
      margin-bottom: 50px;
    }
    .content-container textarea {
      text-indent: 10px;
      border: 1px solid gray;
    }

    .content-btn-box {
      width: 20%;
      /* background: yellow; */
      float:right;
      margin-right: 100px;
    }

    .last-update-date {
      margin-left: 100px;
    }
  </style>
</head>

<body>
  <div class="wrap">
    <div class="content-container">
      <h1>${article.title}</h1>

      <h2>작성자: ${article.writer}</h2>

      <textarea cols="50" rows="10" disabled>${article.content}</textarea>
    </div>

    <div class="last-update-date">
      최종수정시간:
      <fmt:formatDate value="${article.lastUpdateDate}" pattern="yyyy년 MM월 dd일 a hh:mm" />
    </div>

    <div class="content-btn-box">
      <button type="button" class="btn btn-light" id="list-btn">목록</button>
      <button type="button" class="btn btn-light" id="modify-btn">수정</button>
      <button type="button" class="btn btn-light" id="delete-btn">삭제</button>
    </div>
  </div>

  <script>
    const [$listBtn, $modifyBtn, $deleteBtn] = [...document.querySelectorAll('.btn-light')];
    console.log($listBtn);
    console.log($modifyBtn);
    console.log($deleteBtn);

    //***목록버튼
    $listBtn.onclick = e => {
      location.href = '/';
    };
    //***수정버튼 -> 수정화면 요청
    $modifyBtn.onclick = e => {
      location.href = '/board/modify?boardNo=${article.boardNo}';
    }
    //***삭제버튼
    $deleteBtn.addEventListener('click', function(e){
      if(confirm('정말 삭제하시겠습니까?')) {
        location.href='/board/delete?boardNo=${article.boardNo}';
      } else {
        return;
      }
    });
  </script>
</body>

</html>
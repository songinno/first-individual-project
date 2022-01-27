<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <%@ include file="include/static-head.jsp" %>
</head>

<body>
  <div class="wrap">
    <!-- header -->
    <header>
      <div class="inner-header clearfix">
        <h1 class="logo">
          <a href="#">
            <img src="/img/main_logo.jpg" alt="메인 로고 이미지">
          </a>
        </h1>

        <h2 class="title"><em>자유게시판</em></h2>

        <nav class="gnb">
          <ul>
            <li><a href="#">로그인</a></li>
            <li><a href="#">회원가입</a></li>
          </ul>

          <a href="#" class="report">
            <span class="lnr lnr-bullhorn"></span>
          </a>
        </nav>
      </div>
    </header>

    <div class="underbox"></div>

    <div class="article-box">
      <table class="article-table">
        <tr>
          <th id="boardNo">글번호</th>
          <th id="title">제목</th>
          <th id="writer">작성자</th>
          <th id="regDate">작성일자</th>
          <th id="viewCount">조회수</th>
        </tr>
        <c:forEach var="a" items="${articles}">
          <tr>
            <td id="boardNo">${a.boardNo}</td>
            <td id="title">
              ${a.title}
              <!-- 신규글 표시 -->
              <c:if test="${a.newFlag}">
                <span class="badge bg-secondary bg-danger">New</span>
              </c:if>
            </td>
            <td id="writer">${a.writer}</td>
            <td id="regDate">
              <fmt:formatDate value="${a.regDate}" pattern="yyyy년 MM월 dd일 a h:mm" />
            </td>
            <td id="viewCount">${a.viewCount}</td>
          </tr>
        </c:forEach>
      </table>
    </div>

    <div class="btn-box">
      <button type="submit" id="write-btn">글쓰기</button>
    </div>

    <div class="page-box">
      <div class="btn-group me-2" role="group" aria-label="First group">
        <c:if test="${pageInfo.prev}">
          <a href="/?pageNum=${pageInfo.beginPage - 1}">
            <button type="button" class="btn btn-outline-secondary">prev</button>
          </a>
        </c:if>

        <c:forEach var="i" begin="${pageInfo.beginPage}" end="${pageInfo.endPage}" step="1">
          <a href="/?pageNum=${i}">
            <button type="button" class="btn btn-outline-secondary">${i}</button>
          </a>
        </c:forEach>

        <c:if test="${pageInfo.next}">
          
            <a href="/?pageNum=${pageInfo.endPage + 1}">
              <button type="button" class="btn btn-outline-secondary">next</button>
            </a>
        </c:if>

      </div>

      <div>
        <!-- ${pageInfo} -->
      </div>
    </div>




  </div>
  <script>
    //***글쓰기 버튼 클릭 이벤트 -> 글쓰기 화면 요청***
    const $writeBtn = document.getElementById('write-btn');
    $writeBtn.onclick = e => {
      // console.log('글쓰기 버튼 클릭됨');
      location.href = '/board/write';
    };

    //***게시글 클릭 이벤트 -> 게시글 상세보기 화면 요청(버블링 이용)***
    const $table = document.querySelector('.article-table');


    $table.onclick = e => {
      if (!e.target.matches('.article-table td')) return;

      //클릭한 게시글의 글번호 찾기
      console.log(e.target);

      const $firstTd = e.target.parentNode.firstElementChild;
      console.log($firstTd);

      let boardNo = $firstTd.textContent;
      console.log(boardNo);

      //글번호 정보로 content.jsp 화면 요청
      location.href = '/board/content?boardNo=' + boardNo;


    };
  </script>
</body>

</html>
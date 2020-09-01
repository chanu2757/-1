<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel="stylesheet" href="/chanBoard/css/view.css">
</head>
<body>
    <script src= "../js/jquery-1.12.4.js"></script>
    <script src= "../js/jquery-ui.js"></script>
    <!-- 상단 메뉴 -->

    <!-- 컨테이너 -->
    <div id="container">
        <div id="header">
            찬우의 게시판입니다.
        </div>
        
        <div id="main">
            <div id="title">글쓰기</div>
            <div id="subjectBox">
                <span class="subject">제목</span> <input class="subject" type="text" id="subject" value="${dto.subject }" readonly>
            </div>
            <div id="contentBox">
                <span class="content">내용</span> <textarea class="content" id="content" readonly>${dto.content }</textarea>
            </div>

            <button id="addfile">파일 조회</button>
            <div id="btnBox">
                <a href="../board/list.do"><button class="byeBtn" type="button">뒤로가기</button></a>
           		<button class="byeBtn" type="button" onclick="location.href='../board/deleteOk.do?seq=${seq}'">삭제하기</button>
           		<button class="byeBtn" type="button" onclick="location.href='../board/edit.do?seq=${seq}'">수정하기</button>
            </div>
        </div><!-- tbl_box-->
    </div><!-- main -->
        <div id="footer">

        </div>
    </div><!-- container -->
        </div>
    <script>

    </script>
</body>
</html>
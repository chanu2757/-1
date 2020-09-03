<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel ="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="/chanBoard/css/write.css">
</head>
<body>
    <script src= "js/jquery-1.12.4.js"></script>
    <script src= "js/jquery-ui.js"></script>
    <!-- 상단 메뉴 -->

    <!-- 컨테이너 -->
    <div id="container">
        <div id="header">
            찬우의 게시판입니다.
        </div>
        
        <div id="main">
            <div id="title">글쓰기</div>
            <form method="POST" action="../board/writeOk.do">
            <div id="writerBox">
                <span class="writer">작성자</span><input class="subject" type="text" id="writer" name="writer">
            </div>
            <div id="subjectBox">
                <span class="subject">제목</span> <input class="subject" type="text" id="subject" name="subject">
            </div>
            <div id="contentBox">
                <span class="content">내용</span> <textarea class="content" id="content" name="content"></textarea>
            </div>

            <div id="file">
                <div>파일 첨부</div>
                <input type="file" name="">
            </div>
            <button id="addfile">파일 추가</button>
            <div id="btnBox">
                <button class="byeBtn" type="button">취소</button>
                <button class="byeBtn" type="submit">글쓰기</button>
            </div>
            </form>
    </div><!-- main -->
        <div id="footer">

        </div>
    </div><!-- container -->
    <script>
	
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel="stylesheet" href="/chanBoard/css/write.css">
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
        	<input type="hidden" value="${dto.seq }" name="seq">
            <div id="title">글쓰기</div>
            <form method="POST" action="../board/editOk.do?seq=${seq}">
            <div id="subjectBox">
                <span class="subject">제목</span> <input class="subject" type="text" id="subject" name="subject" value="${dto.subject }">
            </div>
            <div id="contentBox">
                <span class="content">내용</span> <textarea class="content" id="content" name="content">${dto.content }</textarea>
            </div>

            <div id="file">
                <div>파일 첨부</div>
                <input type="file" name="">
            </div>
            <button id="addfile">파일 추가</button>
            <div id="btnBox">
               	<a href="../board/list.do"><button type="button" class="byeBtn" >취소</button></a>
                <button class="byeBtn" type="submit" onclick="location.href('../board/editOk.do')">수정</button>
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
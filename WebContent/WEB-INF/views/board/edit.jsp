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
    <!-- ��� �޴� -->

    <!-- �����̳� -->
    <div id="container">
        <div id="header">
            ������ �Խ����Դϴ�.
        </div>
        
        <div id="main">
        	<input type="hidden" value="${dto.seq }" name="seq">
            <div id="title">�۾���</div>
            <form method="POST" action="../board/editOk.do?seq=${seq}">
            <div id="subjectBox">
                <span class="subject">����</span> <input class="subject" type="text" id="subject" name="subject" value="${dto.subject }">
            </div>
            <div id="contentBox">
                <span class="content">����</span> <textarea class="content" id="content" name="content">${dto.content }</textarea>
            </div>

            <div id="file">
                <div>���� ÷��</div>
                <input type="file" name="">
            </div>
            <button id="addfile">���� �߰�</button>
            <div id="btnBox">
               	<a href="../board/list.do"><button type="button" class="byeBtn" >���</button></a>
                <button class="byeBtn" type="submit" onclick="location.href('../board/editOk.do')">����</button>
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
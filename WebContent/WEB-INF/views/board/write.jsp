<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel ="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="/chanBoard/css/write.css">
</head>
<body>
    <script src= "js/jquery-1.12.4.js"></script>
    <script src= "js/jquery-ui.js"></script>
    <!-- ��� �޴� -->

    <!-- �����̳� -->
    <div id="container">
        <div id="header">
            ������ �Խ����Դϴ�.
        </div>
        
        <div id="main">
            <div id="title">�۾���</div>
            <form method="POST" action="../board/writeOk.do">
            <div id="writerBox">
                <span class="writer">�ۼ���</span><input class="subject" type="text" id="writer" name="writer">
            </div>
            <div id="subjectBox">
                <span class="subject">����</span> <input class="subject" type="text" id="subject" name="subject">
            </div>
            <div id="contentBox">
                <span class="content">����</span> <textarea class="content" id="content" name="content"></textarea>
            </div>

            <div id="file">
                <div>���� ÷��</div>
                <input type="file" name="">
            </div>
            <button id="addfile">���� �߰�</button>
            <div id="btnBox">
                <button class="byeBtn" type="button">���</button>
                <button class="byeBtn" type="submit">�۾���</button>
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
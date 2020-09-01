<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link rel="stylesheet" href="/chanBoard/css/list.css">
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
            <div id="tbl_box">
                <div id="title">���� ȭ��</div>
            <table id="tbl" class="board">
            <thead>
                <tr>
                <th><input type="checkbox" id="allcb"></th>
                <th>��ȣ</th>
                <th>����</th>
                <th>�ۼ���</th>
                <th>�ۼ���</th>
                <th>��ȸ��</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${dto}" var="dto">
                <tr>
                <td><input type="checkbox" value="${dto.seq	 }"></td>
                <td>${dto.rownum}</td>
           		<td onclick="location.href='../board/view.do?seq=${dto.seq}'">${dto.subject }</td>
                <td>${dto.writer }</td>
                <td>${dto.regdate }</td>
                <td>${dto.viewcnt }</td>
                </tr>
     			</c:forEach>
            </tbody> 
            </table>
            <div id= "searchBox">
                <select id="selectBox">
                    <option value="����">����</option>
                    <option value="����">����+����</option>
                    <option value="�ۼ���">�ۼ���</option>
                </select>
                <input type="text" id="searchText">
                <button id="searchBtn" type="submit">�˻�</button>
            </div>
            <div id="moveBox">
            <ul id="paging">
                <li class="pagingBtn" id="prevbtn"><i class="fas fa-angle-left"></i></li>
                <li class="pagingBtn">y</li>
                <li class="pagingBtn">y</li>
                <li class="pagingBtn">y</li>
                <li class="pagingBtn">y</li>
                <li class="pagingBtn">y</li>
                <li class="pagingBtn" id="nextbtn"><i class="fas fa-angle-right"></i></li>
            </ul>
            <a href="../board/write.do"><div id="writeBtn" name="write"><i class="fas fa-pencil-alt"></i>�۾���</div></a>
            </div>
        </div>
    </div><!-- tbl_box-->
        <div id="footer">

        </div>
    </div><!-- container -->

	<script>
        var chk =0;
        $("#allcb").click(function(){
            console.log($("input[type=checkbox]"));
            console.log(chk)
            if(chk==0){
            chk=1;
            $("input[type=checkbox]").attr("checked","true");
            }
            else{
            chk=0;
            $("input[type=checkbox]").removeAttr("checked");
            }

        });
    </script>
</body>
</html>
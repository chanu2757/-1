package chanBoard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list.do")
public class list extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
		
	//검색
	String sel = req.getParameter("sel");
	String search = req.getParameter("search");
	
	HashMap<String,String> map = new HashMap<String,String>();
	
	map.put("sel",sel+"");
	map.put("search",search+"");
	System.out.println(sel);
	System.out.println(search);
	//페이징 처리 관련 변수
		int nowPage = 0; //현재 페이지 번호
		int totalCount = 0; //총 게시물 수
		int pageSize = 10; //한 페이지 당 출력 갯수
		int totalPage = 0 ; //총 페이지수
		int begin = 0; //rnum 시작번호
		int end = 0; //rnum 끝번호
		int n =0 ;	//페이지바 관련 변수
		int loop=0;	//페이지바 관련 변수
		int blockSize=10;	//페이지바 관련 변수
		
		//list.do -> list.do?page = 1 변경
		//list.do?page =3 

		String page= req.getParameter("pag");
		if(page==null || page =="") nowPage = 1;//default
		else nowPage = Integer.parseInt(page);
		
		//nowpage -> 보려는 페이지 번호!
		//1page -> where rnum >= 1 and rnum <= 10
		//2page -> where rnum >= 11 and rnum <= 20
		//2page -> where rnum >= 21 and rnum <= 30
		begin = ((nowPage-1)*pageSize)+1;
		end = begin + pageSize -1;
		
		map.put("begin",begin+"");
		map.put("end",end+"");
		
	BoardDAO dao = new BoardDAO();
	
		//총 페이지 수 계산하기
		//총 페이지 수 = 총 게시물 수 / 한페이지당 출력 게시물 수
		// ? = 175 / 10 -> 17.5 -> 18
	
	totalCount = dao.getTotalCount(map);
	ArrayList<BoardDTO> dto = dao.getList(map);
	dao.close();
	
	totalPage = totalCount/blockSize+1;
	
	String pagebar = "";
	loop=1;
	n=1;
	pagebar += "<nav class=\"pagebar \">";
	pagebar += "<ul class=\"pagination paging\">";
	
	//이전 10 페이지
	if(n==1) {
	pagebar += "<li class='disabled pagingBtn' id='prevbtn' >";
	pagebar += "<a href=\"#!\" aria-label=\"Previous\">";
	pagebar += "<span aria-hidden=\"true\">&laquo;</span>";
	pagebar += "</a>";
	pagebar += "</li>";
	}
	else {
	pagebar += "<li class='pagingBtn'>";
	pagebar += String.format("<a href=\"/chanBoard/board/list.do?pag=%d\" aria-label=\"Previous\">",n-1);
	pagebar += "<span aria-hidden=\"true\">&laquo;</span>";
	pagebar += "</a>";
	pagebar += "</li>";
	}
	
	
	//페이지 번호
//	for(int i=1;i<totalPage;i++) {
	while(!(loop>blockSize||n>totalPage)) {
	if(n == nowPage) {
	pagebar += "<li class='active pagingBtn'>";
	pagebar += String.format("<a href=\"#!\">%d</a>",n);
	pagebar += "</li>";
	}
	else {
	pagebar += "<li class='pagingBtn'>";
	pagebar += String.format("<a href=\"/chanBoard/board/list.do?pag=%d\">%d</a>",n,n);
	pagebar += "</li>";
	}
	loop++;
	n++;
//	}
	}

	//다음 10페이지
	if(n>totalPage) {
	pagebar += "<li class='disabled pagingBtn'>";
	pagebar += "<a href=\"#!\" aria-label=\"Next\">";
	pagebar += "<span aria-hidden=\"true\">&raquo;</span>";
	pagebar += "</a>";
	pagebar += "</li>";
	
	pagebar += "</ul>";
	pagebar += "</nav>";
	}
	else {
	pagebar += "<li class='pagingBtn'>";
	pagebar += String.format("<a href=\"/chanBoard/board/list.do?pag=%d\" aria-label=\"Next\">",n);
	pagebar += "<span aria-hidden=\"true\">&raquo;</span>";
	pagebar += "</a>";
	pagebar += "</li>";
	
	pagebar += "</ul>";
	pagebar += "</nav>";
	}
	
	req.setAttribute("totalCount", totalCount);
	req.setAttribute("totalPage", totalPage);
	
	req.setAttribute("pagebar", pagebar);
	req.setAttribute("dto", dto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
	dispatcher.forward(req, resp);
	}

}

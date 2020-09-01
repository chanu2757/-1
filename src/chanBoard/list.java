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
		
	HashMap<String,String> map = new HashMap<String,String>();
	
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

		String page= req.getParameter("page");
		
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
	ArrayList<BoardDTO> dto = dao.getList();
	dao.close();
	
	req.setAttribute("dto", dto);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
	dispatcher.forward(req, resp);
	}

}

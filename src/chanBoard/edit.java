package chanBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/edit.do")
public class edit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String seq = req.getParameter("seq");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getview(seq);
		dao.close();
		
		
		req.setAttribute("dto", dto);
		req.setAttribute("seq", seq);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
	}
}

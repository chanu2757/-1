package chanBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/writeOk.do")
public class writeok extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BoardDTO getdto = new BoardDTO();
		
		getdto.setSubject(req.getParameter("subject"));
		getdto.setContent(req.getParameter("content"));
		getdto.setWriter(req.getParameter("writer"));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.write(getdto);
		dao.close();
		if(result ==1) {
			//게시글 쓰기 성공
			resp.sendRedirect("../board/list.do");
		}
		else {
			//게시글 쓰기 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed'); history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}
		
	}
}

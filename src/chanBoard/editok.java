package chanBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/editOk.do")
public class editok extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO(); 
		
		dto.setSeq(req.getParameter("seq"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.editB(dto);
		dao.close();
		if(result ==1) {
			//게시글 수정 성공
			resp.sendRedirect("../board/list.do");
		}
		else {
			//게시글 수정 실패
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

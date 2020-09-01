package chanBoard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/deleteOk.do")
public class deleteOk extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String seq = req.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		int result = dao.byeB(seq);
		
		if(result ==1) {
			//게시글 삭제 성공
			resp.sendRedirect("../board/list.do");
		}
		else {
			//게시글 삭제 실패
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

package chanBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import oracle.net.aso.l;


public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardDAO() {
		DBUtil util = new DBUtil();
		conn = util.open("localhost","chanboard","java1234");
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close

	public ArrayList<BoardDTO> getList() {
		try {			
			String sql = "select * from vwboardlist b order by rnum desc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setRownum(rs.getString("rnum"));
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				
				list.add(dto);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BoardDTO getview(String postseq) {
		try {
			
			String sql = "select * from tblBoard";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			while(rs.next()) {
		
				BoardDTO dto = new BoardDTO();
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewcnt(rs.getInt("viewcnt"));
				
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 김찬우
	 * @param getdto 제목,글쓴이,내용을 가진 dto를 가져온다
	 * @return insert문의 실행 결과가 반환된다.
	 * DB에 게시글을 추가한다.
	 */
	public int write(BoardDTO getdto) {
		try {
			String sql = "insert into tblboard values(seqBoard.nextVal,?,?,?,default,default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, getdto.getSubject());
			pstat.setString(2, getdto.getWriter());
			pstat.setString(3, getdto.getContent());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int editB(BoardDTO dto) {
		try {
			String sql = "update tblBoard set subject=?, content=? where seq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int byeB(String seq) {
		try {
			String sql="delete tblBoard where seq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalCount(HashMap<String, String> map) {
		try {
			String sql = "select count(*) as cnt from tblBoard";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			int cnt;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				return cnt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return 0;
	}
	
}

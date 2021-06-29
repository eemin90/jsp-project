package project.service.member;

import java.sql.Connection;

import project.bean.Member;
import project.dao.BoardDao;
import project.dao.CommentDao;
import project.dao.MemberDao;
import project.util.DBConnection;

public class MemberService {
	
	private BoardDao bdao = null;
	private MemberDao mdao = null;
	private CommentDao cdao = null;
	
	public MemberService() {
		this.bdao = new BoardDao();
		this.mdao = new MemberDao();
		this.cdao = new CommentDao();
	}
	
	public void remove(String id) {
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false); // auto commit을 off
			
			this.bdao.removeByMember(id, con); // member id의 foreign key인 board memberId를 먼저 삭제
			this.mdao.remove(id, con);
			
			con.commit(); // 위 메소드 2개가 전부 실행에 성공하면 commit
		} catch (Exception e) {
			e.printStackTrace();
			DBConnection.rollback(con); // 오류가 나는 경우는 rollback
		} finally {
			DBConnection.close(con); // 사용 후 connection을 close
		}
	}

	public Member getMember(String id) {
		Connection con = null;
		
		try {
			con = DBConnection.getConnection();
			
			Member member = this.mdao.getMember(id, con);
			
			int numBoard = this.bdao.getNumberOfBoard(id, con);
			int numComment = this.cdao.getNumberOfComment(id, con);
			
			member.setNumberOfBoard(numBoard);
			member.setNumberOfComment(numComment);
			
			return member;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con);
		}
		
		return null;
	}
}

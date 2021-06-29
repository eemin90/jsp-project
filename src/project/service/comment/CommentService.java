package project.service.comment;

import java.sql.Connection;
import java.util.List;

import project.bean.Comment;
import project.dao.CommentDao;
import project.util.DBConnection;

public class CommentService {

	private static CommentDao dao;
	
	static {
		dao = new CommentDao();
	}
	
	public void add(Comment commentBean) {
		Connection con = DBConnection.getConnection();
		
		dao.insert(commentBean, con);
		
		DBConnection.close(con);
	}

	public List<Comment> list(int boardId) {
		Connection con = DBConnection.getConnection();
		
		List<Comment> list = dao.list(boardId, con);
		
		DBConnection.close(con);
		
		return list;
	}

	public void modify(Comment comment) {
		Connection con = DBConnection.getConnection();
		
		dao.modify(comment, con);
		
		DBConnection.close(con);
	}

	public void remove(int commentId) {
		Connection con = DBConnection.getConnection();
		
		dao.remove(commentId, con);
		
		DBConnection.close(con);
	}

}

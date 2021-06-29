package project.controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bean.Comment;
import project.service.comment.CommentService;

/**
 * Servlet implementation class ProjectCommentModifyServlet
 */
@WebServlet("/project/comment/modify")
public class ProjectCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CommentService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectCommentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	service = new CommentService();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("commentId");
		String commentStr = request.getParameter("comment");
		String boardId = request.getParameter("boardId");
		
		Comment comment = new Comment();
		comment.setId(Integer.parseInt(idStr));
		comment.setComment(commentStr);
		
		service.modify(comment);
		
		String path = request.getContextPath() + "/project/board/detail?id=" + boardId;
		response.sendRedirect(path);
	}

}

package project.controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.comment.CommentService;

/**
 * Servlet implementation class ProjectCommentRemoveServlet
 */
@WebServlet("/project/comment/remove")
public class ProjectCommentRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CommentService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectCommentRemoveServlet() {
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
		String commentId = request.getParameter("commentId");
		String boardId = request.getParameter("boardId");
		
		service.remove(Integer.parseInt(commentId));
		
		String path = request.getContextPath() + "/project/board/detail?id=" + boardId;
		response.sendRedirect(path);
	}

}

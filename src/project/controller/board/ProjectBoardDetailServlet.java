package project.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bean.Board;
import project.bean.BoardDto;
import project.bean.Comment;
import project.dao.BoardDao;
import project.service.comment.CommentService;

/**
 * Servlet implementation class ProjectBoardDetailServlet
 */
@WebServlet("/project/board/detail")
public class ProjectBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService commentService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	commentService = new CommentService();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id == null) {
			String path = request.getContextPath() + "/project/board/list";
			response.sendRedirect(path);
		} else {
			BoardDao dao = new BoardDao();
//			Board board = dao.get(Integer.parseInt(id));
			BoardDto board = dao.get2(Integer.parseInt(id));
			
			List<Comment> commentList = commentService.list(Integer.parseInt(id));
			
			request.setAttribute("board", board);
			request.setAttribute("comments", commentList);
			
			String path = "/WEB-INF/project/board/detail.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

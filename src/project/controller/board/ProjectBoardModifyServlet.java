package project.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bean.Board;
import project.bean.BoardDto;
import project.bean.Member;
import project.dao.BoardDao;

/**
 * Servlet implementation class ProjectBoardModifyServlet
 */
@WebServlet("/project/board/modify")
public class ProjectBoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectBoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// request parameter 수집
		String boardId = request.getParameter("boardId");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		// DB에서 게시물 조회
		BoardDao dao = new BoardDao();
		BoardDto board = dao.get2(Integer.parseInt(boardId));
		
		// 로그인 된 유저 정보
		Member member = (Member) request.getSession().getAttribute("userLogined");
		
		// 로그인 유저와 게시물 작성자가 같은지
		if (board.getMemberId().equals(member.getId())) {
			// 같은면 수정
			BoardDto newBoard = new BoardDto();
			newBoard.setBoardId(Integer.parseInt(boardId));
			newBoard.setTitle(title);
			newBoard.setBody(body);
			
			boolean ok = dao.modify(newBoard);
			
			if (ok) {
				request.getSession().setAttribute("modifyMsg", "수정되었습니다.");
			} else {
				request.getSession().setAttribute("modifyFailedMsg", "수정 시 오류 발생.");
			}
		} else {
			// 같지 않으면 메시지 남기고 
			request.getSession().setAttribute("message", "작성자가 아닙니다.");
			
		}
		
		String path = request.getContextPath() + "/project/board/detail?id=" + boardId;
		response.sendRedirect(path);
	}

}

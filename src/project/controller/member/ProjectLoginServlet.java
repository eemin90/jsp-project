package project.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.bean.Member;
import project.dao.MemberDao;

/**
 * Servlet implementation class ProjectLoginServlet
 */
@WebServlet("/project/member/login")
public class ProjectLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/project/member/login.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request parameter 수집
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// dao.getMember 메소드 호출
		MemberDao dao = new MemberDao();
		Member member = dao.getMember(id);
		
		if (member != null && member.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogined", member);
			String path = request.getContextPath() + "/project/main";
			response.sendRedirect(path);
		} else {
			String path = "/WEB-INF/project/member/login.jsp";
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}

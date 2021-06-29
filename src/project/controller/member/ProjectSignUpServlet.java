package project.controller.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.bean.Member;
import project.dao.MemberDao;

/**
 * Servlet implementation class ProjectSignUpServlet
 */
@WebServlet("/project/member/signup")
public class ProjectSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/project/member/signup.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		
		// request parameter 수집
		String id = request.getParameter("id");
		String password= request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		
		// member bean 완성
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(Date.valueOf(birth));
		
		// dao.insert 메소드 호출
		MemberDao dao = new MemberDao();
		boolean ok = dao.insert(member);
		
		// forward or redirect
		if (ok) {
			String path = request.getContextPath() + "/project/main";
			response.sendRedirect(path);
		} else {
			request.setAttribute("message", "가입 실패");
			
			String path = "/WEB-INF/project/member/signup.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}

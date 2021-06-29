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
 * Servlet implementation class ProjectModifyServlet
 */
@WebServlet("/project/member/modify")
public class ProjectModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectModifyServlet() {
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
//		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(Date.valueOf(birth));
		
		MemberDao dao = new MemberDao();
		boolean ok = dao.update(member);
		
		String message = "";
		
		if (ok) {
			message = "변경 완료";
			request.setAttribute("modifyMsg", message);
		} else {
			message = "변경 실패";
			request.setAttribute("modifyFailedMsg", message);
		}
		
		// 변경한 정보를 다시 조회해서 forward 할 때 다시 보여주도록 전달
		Member mem = dao.getMember2(member.getId());
		
		request.setAttribute("member", mem);
		
		String path = "/WEB-INF/project/member/info.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}

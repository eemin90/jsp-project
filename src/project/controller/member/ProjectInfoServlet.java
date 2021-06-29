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
import project.service.member.MemberService;

/**
 * Servlet implementation class ProjectInfoServlet
 */
@WebServlet("/project/member/info")
public class ProjectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	service = new MemberService();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userLogined");
		
		// 세션 정보가 바뀌어 있을 수도 있으므로 재조회
		// 세션 정보가 없는 경우 main으로 redirect
		if (member != null) {
			MemberDao dao = new MemberDao();
//			Member mem = dao.getMember(member.getId());
//			Member mem = dao.getMember2(member.getId());
			
			Member mem = service.getMember(member.getId());
			
			request.setAttribute("member", mem);
			
			String path = "/WEB-INF/project/member/info.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			String path = request.getContextPath() + "/project/main";
			response.sendRedirect(path);
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

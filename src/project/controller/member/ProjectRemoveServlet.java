package project.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.bean.Member;
import project.service.member.MemberService;

/**
 * Servlet implementation class ProjectDeleteServlet
 */
@WebServlet("/project/member/remove")
public class ProjectRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberService service = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	this.service = new MemberService();
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
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userLogined");

		this.service.remove(member.getId());
		
		session.invalidate();
		
		String path = request.getContextPath() + "/project/main";
		response.sendRedirect(path);
	}

}

package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;

/**
 * Servlet implementation class checkLogin
 */
//@WebServlet("/login/check.do")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
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
		MemberDTO dto = new MemberDTO();

		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		
		dto = MemberDAO.getInstance().checkLogin(dto);
		
		boolean check = false;
		String msg = null;
		
		HttpSession session = request.getSession();
		
		if(dto != null){
			check = true;
			msg = dto.getName() + "님이 로그인 되었습니다.";
			
			session.setAttribute("login", dto);
			
			String ckid = request.getParameter("ckid");
			
			if(ckid != null){
				Cookie ck = new Cookie("ckid",dto.getId());
				ck.setMaxAge(60*60*24);
				response.addCookie(ck);
			}else{
				Cookie[] cks = request.getCookies();
				
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(dto.getId())){
								ck.setMaxAge(0);
								response.addCookie(ck);
							}
							break;
						}
					}
				}
			}
		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		
		//pageContext.forward("/login/result.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/login/result.jsp");
		
		rd.forward(request, response);
	}

}

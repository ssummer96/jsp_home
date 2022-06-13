package member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class CheckJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3")); 	

		MemberDAO dao = MemberDAO.getInstance();
		
		boolean check = dao.insert(dto);
		
		String msg = null;
		String url = null;
		
		if(check){
			msg = "회원 가입에 성공하셧습니다..로그인페이지로..";
			url = "/MyHome/login/login.jsp?id=" + dto.getId();
		}else{
			msg = "회원가입에 실패하셨습니다...이전페이지로..'";
			url = "/MyHome/member/join.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
	}

}

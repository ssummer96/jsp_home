package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class CheckAction implements Action {
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		MemberDTO dto = new MemberDTO();

		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		
		dto = MemberDAO.getInstance().checkLogin(dto);
		
		boolean check = false;
		String msg = null;
		
		HttpSession session = request.getSession();
		
		if(dto != null){
			check = true;
			msg = dto.getName() + "���� �α��� �Ǿ����ϴ�.";
			
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
			msg = "���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�.";
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		
	}
}


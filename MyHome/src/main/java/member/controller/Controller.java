package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.CheckAction;
import login.action.FormAction;
import login.action.LogoutAction;
import member.action.DeleteAction;
import member.action.CheckJoinAction;
import member.action.UpdateAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.me")
public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action action = null;
		ActionForward actionForward = null;
		
		String requestURL = request.getRequestURL().toString();
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".me");
		
		String path = requestURL.substring(start + 1,end);
		
		switch(path) {
		case "join":
			actionForward = new ActionForward("/MyHome/member/join.jsp", true);
			break;
		case "checkJoin":
			action = new CheckJoinAction();
			actionForward = new ActionForward("/member/result.jsp", false);
			break;
		case "myPage":
			actionForward = new ActionForward("/MyHome/member/myPage.jsp", true);
			break;
		case "updateForm":
			actionForward = new ActionForward("/MyHome/member/updateForm.jsp", true);
			break;
		case "deleteForm":
			actionForward = new ActionForward("/MyHome/member/deleteForm.jsp", true);
			break;
		case "checkUpdate":
			action = new UpdateAction();
			actionForward = new ActionForward("/member/result.jsp", false);
			break;
		case "checkDelete":
			action = new DeleteAction();
			actionForward = new ActionForward("/member/result.jsp", false);
			break;
		
		}
		
		
		if(action != null) {
			action.execute(request, response);
		}
		
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}
}

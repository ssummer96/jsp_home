<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<%--
	request.setCharacterEncoding("UTF-8");
	MemberDTO login = (MemberDTO)session.getAttribute("login");
	//dto.setEmail(request.getParameter("email"));
	//dto.setTel1(request.getParameter("tel1"));
	//dto.setTel2(request.getParameter("tel2"));
	//dto.setTel3(request.getParameter("tel3"));
	
	MemberDTO dto = new MemberDTO();
	dto.setNo(login.getNo());
	dto.setEmail(request.getParameter("email"));
	dto.setTel1(request.getParameter("tel1"));
	dto.setTel2(request.getParameter("tel2"));
	dto.setTel3(request.getParameter("tel3"));
	
	
	boolean check = MemberDAO.getInstance().updateMember(dto);
	
	
	out.write("<script>");
	if(check){
		//session.setAttribute("login", login);
		//login.setEmail(request.getParameter("email"));
		//login.setTel1(request.getParameter("tel1"));
		//login.setTel2(request.getParameter("tel2"));
		//login.setTel3(request.getParameter("tel3"));
		out.write("alert('수정완료!!MyPage로...');");
		out.write("location.href = '/MyHome/member/myPage.do';");
	}else{
		out.write("alert('수정실패!!이전페이지로...');");
		out.write("location.href = '/MyHome/member/updateForm.do';");
	}
	out.write("</script>");
	
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<div align="center">
	<table class = "table">
		<tr>
			<th>번호</th>
			<th>글제목</th>
			<th>아이디</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${list != null }">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.seq }</td>
						<td><a href="/MyHome/board/content.brd?seq=${dto.seq }">${dto.title }</a></td>
						<td>${dto.id }</td>
						<td>${dto.logtime }</td>
						<td>${dto.hit }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="5">
						작성한 글이 없습니다.
					</th>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<c:if test="${login != null }">
		<div class="button">
			<button onclick="location.href='/MyHome/board/write.brd'">글쓰기</button>
		</div>
	</c:if>
		<c:if test="${start > 10 }">
		<a href = "/MyHome/Board/BoardList.jsp?start=${start-10 }" id = "link">[이전]</a>
	</c:if>
	<c:if test="${start > 5 }">
		<a href = "/MyHome/Board/BoardList.jsp?start=${start-5 }" id = "link">[${nowPage - 1 }]</a>
	</c:if>
	[${nowPage }]
	<c:if test="${start + 5 <= total }">
		<a href = "/MyHome/Board/BoardList.jsp?start=${start+5 }" id = "link">[${nowPage + 1 }]</a>
	</c:if>
	<c:if test="${start + 10 <= total }">
		<a href = "/MyHome/Board/BoardList.jsp?start=${start+10 }" id = "link">[다음]</a>
	</c:if>
</div>
<%@ include file="/layout/footer.jsp" %>
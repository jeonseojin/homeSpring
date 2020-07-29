<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user==null}">
	<form method="post" action="<%=request.getContextPath()%>/">
		<div class="signin-box">
			<h1>
				로 그 인 
			</h1>
			<div class="signin-input">
				<input type="text" class="form-control" name="id" placeholder="아이디">
			</div>
			<div class="signin-input">
				<input type="password" class="form-control" name="pw" placeholder="비밀번호">
			</div>
			<button type="submit" class="btn btn-success">로 그 인</button>
			
			<input type="hidden" value="${isLogin}" id="isLogin">
			<input type="hidden" value="${id}" id="id">
		</div>
	</form>
</c:if>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${user == null}">
<head>
	<title>Home</title>
</head>
	<form action="<%=request.getContextPath()%>/" method="POST">
		<div class="login-con">
			<h1>
				로 그 인 
			</h1>
			<div class="login-box">
				<input type="text" class="form-control" name="id" placeholder="아이디">
			</div>
			<div class="login-box">
				<input type="password" class="form-control" name="pw" placeholder="비밀번호">
			</div>
				<button type="submit" class="btn btn-success">로 그 인</button>
				
			
			<input type="hidden" value="${isLogin}" id="isLogin">
			<input type="hidden" value="${id}" id="id">
		</div>
	</form>
</c:if>

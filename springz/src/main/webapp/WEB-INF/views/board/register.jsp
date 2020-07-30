<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath()%>/board/register" method="post" >

        <div class="reg-box">
        	<input type="text" class="form-control reg-title" name="title" placeholder="제목을 입력하세요.">
        </div>

	<div class="board-content detail form-group">
		<textarea class="form-control modify reg-text" name="content">${board.content}</textarea>
		<input type="file" class="form-control-file border"name="file">
	</div>
	<a href="<%=request.getContextPath() %>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}" class="btn-board left"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	<button class="btn btn-success float-right">전송</button>
</form>
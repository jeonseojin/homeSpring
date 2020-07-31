<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${board.isDel=='N'.charAt(0)}">
	<form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
		<table class="table table-hover">
			<thead>
		    	<tr class="mo-box">
			        <th class="vn-box">${board.num}</th>
			        <th class="mo-title">제목:</th>
			        <th class="title-box"><input class="form-control mo-input" name="title" value="${board.title}"></th>
			        <th class="mo-date">${board.registerDate}</th>
			        <th class="vn-box">${board.views}</th>
				</tr>
			</thead>
			<tbody>
				<tr></tr>
			</tbody>
		</table>
		<div class="board-content detail form-group">
			<textarea  class="content-box reg-text" rows="5" name="content">${board.content}</textarea>
		</div>
		<c:if test="${board.file != null}">
			<div>
				<span class="fine-name"></span>
				<span class="btn-file-del"><i class="fas fa-times"></i></span>
				<input type="hidden" name="file" value="${board.file}">
			</div>
		</c:if>
		<div class="board-add-file detail form-group">
				<input type="file" name="file2">
		</div>
		<a href="<%=request.getContextPath() %>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}" class="btn-board left"><button type="button" class="btn btn-outline-secondary">목록</button></a>
		<button class="btn btn-outline-info btn-board float-right">수정하기</button>
		<input type="hidden" name="num" value="${board.num}" readonly>
		<input type="hidden" name="writer" value="${board.writer}" readonly>
		<input type="hidden" name="registerDate" value="${board.registerDate}" readonly>
		<input type="hidden" name="views" value="${board.views}" readonly>
	</form>
</c:if>
<script>
	$(function(){
		$('.btn-file-del').click(function(){
			$('.board-file').empty();
		})
		$('input[name=file2]').chang(function(){
			if($('input[name=file]').val()==null || typeof($('input[name=file]').val()=='undefined')
					return;
			$(this).val('');
			alert('첨부파일은 하나만 추가 가능합니다. 기존 첨부파일을 삭제하세요.')
		})
	})
</script>
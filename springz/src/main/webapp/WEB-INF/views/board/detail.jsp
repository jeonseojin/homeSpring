<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form>
    <c:if test="${board eq null}">
    	<h1>해당 게시물은 없는 게시물입니다.</h1>
    </c:if>
    <c:if test="${board ne null}">
    	<c:if test="${board.isDel == 'Y'.charAt(0)}">
    		<h1>해당 게시물은 삭제되었습니다.</h1>
    	</c:if>
    	<c:if test="${board.isDel == 'N'.charAt(0)}">        
			<table class="table table-hover">
				<thead>
			    	<tr>
				        <th class="vn-box">${board.num}</th>
				        <th>작성자: ${board.writer}</th>
				        <th class="mo-title">제목:</th>
				        <th class="title-box">${board.title}</th>
				        <th>${board.registerDate}</th>
				        <th class="vn-box">${board.views}</th>
					</tr>
			    </thead>
			    <tbody>
					<tr></tr>
				</tbody>
			</table>
			<c:if test="${board.file!=null}"><a class="float-right" href="<%=request.getContextPath()%>/board/download?fileName=${board.file}">${board.oriFile}</a></c:if>
			<div class="content-box bot">
	  			<div class="content-size">${board.content}</div>
	  			<div class="content-center">
	  				<div class="btn-like"><i class="far fa-thumbs-up"></i></div>
	  				<div class="content-up">${board.up}</div>
	  			</div>
	  		</div>
    	<a href="<%=request.getContextPath() %>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}" class="btn-board left"><button type="button" class="btn btn-outline-secondary">목록</button></a>
			<c:if test="${user != null }">
				<div class="float-right">
					<c:if test="${user.id == board.writer}">
						<a href="<%=request.getContextPath() %>/board/modify?num=${board.num}" class="btn-board"><button type="button" class="btn btn-outline-info">수정</button></a>
						<a href="<%=request.getContextPath() %>/board/delete?num=${board.num}" class="btn-board"><button type="button" class="btn btn-outline-danger">삭제</button></a>
					</c:if>
				</div>
			</c:if>
		</c:if>
	</c:if>
</form>
<input type="hidden" id="num" value="${board.num }">
<script>
	$(function(){
		$('.btn-like').click(function(){
			var num = $('#num').val();
			$.ajax({
		        async:true,
		        type:'POST',
		        data:num,
		        url:"<%=request.getContextPath()%>/board/up",
		        dataType:"json",
		        contentType:"application/json; charset=UTF-8",
		        success : function(data){
			        if(data['isUser']){
				        if(data['up']>0){
					        $('.text-like').text('추천 :'+data['up'])
					    }else{
					    	alert('이미 추천한 게시물입니다.');
					    }
					}else{
				        alert('추천은 로그인을 해야 가능합니다.');
					 }	    
		        }
		       
	    });
	})
})
</script>
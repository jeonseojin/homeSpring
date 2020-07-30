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
    		<h2>자유게시판</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
        <th class="vn-box">${board.num}</th>
        <th>작성자: ${board.writer}</th>
        <th class="title-box">${board.title}</th>
        <th>${board.registerDate}</th>
        <th class="vn-box">${board.views}</th>
      </tr>
    </thead>
    <tbody>
		<tr></tr>
    </tbody>
  </table>
  	<div  class="content-box">${board.content}</div>
    	<a href="<%=request.getContextPath() %>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}" class="btn-board left"><button type="button" class="btn btn-outline-secondary">목록</button></a>
			<c:if test="${user != null }">
				<div class="float-right">
					<c:if test="${user.id == board.writer}">
						<a href="<%=request.getContextPath() %>/board/modify?num=${board.num}" class="btn-board mama"><button type="button" class="btn btn-outline-info">수정</button></a>
						<a href="<%=request.getContextPath() %>/board/delete?num=${board.num}" class="btn-board mama"><button type="button" class="btn btn-outline-danger">삭제</button></a>
					</c:if>
				</div>
			</c:if>
		</c:if>
	</c:if>
</form>
<input type="hidden" id="num" value="${board.num }">
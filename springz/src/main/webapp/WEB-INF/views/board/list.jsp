<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2>자유게시판</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>조회수</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
	    <c:if test="${list.size() != 0 }">
		    <c:forEach var="board" items="${list}">
			    <tr>
					<td>${board.num}</td>
					<td>${board.views}</td>
					<td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}&page=${pm.cri.page}&type=${pm.cri.type}&search=${pm.cri.search}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.registerDate}</td>
			    </tr>
			</c:forEach>
		</c:if>
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
		</c:if>
    </tbody>
  </table>
  	<ul class="pagination float-right">
		<li>
			<c:if test="${user != null }">
				<a href="<%=request.getContextPath() %>/board/register" class="btn-board"><button type="button" class="btn btn-outline-success">글쓰기</button></a>
			</c:if>
		</li>
	</ul>
<!-- 페이지네이션 -->
	<ul class="pagination justify-content-center" style="margin:20px 0">
		<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.cri.type}&search=${pm.cri.search}"><i class="fas fa-chevron-left"></i></a></li>
		<c:forEach var="index" begin="${pm.startPage}" end="${pm.endPage}">
			<li class="page-item <c:if test="${index==pm.cri.page}">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.cri.type}&search=${pm.cri.search}">${index}</a></li>
		</c:forEach>
		<li class="page-item <c:if test="${!pm.next}">disabled</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.cri.type}&search=${pm.cri.search}"><i class="fas fa-chevron-right"></i></a></li>
		
	</ul>

<!-- 검색창 -->
<form action="<%=request.getContextPath()%>/board/list">
	<div class="input-group mb-3">
		<select class="form-control" id="sell" name="type">
			<option value="0" <c:if test="${pm.cri.type==0}">selected</c:if>>전체</option>
			<option value="1" <c:if test="${pm.cri.type==1}">selected</c:if>>작성자</option>
			<option value="2" <c:if test="${pm.cri.type==2}">selected</c:if>>제목</option>
			<option value="3" <c:if test="${pm.cri.type==3}">selected</c:if>>내용</option>
		</select>
		<input type="text" class="form-control" placeholder="Search" name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-success" type="submit">검색</button>
		</div>
	</div>
</form>

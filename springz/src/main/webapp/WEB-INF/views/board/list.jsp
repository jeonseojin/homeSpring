<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath()%>/board/detail?num=${board.num}">
<h2>게시판</h2>
  <p>${user.id}</p>            
  <table class="table table-dark">
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
      <tr>
        <th>${board.num}</th>
        <th>${board.views}</th>
        <th>${board.title}</th>
        <th>${board.writer}</th>
        <th>${board.registerDate}</th>
      </tr>
    </tbody>
  </table>
  
</form>
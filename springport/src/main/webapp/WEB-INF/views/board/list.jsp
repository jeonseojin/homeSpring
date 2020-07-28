<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>게시판</h2>
  <p>자유게시판 입니다.</p>            
  <table class="table">
    <thead>
      <tr>
	    <th>번호</th>
        <th class="title-w">제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <!-- c:의 형태인 spring코드를 통해서 작업 
	    <c:if test="${list.size()!=0}">
		   <tr>
			   <td>${board.num}</td>
			   <td>
			   <a href="<%=request.getContextPath()%>/baord/detail?num=${board.num}">${board.title}</a></td>
			   <td>${board.writer}</td>
			   <td>${board.registerDate}</td>
			   <td>${board.views}</td>
		   </tr>
	     </c:if> -->
	     <tr>
			   <td>1</td>
			   <td>
			   <a href="#">ㅇㅇㅇㅇㅇㅇㅇㅇㅇ</a></td>
			   <td>ㅇㅇㅇ</td>
			   <td>ㅇㅇㅇㅇㅇㅇ</td>
			   <td>ㅇㅇㅇㅇㅇㅇ</td>
		   </tr>
    </tbody>
  </table>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="height: 800px">
	<h1>
		Hello world!  
	</h1>
	<P> 메인화면</P>
	<button id="ajax">버튼</button>
</div>


<script>
$(function(){
	$('#ajax').click(function(){
	    $.ajax({
	        async:true,
	        type:'POST',
	        data:JSON.stringify({"id":"123","num":"456"}),
	        url:"<%=request.getContextPath()%>/test",
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : function(data){
	            console.log(data['res']);
	        }
	    });
	})
})
	
</script>
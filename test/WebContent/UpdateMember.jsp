<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int point = Integer.parseInt(request.getParameter("point"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<script>
	function ok(){
		alert("수정되었습니다!");
	}
</script>
</head>
<body>
	<h1>회원관리 - 수정관리자</h1>
	<form action = "Controller">
		ID : <input type="text" name = "id" readonly value="<%=id%>" style="margin-left:27px;"/><br/>
		PW : <input type="text" name = "pw" value="<%=pw%>" style="margin-left:19px;"/><br/>
		Name : <input type="text" name = "name" value="<%=name%>"/><br/>
		Point : <input type="text" name = "point" value="<%=point%>" style="margin-left:6px;"/><br/>
		<input type="hidden" name="command" value="updateM"/>
		<input type="submit" value="제출" style="width:232px;margin:3px;" onclick="ok();"/>
	</form>
</body>
</html>
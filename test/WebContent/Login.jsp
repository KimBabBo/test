<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#idCheck{
		margin-left:8px;
	}
	#loginBtn{
		margin:3px;
		width:212px;
	}
	#registerBtn{
		margin:3px;
		width:212px;
	}
</style>
<script>
	<%
	String denied = request.getParameter("denied");
	if (denied != null && denied.equals("x")) {
		%>
		    alert("아이디/비밀번호를 다시 확인하세요");
		<%
	}
	%>
</script>


</head>
<body>
	<h1>로그인</h1>
	<form action="Controller">
		ID : <input type = "text" id="idCheck" name="id"/>	<br/>
		PW : <input type = "password" id="pwCheck" name="pw"/> <br/>
		<input type="submit" value = "로그인" id="loginBtn"/><br/>
		<input type="hidden" name = "command" value="login"/>
	</form>
	<a href="Register.jsp">
		<input type="button" value = "회원가입" id="registerBtn"/>
	</a>
</body>
</html>
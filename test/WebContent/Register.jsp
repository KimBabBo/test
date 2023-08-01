<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#id{
		margin-left:27px;
	}
	#pw{
		margin-left:19px;
	}
	#BTN{
		margin:3px;
		width:232px;
	}
</style>
<script>
	function okRegi(){
		alert("가입되었습니다. 로그인 해주세요.");
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="Controller">
		ID : <input type = "text" id="id" name="id"/>	<br/>
		PW : <input type = "password" id="pw" name="pw"/> <br/>
		Name : <input type = "text" id="name" name="name"/> <br/>
		<input type="submit" value = "작성완료" id="BTN" onclick="okRegi();"/><br/>
		<input type="hidden" name = "command" value="register"/>
	</form>
</body>
</html>
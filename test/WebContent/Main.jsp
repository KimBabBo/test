<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String name ="";
	int point=0;
	if(request.getAttribute("point")!=null){
		point = (int)request.getAttribute("point");
	} else if(request.getAttribute("returnPoint")!=null){
		point = (int)request.getAttribute("returnPoint");
	}
	if(request.getAttribute("name")!=null){
	name = (String)request.getAttribute("name");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
	body{
		width:1100px;
		border:1px solid gray;
		padding :30px;
	}
	.mainImg{
		margin:3px;
	}
</style>
<script>
	function logout(){
		alert("로그아웃 되었습니다.");
	}
</script>
<script>
	<%
	if(request.getParameter("random")!=null){
		int random = Integer.parseInt(request.getParameter("random"));
		if (request.getParameter("random")!= null) {
			%>
			    alert(<%=random%>+"점이 적립되었습니다!");
			<%
		}
	}
	if(request.getParameter("result")!=null&&request.getParameter("result").equals("payDown")){
		%>
			alert("포인트가 부족합니다. 광고를 클릭하세요.")
		<%
	} else if(request.getParameter("result")!=null&&request.getParameter("result").equals("payUP")){
		String content = request.getParameter("content");
		%>
			alert("컨텐츠(<%=content%>)를 구입하였습니다.");
		<%
	}
	%>
	
</script>
</head>
<body>
	<span id="mainPage" style="font-size:33px; font-weight:800;">메인페이지</span>
	<div style="float:right; font-weight:600;">
		<span id="helloName"><%=name %>님 안녕하세요.</span>
		<a href="Login.jsp">
			<button onclick="logout();">로그아웃</button>
		</a>	<br/>
		<span>포인트 : <%=point %>점</span>
	</div>
	<div style="margin-top:30px;">
		<span style="font-size: 18px;font-weight: 600;">구입할 컨텐츠를 선택하세요.</span><br/>
		<div style="display:flex; margin:3px;">
			<div class="mainImg">
				<a href="Controller?command=buy&value=100000&name=<%=name %>">
					<img src = "Images/Intro_350_408.png">
				</a>
				<br/><span>100,000포인트</span>
			</div>
			<div class="mainImg">
				<a href="Controller?command=buy&value=500000&name=<%=name %>">
					<img src = "Images/Java_350_408.png">
				</a>
				<br/><span>500,000포인트</span>
			</div>
			<div class="mainImg">
				<a href="Controller?command=buy&value=300000&name=<%=name %>">
					<img src = "Images/Cpp_350_408.png">
				</a>
				<br/><span>300,000포인트</span>
			</div>
		</div>
	</div>

	<div style="border:1px solid gray; width:240px;margin-left:860px; margin-top:40px;">
			<span><% out.print("<광고>");%></span> <br/>
			<a href="Controller?command=adv&name=<%=name%>&point=<%=point%>">
				<img src="Images/korea_it.png">
			</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yg.dao.DBConnection" %>
<%@ page import="com.yg.dao.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>
<%
	DBConnection dbc = new DBConnection();
	ArrayList<MemberDTO> listMember = dbc.getAllBoardList();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
	body{
		padding:5px;
		width:600px;
		border:1px solid gray;
		padding:15px;
	}
	table{
		border: 1px solid black;
	    border-collapse: collapse;
	    padding:5px;
	}
	tr,th,td{
		border: 1px solid black;
	    border-collapse: collapse;
		padding:10px;
		width:584px;
	}
</style>
<script>
	<%if(request.getParameter("delete")!=null&&request.getParameter("delete").equals("ok")){%>
 		alert("삭제되었습니다.");	
	<%}%>
</script>
</head>
<body>
	<div style="display:flex;">
		<h1>회원관리</h1>
		<a href="Login.jsp" style="margin-left: 400px;margin-top: 33px;">
			<button>로그인</button>
		</a>
	</div>
	<table>
		<tr>
			<th>ID</th>
			<th>PW</th>		
			<th>Name</th>
			<th>Point</th>		
			<th>수정</th>		
			<th>삭제</th>		
		</tr>
		<%for(MemberDTO dto : listMember){ %>
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getPoint() %></td>
			<td>
				<form action="UpdateMember.jsp">
					<input type="submit" value="수정"/><br/>
					<input type="hidden" name="id" value="<%=dto.getId()%>"/>
					<input type="hidden" name="pw" value="<%=dto.getPw()%>"/>
					<input type="hidden" name="name" value="<%=dto.getName()%>"/>
					<input type="hidden" name="point" value="<%=dto.getPoint()%>"/>
				</form>
			</td>
			<td><a href="Controller?command=deleteM&id=<%=dto.getId()%>"><button>삭제</button></a></td>
		</tr>
		<%} %>
	</table>
	<br/>
	<h1>스케줄러관리</h1>
	<a href="Controller?command=start">
		<button>스케쥴러(20초마다 포인트1 증가) 실행 시작</button>
	</a>
	<a href="Controller?command=end">
		<button>스케쥴러 실행 종료</button>
	</a>
</body>
</html>
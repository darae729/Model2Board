<%@page import="org.sp.model2board.util.PoolManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	PoolManager pool=new PoolManager();
%>
<%
	//이름 검색 객체 생성
	Connection con=pool.getConnection(); //대여
	
	out.print(con);
	
	pool.release(con); //반납
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
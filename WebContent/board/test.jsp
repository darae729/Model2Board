<%@page import="java.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	InitialContext context = new InitialContext();

	for(int i=0;i<5;i++){
		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
		out.print(ds);
		out.print("<br>");
	}
	

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
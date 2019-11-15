<!DOCTYPE HTML>
<%
	Object obj = session.getAttribute("admin");
	if (obj != null) {
		if ((Integer) obj != 1)
			response.sendRedirect("adminlogin.jsp");
	} else
		response.sendRedirect("adminlogin.jsp");
%>
<html>
<head>
<title>Home | ADMIN</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">
	<%@include file="assets/adminnavbar.jsp"%>
	<!-- Banner -->
	<section id="banner">

		<br>
		<br>
		<br>
		<br>
		<br>

		<h2>Welcome Admin</h2>
		<p>Please Select Actions from Menu</p>
		<%
		if (request.getParameter("status") != null) {
			if (Integer.parseInt(request.getParameter("status")) == 1) {%>
		<font color="green">New Room Added</font>
		<%}else if (Integer.parseInt(request.getParameter("status")) == 2){ %>
		<font color="green">Password Changed Successfully.!</font>
		<%}else if (Integer.parseInt(request.getParameter("status")) == -1){ %>
		<b><font color="red">Something Wrong Happened...!</font></b>
		<%}}%>
		<br>
		<br>
	</section>

</body>
</html>
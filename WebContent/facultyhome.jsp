<!DOCTYPE HTML>
<%Object obj= session.getAttribute("faculty_id");
if(obj!=null){
	if((Integer)obj<=0)
		response.sendRedirect("facultylogin.jsp");
}
else
	response.sendRedirect("facultylogin.jsp");
%>
<html>
<head>
<title>Home | FACULTY</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

</head>
<body class="landing">

	<%@include file="assets/facultynavbar.jsp"%>

	<!-- Banner -->
	<section id="banner">
		<br>
		<br>
		<br>
		<br>
		<br>
		<h2>Welcome</h2>
		<p>Please Select Actions from Menu</p>
		<%	
					if(request.getParameter("status") != null){
						int faculty_id = (Integer)request.getAttribute("faculty_id");
						if(Integer.parseInt(request.getParameter("status")) == 1){ %>

		<font color="green">Registered Successfully with faculty id = <%=faculty_id %></font>
		<%}
						
						if(Integer.parseInt(request.getParameter("status"))==-1){%>

		<font color="red">Registration Failed click here to</font> <a
			href="registerfaculty.jsp">TRY AGAIN</a>
		<%}if(Integer.parseInt(request.getParameter("status"))==2){%>

		<font color="green">Password Successfully Changed</font>
		<%}} %>

		<br>
		<br>
	</section>



</body>
</html>
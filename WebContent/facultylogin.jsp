<!DOCTYPE html>
<%Object obj= session.getAttribute("faculty_id");
if(obj!=null){
	if((Integer)obj>0)
		response.sendRedirect("facultyhome.jsp");
}
%>
<html>
<head>
<title>Login | FACULTY</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

</head>

<body class="landing">
	<%@include file="assets/indexnavbar.jsp"%>

	<section id="four" class="wrapper style3 special">
		<div class="inner">
			<header class="major narrow">
				<h2>Login</h2>
				<p></p>
			</header>
			<form action="FacultyLoginSrv" method="GET">
				<div class="container 50%">

					<div class="container 100%">

						<div class="row uniform 75%">

							<div class="6u 12u$(xsmall)">

								<input name="faculty_email" placeholder="Email" type="email"
									required />
							</div>
							<div class="6u$ 12u$(xsmall)"></div>
							<div class="6u$ 12u$(xsmall)">
								<input name="faculty_password" placeholder="Password"
									type="password" required />
							</div>
						</div>
					</div>
				</div>
				<%
					if(request.getParameter("status")!=null){
						int status = Integer.parseInt(request.getParameter("status"));
					
						if(status == -1){%>
				<b><font color="red">Incorrect Login Details!</font></b><br>
				<%}else if(status == -2){%>
				<b><font color="yellow">Please Wait for Admin's Approval</font></b><br>
				<%}}%>
				<ul class="actions">
					<li><input type="submit" class="special" value="Submit" /></li>
					<li><input type="reset" class="alt" value="Reset" /></li>
				</ul>
				<br>
				<br>
			</form>
		</div>
	</section>

</body>
</html><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

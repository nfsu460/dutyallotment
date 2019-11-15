<!DOCTYPE html>
<%
	int faculty_id = 0;
	Object obj = session.getAttribute("faculty_id");
	if (obj != null) {
		faculty_id = (Integer) obj;
		if (faculty_id <= 0)
			response.sendRedirect("facultylogin.jsp");
	} else
		response.sendRedirect("facultylogin.jsp");
%>
<html>
<head>
<title>Change Password | FACULTY</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">

	<%@include file="assets/facultynavbar.jsp"%>
	<section id="four" class="wrapper special style1">
		<div class="inner">
			<header class="major narrow">
				<h2>CHANGE YOUR PASSWORD</h2>
				<p></p>
			</header>
			<div class="container 50%">
				<form action="FacultyChangePasswordSrv" method="POST">
					<p>Enter current Password</p>
					<input type="password" name="faculty_password"
						placeholder="Current Password"><br>

					<p>Enter New Password</p>
					<input type="password" name="new_password"
						placeholder="New Password"><br>

					<p>Re-enter new Password</p>
					<input type="password" name="confirm_password"
						placeholder="Confirm Password"><br> <input
						type="hidden" name="faculty_id" value="<%=faculty_id %>">

					<%
						if (request.getParameter("status") != null) {
							int status = Integer.parseInt(request.getParameter("status"));

							if (status == 1) {
					%>
					<font color="green">Password Successfully Changed</font>
					<%
						} else {
					%>
					<font color="red">Password not changed TryAgain!!</font>
					<%
						}
						}
					%>

					<ul class="actions">
						<li><input type="submit" class="special" value="Submit" /></li>
						<li><input type="reset" class="alt" value="Reset" /></li>
					</ul>

				</form>
			</div>
		</div>
	</section>

</body>
</html>
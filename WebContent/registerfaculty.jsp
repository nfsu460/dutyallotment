<!DOCTYPE html>
<html>
<head>
<title>Registration | FACULTY</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">

	<%@include file="assets/indexnavbar.jsp"%>
	<section id="four" class="wrapper special style3">
		<div class="inner">
			<header class="major narrow">
				<h2>REGISTER</h2>

			</header>
			<div class="container 50%">
				<%
					if(request.getParameter("status")!=null){
						int status = Integer.parseInt(request.getParameter("status"));
					
						if(status == -1){%>
				<b><font color="red">Some Error Occurred. Please Try
						Again!</font></b><br>
				<%}else if(status == 1){%>
				<b><font color="yellow">Registration Successfull! Please
						Wait for Admin's Approval</font></b><br>
				<%}}%>
				<form action="RegisterFacultySrv" method="POST">

					<b>Enter Name</b> <input type="text" name="faculty_name"
						placeholder="Name" required><br> <b>Enter Email</b> <input
						type="email" name="faculty_email" placeholder="Email" required><br>

					<b>Enter Mobile Number</b> <input type="text" name="faculty_mobile"
						placeholder="Mobile" required><br> <b>Enter
						Password</b> <input type="password" name="faculty_password"
						placeholder="Password" required><br>


					<ul class="actions">
						<li><input type="submit" class="special" value="Register" /></li>
						<li><input type="reset" class="alt" value="Reset" /></li>
					</ul>

				</form>
			</div>
		</div>
	</section>

</body>
</html>
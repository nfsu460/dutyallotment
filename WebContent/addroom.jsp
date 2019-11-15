<!DOCTYPE html>
<%
Object obj = session.getAttribute("admin");
if(obj!=null){
	if((Integer)obj != 1)
		response.sendRedirect("adminlogin.jsp");
}else
	response.sendRedirect("adminlogin.jsp");
%>
<html>
<head>
<title>Add Rooms | ADMIN</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">

	<%@include file="assets/adminnavbar.jsp"%>
	<section id="four" class="wrapper special style1">
		<div class="inner">
			<header class="major narrow">
				<h2>Add Room</h2>
				<p></p>
			</header>
			<div class="container 50%">
				<form action="AddRoomSrv" method="POST">

					<b>Enter Room Number</b> <input type="text" name="r_id"
						placeholder="Room Number" required><br> <b>Enter
						Department</b> <input type="text" name="r_department"
						placeholder="Department" required><br> <b>Enter
						Strength</b> <input type="text" name="r_strength"
						placeholder="Strength" required><br>

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
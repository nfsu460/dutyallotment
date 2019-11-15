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
<title>Add Exam Schedule | ADMIN</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">

	<%@include file="assets/adminnavbar.jsp"%>
	<section id="four" class="wrapper special style1">
		<div class="inner">
			<header class="major narrow">
				<h2>Add Exam Schedule</h2>
				<p></p>
			</header>
			<div class="container 50%">
				<form action="AddExamScheduleSrv" method="POST">

					<b>Enter Date</b> <input type="date" name="e_date"
						placeholder="Date" required><br> <b>Enter Subject</b><br>
					Note: Multiple Subjects should be separated with comma. <input
						type="text" name="e_subject" placeholder="Subject" required><br>

					<b>Enter Slot</b><br> Note:(Morning, Afternoon, Evening) <input
						type="text" name="e_slot" placeholder="Slot" required><br>

					<ul class="actions">
						<li><input type="submit" class="special" value="Submit" /></li>
						<li><input type="reset" class="alt" value="Reset" /></li>
					</ul>
				</form>
				<%
				if (request.getParameter("status") != null) {
					if (Integer.parseInt(request.getParameter("status")) == 1) {%>
				<font color="green">Exam Added.....Add Another.</font>
				<%}else if (Integer.parseInt(request.getParameter("status")) == -1){ %>
				<b><font color="red">Something Went Wrong...!</font></b>
				<%}}%>
			</div>
		</div>
	</section>


</body>
</html>
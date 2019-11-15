<!DOCTYPE html>
<html>
<%
	int emp_id = 0;
	Object obj = session.getAttribute("emp_id");
	if (obj != null) {
		emp_id = (Integer) obj;
		if (emp_id > 0)
			response.sendRedirect("employeehome.jsp");
	}
%>
<head>
<title>Login | EMPLOYEE</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">
	<%@include file="assets/indexnavbar.jsp"%>

	<section id="four" class="wrapper style3 special">
		<div class="inner">
			<header class="major narrow">
				<h2>Employee Login</h2>
				<p></p>
			</header>
			<form action="EmployeeSrv" method="GET">
				<div class="container 50%">
					<div class="container 100%">
						<div class="row uniform 75%">
							<div class="6u 12u$(xsmall)">
								<input name="employee_email" placeholder="Email" type="email"
									required />
							</div>
							<div class="6u$ 12u$(xsmall)"></div>
							<div class="6u$ 12u$(xsmall)">
								<input name="employee_password" placeholder="Password"
									type="password" required />
							</div>
						</div>
					</div>
				</div>
				<%
				if(request.getParameter("status")!=null){
					int status = Integer.parseInt(request.getParameter("status"));
					
					if(status == -1)%>
				<font color="red">Incorrect Email or Password</font>
				<%}%>
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
</html>
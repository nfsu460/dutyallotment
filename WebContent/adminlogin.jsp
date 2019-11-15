<!DOCTYPE html>
<%
Object obj = session.getAttribute("admin");
if(obj!=null){
	if((Integer)obj == 1)
		response.sendRedirect("adminhome.jsp");
}
%>
<html>
<head>
<title>Login | ADMIN</title>
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
				<h2>Admin Login</h2>
				<p></p>
			</header>
			<form action="AdminLoginSrv" method="POST">
				<div class="container 50%">

					<div class="container 100%">

						<div class="row uniform 75%">

							<div class="6u 12u$(xsmall)">

								<input name="email" placeholder="Email" type="email" required />
							</div>
							<div class="6u$ 12u$(xsmall)"></div>
							<div class="6u$ 12u$(xsmall)">
								<input name="password" placeholder="Password" type="password"
									required />
							</div>
						</div>
					</div>
				</div>
				<ul class="actions">
					<li><input type="submit" class="special" value="Submit" /></li>
					<li><input type="reset" class="alt" value="Reset" /></li>
				</ul>
			</form>
			<br>
			<br>
			<%
				if(request.getParameter("status")!=null){
					int status = Integer.parseInt(request.getParameter("status"));
					
					if(status == -1)%>
			<font color="red">Incorrect Email or Password</font>
			<%}%>

		</div>
	</section>

</body>
</html>
<!DOCTYPE html>
<%
Object obj = session.getAttribute("admin");
if(obj!=null){
	if((Integer)obj != 1)
		response.sendRedirect("adminlogin.jsp");
}else
	response.sendRedirect("adminlogin.jsp");
%>
<%@page import="com.dutyallotment.dao.AdminDao"%>
<%@page import="com.dutyallotment.dao.AdminDaoImpl"%>
<%@page import="com.dutyallotment.bean.RoomBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>All Rooms | ADMIN</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

</head>
<body class="landing">
	<section id="four" class="wrapper style1 special">
		<div class="inner">

			<%@include file="assets/adminnavbar.jsp"%>

			<header class="major narrow">
				<h2>All Rooms</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<table>

					<tr>
						<th>Room Number</th>
						<th>Department</th>
						<th>Strength</th>
					</tr>
					<%
						AdminDao dao = new AdminDaoImpl();
						List<RoomBean> rList = dao.viewRooms();
						if(rList != null){
							RoomBean rBean = new RoomBean();
							for(int i=0; i < rList.size(); i++) { 
								rBean = rList.get(i); %>
					<tr>
						<td><%=rBean.getR_id() %></td>
						<td><%=rBean.getR_department() %></td>
						<td><%=rBean.getR_strength() %></td>
					</tr>

					<% }}else{ %>

				</table>
				<p>No Room</p>
				<%} %>
			</div>
		</div>
	</section>

</body>
</html>
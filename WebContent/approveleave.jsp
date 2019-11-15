<!DOCTYPE html>
<%@page import="com.dutyallotment.bean.FacultyExamLeaveBean"%>
<%@page import="com.dutyallotment.bean.FacultyLeaveBean"%>
<%@page import="com.dutyallotment.bean.FacultyBean"%>
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
<title>Approve Leave | ADMIN</title>
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
				<h2>Pending Leave</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<table>

					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Approve</th>

					</tr>
					<%
						AdminDao dao = new AdminDaoImpl();
						List<FacultyExamLeaveBean> felList = dao.viewPendingLeave();
						if(felList != null){
							FacultyExamLeaveBean felBean = new FacultyExamLeaveBean();
							for(int i=0; i < felList.size(); i++) { 
								felBean = felList.get(i); %>
					<tr>
						<td><%=felBean.getFaculty_id() %></td>
						<td><%=felBean.getFaculty_name() %></td>
						<td><%=felBean.getE_date() %></td>
						<td><a href="ApproveLeaveSrv?id=<%=felBean.getL_id() %>">Approve</a></td>
					</tr>

					<% }}else{ %>

				</table>
				<p>No Pending Leave</p>
				<%} %>
				<%
		if (request.getParameter("status") != null) {
			if (Integer.parseInt(request.getParameter("status")) == 1) {%>
				<font color="green">Leave Successfully Cancelled</font>
				<%}else if (Integer.parseInt(request.getParameter("status")) == 2){ %>
				<font color="green">Blank</font>
				<%}else if (Integer.parseInt(request.getParameter("status")) == -1){ %>
				<b><font color="red">Something Went Wrong...!</font></b>
				<%}}%>

			</div>
		</div>
	</section>

</body>
</html>
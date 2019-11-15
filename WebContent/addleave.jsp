<!DOCTYPE html>
<%@page import="com.dutyallotment.bean.FacultyLeaveBean"%>
<%@page import="com.dutyallotment.bean.FacultyBean"%>
<%@page import="com.dutyallotment.bean.ExamScheduleBean"%>
<%@page import="com.dutyallotment.dao.FacultyDao"%>
<%@page import="com.dutyallotment.dao.FacultyDaoImpl"%>
<%@page import="com.dutyallotment.bean.RoomBean"%>
<%@page import="java.util.List"%>
<%Object obj= session.getAttribute("faculty_id");
int faculty_id = 0;
if(obj!=null){
	if((Integer)obj<=0){
		response.sendRedirect("facultylogin.jsp");
	}
	else{
		faculty_id = (Integer)obj;
	}
}
else
	response.sendRedirect("facultylogin.jsp");
%>
<html>
<head>
<title>Add Leave | Faculty</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

</head>
<body class="landing">
	<section id="four" class="wrapper style1 special">
		<div class="inner">

			<%@include file="assets/facultynavbar.jsp"%>

			<header class="major narrow">
				<h2>Exam Schedule</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<%
					if(request.getParameter("status")!=null){
						int status = Integer.parseInt(request.getParameter("status"));
					
						if(status == -1){%>
				<b><font color="red">Something Went Wrong! Please Try
						Again</font></b><br>
				<%}else if(status == 1){%>
				<b><font color="green">New Leave Added! Please Wait for
						Admin's Approval</font></b><br>
				<%}else if(status == 0){%>
				<b><font color="yellow">Leave Already Added! Please Wait
						for Admin's Approval</font></b><br>
				<%}}%>

				<table>

					<tr>
						<th>Date (YYYY-MM-DD)</th>
						<th>Subject</th>
						<th>Slot</th>
						<th>Action</th>
					</tr>
					<%
						FacultyDao dao = new FacultyDaoImpl();
						List<ExamScheduleBean> eList = dao.viewDateSheet();
						if(eList != null){
							ExamScheduleBean eBean = new ExamScheduleBean();
							for(int i=0; i < eList.size(); i++) { 
								eBean = eList.get(i); %>
					<tr>
						<td><%=eBean.getE_date() %></td>
						<td><%=eBean.getE_subject() %></td>
						<td><%=eBean.getE_slot() %></td>
						<td><a
							href="AddLeaveSrv?eid=<%= eBean.getE_id() %>&facultyid=<%= faculty_id %>">Apply
								Leave</a></td>
					</tr>

					<% }}else{ %>

				</table>
				<p>No Exam</p>
				<%} %>
			</div>
		</div>
	</section>

</body>
</html>
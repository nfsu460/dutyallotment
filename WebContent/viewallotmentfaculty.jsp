<!DOCTYPE html>
<%@page import="com.dutyallotment.dao.FacultyDaoImpl"%>
<%@page import="com.dutyallotment.dao.FacultyDao"%>
<%@page import="com.dutyallotment.bean.FinalDutyAllotmentBean"%>
<%@page import="com.dutyallotment.bean.ExamScheduleBean"%>
<%@page import="com.dutyallotment.dao.AdminDao"%>
<%@page import="com.dutyallotment.dao.AdminDaoImpl"%>
<%@page import="com.dutyallotment.bean.RoomBean"%>
<%@page import="java.util.List"%>

<%Object obj= session.getAttribute("faculty_id");
int faculty_id = 0;
if(obj!=null){
	if((Integer)obj<=0)
		response.sendRedirect("facultylogin.jsp");
	else
		faculty_id = (Integer)obj;
}
else
	response.sendRedirect("facultylogin.jsp");
%>

<html>
<head>
<title>View Allotment | ADMIN</title>
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
				<h2>Allotment</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<table>

					<tr>
						<th>Date (YYYY-MM-DD)</th>
						<th>Slot</th>
						<th>Room Number</th>
						<th>Faculty 1</th>
						<th>Faculty 2</th>
						<th>Subject</th>
					</tr>
					<%
						FacultyDao dao = new FacultyDaoImpl();
						List<FinalDutyAllotmentBean> eList = dao.viewAllotment(faculty_id);
						if(eList != null){
							FinalDutyAllotmentBean eBean = new FinalDutyAllotmentBean();
							for(int i=0; i < eList.size(); i++) { 
								eBean = eList.get(i); %>
					<tr>
						<td><%=eBean.getE_date() %></td>
						<td><%=eBean.getE_shift() %></td>
						<td><%=eBean.getR_id() %></td>
						<td><%=eBean.getFaculty_name1() %></td>
						<td><%=eBean.getFaculty_name2() %></td>
						<td><%=eBean.getE_subject() %></td>

					</tr>

					<% }}else{ %>

				</table>
				<p>No Allotment</p>
				<%} %>
			</div>
		</div>
	</section>

</body>
</html>
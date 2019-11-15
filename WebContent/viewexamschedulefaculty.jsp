<!DOCTYPE html>
<%@page import="com.dutyallotment.bean.ExamScheduleBean"%>
<%@page import="com.dutyallotment.dao.AdminDao"%>
<%@page import="com.dutyallotment.dao.AdminDaoImpl"%>
<%@page import="com.dutyallotment.bean.RoomBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>View Exam Schedule | ADMIN</title>
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

				<table>

					<tr>
						<th>Date (YYYY-MM-DD)</th>
						<th>Subject</th>
						<th>Slot</th>
					</tr>
					<%
						AdminDao dao = new AdminDaoImpl();
						List<ExamScheduleBean> eList = dao.viewDateSheet();
						if(eList != null){
							ExamScheduleBean eBean = new ExamScheduleBean();
							for(int i=0; i < eList.size(); i++) { 
								eBean = eList.get(i); %>
					<tr>
						<td><%=eBean.getE_date() %></td>
						<td><%=eBean.getE_subject() %></td>
						<td><%=eBean.getE_slot() %></td>
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
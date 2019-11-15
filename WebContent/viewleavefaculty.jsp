<!DOCTYPE html>
<%@page import="com.dutyallotment.dao.FacultyDaoImpl"%>
<%@page import="com.dutyallotment.dao.FacultyDao"%>
<%@page import="com.dutyallotment.bean.FacultyExamLeaveBean"%>
<%@page import="com.dutyallotment.bean.FacultyLeaveBean"%>
<%@page import="com.dutyallotment.bean.FacultyBean"%>
<%
Object obj = session.getAttribute("faculty_id");
int faculty_id = 0;
if(obj!=null){
	if((Integer)obj > 0){
		faculty_id = (Integer)obj;
	}
}else
	response.sendRedirect("facultylogin.jsp");
%>
<%@page import="com.dutyallotment.bean.RoomBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Approved Leave | ADMIN</title>
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
				<h2>Approved Leave</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<table>

					<tr>
						<th>Date</th>
						<th>Status</th>

					</tr>
					<%
						FacultyDao dao = new FacultyDaoImpl();
						List<FacultyLeaveBean> felList = dao.viewLeave(faculty_id);
						if(felList != null){
							FacultyLeaveBean felBean = new FacultyLeaveBean();
							for(int i=0; i < felList.size(); i++) { 
								felBean = felList.get(i); %>
					<tr>
						<td><%=felBean.getE_date() %></td>
						<%if(felBean.getL_approval() == 0){ %>
						<td>Pending for approval</td>
						<%}else if(felBean.getL_approval() == 1){ %>
						<td>Approved</td>
						<%}else{ %>
						<td>Error</td>
						<%} %>
					</tr>

					<% }}else{ %>

				</table>
				<p>No Leave</p>
				<%} %>

			</div>
		</div>
	</section>

</body>
</html>
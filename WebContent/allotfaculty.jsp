<!DOCTYPE html>
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
<title>View Faculty | ADMIN</title>
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
				<h2>Faculties</h2>
				<p></p>
			</header>
			<div class="container 100%">

				<table>

					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Allot</th>

					</tr>
					<%
					int e_id = 0;
					int r_id = 0;
					if(request.getParameter("examid") != null && request.getParameter("roomid") != null){
						e_id = Integer.parseInt(request.getParameter("examid"));
						r_id = Integer.parseInt(request.getParameter("roomid"));
					}
						AdminDao dao = new AdminDaoImpl();
						List<FacultyBean> fList = dao.viewFinalFaculty(e_id);
						if(fList != null){
							FacultyBean fBean = new FacultyBean();
							for(int i=0; i < fList.size(); i++) { 
								fBean = fList.get(i); %>
					<tr>
						<td><%=fBean.getFaculty_id() %></td>
						<td><%=fBean.getFaculty_name() %></td>
						<td><%=fBean.getFaculty_email() %></td>
						<td><%=fBean.getFaculty_mobile() %></td>
						<td><a
							href="FinalDutyAllotmentSrv?examid=<%=e_id%>&roomid=<%=r_id%>&facultyid=<%=fBean.getFaculty_id()%>">Submit</a></td>
					</tr>

					<% }}else{ %>

				</table>
				<p>No Approved Faculty</p>
				<%} %>
			</div>
		</div>
	</section>

</body>
</html>
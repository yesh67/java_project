<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="Functional.*" %>
     <%@ page import="DataEntitiesAnnotated.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table Footer Page</title>
</head>
<body>

<%
List<EmployeeDTO> listEmp=new ArrayList<EmployeeDTO>();

EmployeeDTO objEmp=new EmployeeDTO();

Functional<EmployeeDTO> empFunctional=new Functional<EmployeeDTO>(objEmp);

listEmp=empFunctional.Select();

int noOfEmps=listEmp.size();
%>

<table border="5" align="center" name="empTable">
<tr>
<td>ID</td><td>FirstName</td><td>LastName</td><td>MI</td><td>IDTest</td>
</tr>

<% for(EmployeeDTO varEmployeeDTO:listEmp) 
{
%>
<tr> 
<td><%  out.println(varEmployeeDTO.getID());  %></td>
<td><%   out.println(varEmployeeDTO.getFname()); %></td>
<td><%   out.println(varEmployeeDTO.getLname()); %></td>
<td><%   out.println(varEmployeeDTO.getMI()); %></td>
<td><%  out.println(varEmployeeDTO.getIDTest()); %></td>
</tr>
<%	
}
%>


</table>

</body>
</html>
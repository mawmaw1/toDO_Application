<%-- 
    Document   : addEmployee
    Created on : 04-10-2015, 10:00:00
    Author     : Magnus
--%>


<%@page import="java.util.List"%>
<%@page import="domain.Employee"%>
<%@page import="domain.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <% String msg = request.getParameter("msg");
            if (msg != null) {
        %>
        <h2 style="color: blue" align="center"><%=msg%></h2>

        <%}%>
        <h2 align="center">Add New </h2>
        <form action="EmployeeController">
            <input type="hidden" name="command" value="addEmployee">
            <table align="center">
                <tr>  
                    <td>Employee Name</td>  
                    <td>
                        <input type="text" name="emp_name"></td>
                </tr>
                <tr>
                    <td>Email</td>   <td><input type="text" name="emp_email"></td> 
                </tr>
                <tr>
                    <td>Phone</td>   <td><input type="tel"  maxlength="12" name="emp_phone"></td> 
                </tr>
                <tr>
                    <td colspan="2" align="center"><button name="newEmployeeButton" value="" >Save</Button></td>                    
                </tr>
            </table>
        </form>

        <br/><br/>
        <h2 align="center">All Employee Details</h2>

        <%
            // Session starts
            Controller con = Controller.getInstance();
            session.setAttribute("Controller", con);

            List<Employee> empList = con.fetchEmployee();

        %>

        <table align="center" border="1">
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Employee Email</th>
                <th>Employee Phone</th>

            </tr> 
            <%  for (Employee emp : empList) {
            %>
            <tr>  
                <td><%=emp.getEmp_id()%></td>
                <td><%=emp.getEmp_name()%></td>                         
                <td><%=emp.getEmp_email()%></td>  
                <td><%=emp.getEmp_phone()%></td>                         

                <td><a href="EmployeeController?command=fetchEmployee&emp_id=<%=emp.getEmp_id()%>">Edit</a></td> 
            </tr>
            <%}%>
        </table>
        <br>
        ------------------------------------------------------------------------
        <form action="index.html">
            <button name="MenuButton" value="">Menu</button>
        </form> 
    </body>
</html>

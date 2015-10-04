<%-- 
    Document   : editEmployee
    Created on : 04-10-2015, 10:00:18
    Author     : Magnus
--%>



<%@page import="domain.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employees</title>
    </head>
    <body>
        <% String msg=request.getParameter("msg");
         Employee emp=(Employee)session.getAttribute("emp");
         if(msg!=null){
        %>
        <h2 style="color: aquamarine" align="center"><%=msg%></h2>
        
        <%}%>
        <h2 align="center">Update Customer</h2>
        <form action="EmployeeController" method="POST">
            <input type="hidden" name="command" value="updateEmployee">
            <input type="hidden" name="emp_id" value="<%=emp.getEmp_id()%>">
            <table align="center">
                <tr>  
                    <td>Employee Name</td>  
                    <td>
                        <input type="text" name="emp_name" value="<%=emp.getEmp_name()%>"></td>
                    
                    <td>Employee Email</td>   <td><input type="text" name="emp_email" value="<%=emp.getEmp_email()%>"></td> 
                   <td>Employee Phone</td>   <td><input type="tel" maxlength="12" name="emp_phone" value="<%=emp.getEmp_phone()%>"></td> 
                    
                    <td><button name="Update Employee" value="" >Update Details</Button></td>                    
                </tr>
            </table>
        </form>
                     <br>
        ------------------------------------------------------------------------
        <form action="index.html">
            <button name="MenuButton" value="">Menu</button>
        </form> 
    </body>
</html>

<%-- 
    Document   : editProject
    Created on : 04-10-2015, 15:37:03
    Author     : Magnus
--%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Projects</title>
    </head>
    <body>
        <% String msg=request.getParameter("msg");
         Project pro=(Project)session.getAttribute("pro");
         if(msg!=null){
        %>
        <h2 style="color: aquamarine" align="center"><%=msg%></h2>
        
        <%}%>
        <h2 align="center">Update Project</h2>
        <form action="ProjectController" method="POST">
            <input type="hidden" name="command" value="updateProject">
            <input type="hidden" name="pro_id" value="<%=pro.getPro_id()%>">
            <table align="center">
                <tr>  
                    <td>Project Name</td>  
                    <td>
                        <input type="text" name="pro_name" value="<%=pro.getPro_name()%>"></td>
                    
                    <td>Project Start date</td>   <td><input type="date" name="pro_startdate" value="<%=pro.getPro_startdate()%>"></td> 
                   <td>Project End date</td>   <td><input type="date" name="pro_enddate" value="<%=pro.getPro_enddate()%>"></td> 
                   <td>Project Budget</td> <td><input type="text" name="pro_budget" value="<%=pro.getPro_budget()%>"></td>
                    <td><button name="Update Project" value="" >Update Details</Button></td>                    
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
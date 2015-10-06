<%-- 
    Document   : addProject
    Created on : 04-10-2015, 15:36:54
    Author     : Magnus
--%>

<%@page import="java.util.List"%>
<%@page import="domain.Project"%>
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
        <form action="ProjectController">
            <input type="hidden" name="command" value="addProject">
            <table align="center">
                <tr>  
                    <td>Project Name</td>  
                    <td>
                        <input type="text" name="pro_name"></td>
                </tr>
                <tr>
                    <td>Project Start Date</td>   <td><input type="text" name="pro_startdate"></td> 
                </tr>
                <tr>
                    <td>Project End Date</td>   <td><input type="text"   name="pro_enddate"></td> 
                </tr>
                <tr>
                    <td>Project Budget</td>   <td><input type="text"   name="pro_budget"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><button name="newButton" value="" >Save</Button></td>                    
                </tr>
            </table>
        </form>

        <br/><br/>
        <h2 align="center">All Project Details</h2>

        <%
            // Session starts
            Controller con = Controller.getInstance();
            session.setAttribute("Controller", con);

            List<Project> proList = con.fetchProject();

        %>

        <table align="center" border="1">
            <tr>
                <th>Project Id</th>
                <th>Project Name</th>
                <th>Project Start Date</th>
                <th>Project End Date</th>
                <th>Project Budget</th>

            </tr> 
            <%  for (Project pro : proList) {
            %>
            <tr>  
                <td><%=pro.getPro_id()%></td>
                <td><%=pro.getPro_name()%></td>                         
                <td><%=pro.getPro_startdate()%></td>  
                <td><%=pro.getPro_enddate()%></td>   
                <td><%=pro.getPro_budget()%></td>   

                <td><a href="ProjectController?command=fetchProject&pro_id=<%=pro.getPro_id()%>">Edit</a></td> 
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

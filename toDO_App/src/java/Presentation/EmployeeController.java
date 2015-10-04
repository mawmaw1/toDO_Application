/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import domain.Controller;
import domain.Employee;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Magnus
 */
public class EmployeeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            //-- Establish or reestablish application context
            HttpSession sessionObj = request.getSession();
            Controller con = (Controller) sessionObj.getAttribute("Controller");
            if (con == null) {
                // Session starts
                con = Controller.getInstance();
                sessionObj.setAttribute("Controller", con);
            } else {
                con = (Controller) sessionObj.getAttribute("Controller");
            }

            String command = request.getParameter("command");
            switch (command) {
                case "addEmployee": {
                    Employee emp = new Employee();
                    emp.setEmp_name(request.getParameter("emp_name"));
                    emp.setEmp_email(request.getParameter("emp_email"));
                    emp.setEmp_phone(request.getParameter("emp_phone"));

                    con.saveEmployee(emp);
                    response.sendRedirect("addEmployee.jsp?msg=Employee saved Successfully");

                    break;
                }
                case "fetchEmployee": {
                    int emp_id = Integer.parseInt(request.getParameter("emp_id"));
                    request.getSession().setAttribute("emp", con.fetchEmployeeById(emp_id));
                    response.sendRedirect("editEmployee.jsp");
                    break;
                }
                case "updateEmployee": {
                    Employee emp = new Employee();
                    emp.setEmp_name(request.getParameter("emp_name"));
                    emp.setEmp_email(request.getParameter("emp_email"));
                    emp.setEmp_phone(request.getParameter("emp_phone"));

                    emp.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));

                    con.updateEmployee(emp);
                    request.getSession().setAttribute("emp", con.fetchEmployeeById(emp.getEmp_id()));
                    response.sendRedirect("editEmployee.jsp?msg=Employee updated Successfully");
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

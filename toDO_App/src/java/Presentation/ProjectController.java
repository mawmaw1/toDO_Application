/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import domain.Controller;
import domain.Project;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Magnus
 */
@WebServlet(name = "ProjectController", urlPatterns
        = {
            "/ProjectController"
        })

public class ProjectController extends HttpServlet {

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
                case "addProject": {
                    Project pro = new Project();
                    
                    pro.setPro_name(request.getParameter("pro_name"));
                    pro.setPro_startdate(java.sql.Date.valueOf(request.getParameter("pro_startdate")));
                    pro.setPro_enddate(java.sql.Date.valueOf(request.getParameter("pro_enddate")));

                    pro.setPro_budget(Double.parseDouble(request.getParameter("pro_budget")));
                    con.saveProject(pro);
                    response.sendRedirect("addProject.jsp?msg=Project saved Successfully");

                    break;
                }
                case "fetchProject": {
                    int pro_id = Integer.parseInt(request.getParameter("pro_id"));
                    request.getSession().setAttribute("pro", con.fetchProjectById(pro_id));
                    response.sendRedirect("editProject.jsp");
                    break;
                }
                case "updateProject": {
                    Project pro = new Project();
                    pro.setPro_name(request.getParameter("pro_name"));
                    pro.setPro_startdate(java.sql.Date.valueOf(request.getParameter("pro_startdate")));
                    pro.setPro_enddate(java.sql.Date.valueOf(request.getParameter("pro_enddate")));
                    pro.setPro_budget(Double.parseDouble(request.getParameter("pro_budget")));

                    pro.setPro_id(Integer.parseInt(request.getParameter("pro_id")));

                    con.updateProject(pro);
                    request.getSession().setAttribute("pro", con.fetchProjectById(pro.getPro_id()));
                    response.sendRedirect("editProject.jsp?msg=Project updated Successfully");
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

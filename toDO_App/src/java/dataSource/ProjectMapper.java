/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magnus
 */
public class ProjectMapper {

    public boolean saveNewProject(Project pro, Connection con) {
        int rowsInserted = 0;
        String SQLString
                = "insert into project "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, 0);
            statement.setString(2, pro.getPro_name());
            statement.setDate(3, pro.getPro_startdate());
            statement.setDate(4, pro.getPro_enddate());
            statement.setDouble(5, pro.getPro_budget());

            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in Saving project");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Fail2 in Saving project");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean updateProject(Project pro, Connection con) {

        int rowsUpdated = 0;
        String SQLString
                = "update project set pro_name = ?, pro_startdate = ?, pro_enddate = ?, pro_budget = ? where pro_id = ?";
        PreparedStatement statement = null;

        try {
            //== update order tuple
            statement = con.prepareStatement(SQLString);
            statement.setString(1, pro.getPro_name());
            statement.setDate(2, pro.getPro_startdate());
            statement.setDate(3, pro.getPro_enddate());
            statement.setDouble(4, pro.getPro_budget());

            statement.setInt(5, pro.getPro_id());

            rowsUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail1 in Update project");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail1 in Update project");
                System.out.println(e.getMessage());
            }
        }
        return rowsUpdated == 1;
    }

    public List<Project> fetchProject(Connection con) {

        List<Project> result = new ArrayList<>();
        Statement ps = null;
        try {

            ps = con.createStatement();

            ResultSet rs = ps.executeQuery("select * from project");
            while (rs.next()) {
                Project pro = new Project();
                pro.setPro_id(rs.getInt(1));
                pro.setPro_name(rs.getString(2));
                pro.setPro_startdate(rs.getDate(3));
                pro.setPro_enddate(rs.getDate(4));
                pro.setPro_budget(rs.getDouble(5));

                result.add(pro);
            }
        } catch (Exception ex) {
            System.out.println("Fail1 in Fetching Project1");
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                    System.out.println("Fail1 in Fetching Project ?");
                }
            }
        }
        return result;

    }

    public Project fetchProjectById(int pro_id, Connection con) {

        Project pro = new Project();
        Statement ps = null;
        try {

            ps = con.createStatement();

            ResultSet rs = ps.executeQuery("select * from Project where pro_id=" + pro_id);
            while (rs.next()) {

                pro.setPro_id(rs.getInt(1));
                pro.setPro_name(rs.getString(2));
                pro.setPro_startdate(rs.getDate(3));
                pro.setPro_enddate(rs.getDate(4));
                pro.setPro_budget(rs.getDouble(5));

            }
        } catch (Exception ex) {
            System.out.println("Fail1 in Fetching Project");
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                    System.out.println("Fail1 in Fetching Project");
                }
            }
        }
        return pro;
    }
}

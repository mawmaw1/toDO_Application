/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Employee;
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
public class employeeMapper {

    public boolean saveNewEmployee(Employee emp, Connection con) {
        int rowsInserted = 0;
        String SQLString
                = "insert into employee "
                + "values (?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, 0);
            statement.setString(2, emp.getEmp_name());
            statement.setString(3, emp.getEmp_email());
            statement.setString(4, emp.getEmp_phone());

            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in Saving employee");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Fail2 in Saving employee");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean updateEmployee(Employee emp, Connection con) {

        int rowsUpdated = 0;
        String SQLString
                = "update employee set emp_name = ?, emp_name = ?,emp_email = ?, emp_phone = ? where emp_id = ?";
        PreparedStatement statement = null;

        try {
            //== update order tuple
            statement = con.prepareStatement(SQLString);
            statement.setString(1, emp.getEmp_name());
            statement.setString(2, emp.getEmp_email());
            statement.setString(3, emp.getEmp_phone());

            statement.setInt(5, emp.getEmp_id());

            rowsUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail1 in Update employee");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail1 in Update employee");
                System.out.println(e.getMessage());
            }
        }
        return rowsUpdated == 1;
    }

    public List<Employee> fetchEmployee(Connection con) {

        List<Employee> result = new ArrayList<>();
        Statement ps = null;
        try {

            ps = con.createStatement();

            ResultSet rs = ps.executeQuery("select * from employee");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmp_id(rs.getInt(1));
                emp.setEmp_name(rs.getString(2));
                emp.setEmp_email(rs.getString(3));
                emp.setEmp_phone(rs.getString(4));

                result.add(emp);
            }
        } catch (Exception ex) {
            System.out.println("Fail1 in Fetching employee1");
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                    System.out.println("Fail1 in Fetching employee ?");
                }
            }
        }
        return result;

    }

    public Employee fetchEmployeeById(int emp_id, Connection con) {

        Employee emp = new Employee();
        Statement ps = null;
        try {

            ps = con.createStatement();

            ResultSet rs = ps.executeQuery("select * from employee where emp_id=" + emp_id);
            while (rs.next()) {

                emp.setEmp_id(rs.getInt(1));
                emp.setEmp_name(rs.getString(2));
                emp.setEmp_email(rs.getString(3));
                emp.setEmp_phone(rs.getString(4));

            }
        } catch (Exception ex) {
            System.out.println("Fail1 in Fetching Employee");
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                    System.out.println("Fail1 in Fetching Employee");
                }
            }
        }
        return emp;
    }
}

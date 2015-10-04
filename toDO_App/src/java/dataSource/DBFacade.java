/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Magnus
 */
public class DBFacade {

    private Connection con;
    private employeeMapper empMap;
    private ProjectMapper proMap;
    //== Singleton start
    private static DBFacade instance;

    private DBFacade() {
        
        empMap = new employeeMapper();
        proMap = new ProjectMapper();
        con = DBConnector.getInstance().getConnection();
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
	  //== Singleton end

   

    public void saveEmployee(Employee emp) {
        empMap.saveNewEmployee(emp, con);
    }

    public List<Employee> fetchEmployee() {
        return empMap.fetchEmployee(con);
    }

    public Employee fetchEmployeeById(int emp_id) {
        return empMap.fetchEmployeeById(emp_id, con);
    }

    public void updateEmployee(Employee emp) {
        empMap.updateEmployee(emp, con);
    }
    
    
    
    
        public void saveProject(Project pro) {
        proMap.saveNewProject(pro, con);
    }

    public List<Project> fetchProject() {
        return proMap.fetchProject(con);
    }

    public Project fetchProjectById(int pro_id) {
        return proMap.fetchProjectById(pro_id, con);
    }

    public void updateProject(Project pro) {
        proMap.updateProject(pro, con);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dataSource.*;
import java.util.List;

/**
 *
 * @author Magnus
 */
public class Controller {

    private final DBFacade dbf;

    //-- singleton
    private static Controller instance;

    private Controller() {

        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    //----------------------
    
    
    
        public void saveEmployee(Employee emp){
           dbf.saveEmployee(emp);
        }
        
        public List<Employee> fetchEmployee(){
           return  dbf.fetchEmployee();
        }
        
         public Employee fetchEmployeeById(int emp_id){
           return  dbf.fetchEmployeeById(emp_id);
        }
	
        
        public void updateEmployee(Employee emp){
            dbf.updateEmployee(emp);
        }
    
    
    
}

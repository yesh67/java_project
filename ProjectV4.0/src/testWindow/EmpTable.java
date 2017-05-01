package testWindow;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DataEntitiesAnnotated.EmployeeDTO;
import Functional.Functional;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
 
public class EmpTable
{
	JFrame empJFrame;
    public EmpTable()
    {
    	empJFrame=new JFrame();
        empJFrame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        
         
       
 
        //create table with data
        JTable table = new JTable();
        
        
         
        //add the table to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        empJFrame.getContentPane().add(scrollPane);
        
        JButton btnGetemployeedata = new JButton("GetEmployeeData");
        btnGetemployeedata.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		 List<EmployeeDTO> listEmp=new ArrayList<EmployeeDTO>();

	             EmployeeDTO objEmp=new EmployeeDTO();
	             
	             Functional<EmployeeDTO> empFunctional=new Functional<EmployeeDTO>(objEmp);
	             
	             listEmp=empFunctional.Select();
	             
	             DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "FirstName", "LastName"}, 0);
	                
	                for(EmployeeDTO emp:listEmp){
		    	          model.addRow(new Object[]{emp.getID(), emp.getFname(),emp.getLname()});
		    	     }
		    	     
	   	     
	  table.setModel(model);  //data binding
        	}
        });
        scrollPane.setRowHeaderView(btnGetemployeedata);
        
     
       
        //scrollPane.setRowHeaderView(btnFetchemployee);
         
        empJFrame.setTitle("Employee Table Example");
        empJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        empJFrame.pack();
        empJFrame.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpTable();
            }
        });
    }   
}
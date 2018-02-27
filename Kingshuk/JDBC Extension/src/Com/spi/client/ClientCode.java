package Com.spi.client;

import java.util.Iterator;
import java.util.List;

import JDBCdemo.Employee;
import basics.spi.EmployeeDAO;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String qry="insert into employee values(100,'dar','HP',270)";
		Employee ee = EmployeeDAO.findById(105);
		// if(EmployeeDAO.insertEmployee(125,2232,"ss","hhh")>0)
		if (ee != null) {
			// System.out.println("Rec Inserted");
			System.out.println(ee.getEmpid() + "\t" + ee.getName());
		}
		// System.out.println("Rec Inserted");
		else
			System.out.println("Record Not Inserted");

		
		
		
		List<Employee> list1 = EmployeeDAO.getEmployee();
		if (list1.size()!= 0) {
			Iterator<Employee> it = list1.iterator();
			while (it.hasNext()) {
				Employee w=it.next();
				System.out.println(" ID: " + w.getEmpid() + " name: " + w.getName());
			}
		} else
			System.out.println("No record in db");
		
	}
}

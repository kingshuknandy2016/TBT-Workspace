package com.spi.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EmployeeDAO ed = new EmployeeDAO();
		
		Employee e =new Employee(); 
		
		
		System.out.println("welcom to employee certification system: ");
		System.out.println("1. insert employee");
		System.out.println("2. find employee");
		System.out.println("3. find by City");
		System.out.println("enter ur option: ");
		
		Scanner scn = new Scanner(System.in);
		int ch = scn.nextInt();
		switch (ch) {
		case 1:
			Scanner key = new Scanner(System.in);


			System.out.println("Enter the empid");
			e.setEmpId(key.nextInt());

			System.out.println("Enter the name");
			e.setName(key.next());

			System.out.println("Enter the address ");
			e.setAddress(key.next());

			System.out.println("Enter the Skill id ");
			e.setSkillId(key.nextInt());

			System.out.println("Enter the email id");
			e.setEmailId(key.next());

			System.out.println("Enter the city id");
			e.setCityId(key.nextInt());

			System.out.println("Enter the cell 1");
			e.setCellNo1(key.nextInt());

			System.out.println("Enter the cell 2 ");
			e.setCellNo2(key.nextInt());

			System.out.println("Enter date of join(dd/mm/yyyy) ");
			int date = key.nextInt();
			int month = key.nextInt();
			int year = key.nextInt();

			Date d = new Date(date, month, year);
			e.setDateOfJoining(d);

			System.out.println("enter the pincode");
			e.setPinCode(key.nextInt());
			try {
				ed.insertEmployees(e);
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			break;

			
		case 2: 
			
			Scanner scn1 = new Scanner(System.in);
			System.out.println("enter the emp id u wnat to find: ");
			int eidu = scn1.nextInt();
			
			e = ed.findByEmployeeId(eidu);
			
			if(e==null) {
				System.out.println("employee doesn't exist");
			} else {
				System.out.println("search successfull : "+e.getName()+ " "+e.getAddress());
			}
			break;
		case 3: 
			 Scanner scn2 = new Scanner(System.in);
			 System.out.println("Enter the Name of the city: Bangalore/Mysore/Pune/Hyderabad:  ");
			 String cityy = scn2.next();
			 List li=new ArrayList();
			 li=ed.findByCity(cityy);
			 
			if( li.isEmpty()){
				System.out.println("No Employee is from "+" ");
			}else{
				System.out.println("Employees From city"+""+"listed Bellow:");
				Iterator ite=li.iterator();
				while(ite.hasNext()){
					String st=(String) ite.next();
					System.out.println(st+"\n");
				}
			}
			 
			 
			
			break;
		default:
			break;
		}
		
		
		
		
		
		
		}

}

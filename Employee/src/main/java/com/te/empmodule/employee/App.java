package com.te.empmodule.employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.empmodule.employee.bean.Empdetails;
import com.te.empmodule.employee.bean.Leavedet;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		while (i != 1) {
			System.out.println();
			System.out.println("Press 1 to enter  Employee Details");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to exit");
			int option1 = scanner.nextInt();
			switch (option1) {
			case 1: 
				System.out.println("Enter Id:");
			Scanner sc=new Scanner(System.in);
				int em=sc.nextInt();
				Empdetails a=new Empdetails();
				a.setEmployee_ID(em);
				
			System.out.println("Enter Name:");
			
			String emp=sc.next();
		
			a.setEmployeeName(emp);
			System.out.println("enter mail");
		    String emp1=sc.next();
		    a.setEmail(emp1);
	    System.out.println("enter type");
		    String emp2=sc.next();
		    a.setEmployeeType(emp2);
		    System.out.println("enter  password");
		    String emp3=sc.next();
		    a.setPassword(emp3);
		  
			transaction.begin();
			manager.persist(a);
			transaction.commit();
			
				break;
			case 2: {
				Scanner cs=new Scanner(System.in) ;
				System.out.println("Enter Id:");
				int ii=cs.nextInt();
				System.out.println("Enter Password:");
				String s=cs.next();
				String r= "select EmployeeType from Empdetails where Employee_ID=:id";
				Query q=manager.createQuery(r);
				q.setParameter("id",ii);
				String type=(String)q.getSingleResult();
				String i1=type.toLowerCase();
				
				int input = 0;
				while (input != 1) {
					switch (i1) {
					case "manager": {
						System.out.println("Press 1 show leave requests");
						System.out.println("press 2 to Approve/Reject the leave request");
						System.out.println("Press 3 to exit");
						int option2 = scanner.nextInt();
						switch (option2) {
						case 1: {
							String show = "from leavedet";
							Query listQuery = manager.createQuery(show);
							List list = listQuery.getResultList();
							for (Object object : list) {
								Leavedet employeeleave = (Leavedet) object;
								System.out.println("=> " + employeeleave);
							}
						}

							break;
						case 2: {
							System.out.println("Enter the leave id");
							int leaveId = scanner.nextInt();
							String leave = "select leaveStatus from Leavedet where leaveId=:id";
							Query leaveQuery = manager.createQuery(leave);
							leaveQuery.setParameter("id", leaveId);
							System.out.println(" Press 1 to approve");
							System.out.println(" Press 2 to reject");
							int leaveStatus = scanner.nextInt();
							String status = "";
							String update = "";
							if (leaveStatus == 1) {
								update = "Approved";
								status = "update Leavedet set leaveStatus=:n where leaveId=:id";
							} else if (leaveStatus == 2) {
								update = "Rejected";
								status = "update Leavedet set leaveStatus=:n where leaveId=:id";
							} else
								update = "Pending";
							Query permitQuery = manager.createQuery(status);
							permitQuery.setParameter("id", leaveId);
							permitQuery.setParameter("n", update);
							transaction.begin();
							permitQuery.executeUpdate();
							transaction.commit();
						}

							break;
						case 3:
						input=1;
						default:
							System.out.println("Invalid ");
							break;
						}
					}
						break;
					case "employee": {
						System.out.println("Press 1 to show status ");
						System.out.println("Press 2 to apply leave request");
						System.out.println("Press 3 to exit ");
						int leaveReq = scanner.nextInt();
						switch (leaveReq) {
						case 1: {
							String leaveList ="from Leavedet where employeeId=:id";
							Query leaveQuery = manager.createQuery(leaveList);
							leaveQuery.setParameter("id", ii);
							List listLeave = leaveQuery.getResultList();
							for (Object object : listLeave) {
								Leavedet leave = (Leavedet) object;
								System.out.println("=> " + leave.getLeaveStatus());
							}
						}
							break;
						case 2: {
							System.out.println("Enter the date ");
							String date = scanner.next();
							Leavedet leave = new Leavedet();
							leave.setEmployeeId(ii);
							leave.setDate(date);
							transaction.begin();
							manager.persist(leave);
							transaction.commit();
						}
							break;
						case 3:
							input=1;
							break;
						default:
							System.out.println("Invalid ");
							break;
						}
					}
						break;
					default:
						break;
					}
				}
			}
				break;
			default:
				i = 1;
				break;
			}
		}
	}
}

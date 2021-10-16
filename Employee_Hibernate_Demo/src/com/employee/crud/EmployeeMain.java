package com.employee.crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.model.Employee;

public class EmployeeMain {

	public static void main(String[] args) {

		String str;
		int choice;
		Scanner sc = new Scanner(System.in);

		do {
			
			System.out.println(" 			Welcome to Employee Database		");
			System.out.println("Select any one Option: ");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Query Employee based on Company");
			System.out.println("4. Delete Employee");

			
			choice = sc.nextInt();
			
			
			switch (choice) {

			case 1:
				System.out.println("Enter the Employee details to be inserted, ");
				System.out.println("First Name: ");
				String fname = sc.next();
				System.out.println("Last Name: ");
				String lname = sc.next();
				System.out.println("company : ");
				String company = sc.next();
				Employee e = new Employee(fname, lname, company);

				createEmployee(e);
				break;

			case 2:
				System.out.println("Enter the ID of the Employee to be fetched: ");
				int FetchId = sc.nextInt();
				getEmployee(FetchId);
				break;

			case 3:
				System.out.println("Enter the company of the Employee to be fetched: ");
				String comp = sc.next();
				queryEmployee(comp);
				break;

			case 4:
				System.out.println("Enter the ID of the Employee to be deleted: ");
				int deleteId = sc.nextInt();
				deleteEmployee(deleteId);
				break;

			default:
				System.out.println("Invalid input");
				break;

			}
			
			System.out.println("Do you want to continue(Y/N): ");
			str = sc.next();
			
			

		} while (str.equalsIgnoreCase("y"));
		sc.close();
		

	}

	private static void deleteEmployee(int deleteId) {
		try {

			Session session = getSession();
			session.beginTransaction();
			Query q = session.createQuery("delete from Employee where id=:i");
			q.setParameter("i", deleteId);
			q.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Successfully deleted the Employee");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void queryEmployee(String comp) {
		try {
			Session session = getSession();
			session.beginTransaction();

			Query q = session.createQuery("from Employee where company=:c");
			q.setParameter("c", comp);

			List<Employee> employeeList = q.getResultList();

			for (Employee emp : employeeList) {
				System.out.println(emp);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void getEmployee(int id) {
		try {
			Session session = getSession();
			session.beginTransaction();
			Employee e = session.get(Employee.class, id);
			System.out.println("Employee details of ID - " + id + " is " + e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Session getSession() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		return session;

	}

	public static void createEmployee(Employee e) {

		try {

			Session session = getSession();
			session.beginTransaction();

			session.save(e);

			session.getTransaction().commit();

			System.out.println("Successfully added the Employee");

		} catch (Exception exp) {

			exp.printStackTrace();

		}

	}

}

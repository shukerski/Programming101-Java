package com.week11.friday.cinemaReservations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	private static SessionFactory factory; 
	public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure("/resources/cinema_reservations/hibernate.cfg.xml").buildSessionFactory(); //important not to forget to put configure()
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      Session session = factory.openSession();
	      MovieManager MM = new MovieManager(session);

	      /* Add a movie record in database */
//	      Integer empID1 = MM.addMovie("Silicon Valley", (float) 9.9);
	      

	      MM.listMovies();

	      MM.updateMovie(4, (float) 10.0);
	      
//	      System.out.println();

//	      ME.deleteEmployee(empID2);

//	      ME.listEmployees();
	      
	      session.close();
	}


}

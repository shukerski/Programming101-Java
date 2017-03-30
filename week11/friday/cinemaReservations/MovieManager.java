package com.week11.friday.cinemaReservations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.week11.friday.hibernateExample.Employee;

public class MovieManager {
	private Session session;
	
	public MovieManager(Session session) {
		this.session = session;
	}
	
	public Integer addMovie(String name, float rating) {
		Integer movieID = null;
		
		Movie m = new Movie(name, rating);
		movieID = (Integer) session.save(m);
		
		return movieID;
	}
	
	public void listMovies() {
		List movies = session.createQuery("From Movie").getResultList(); // Movie is the class name
		
        for (Iterator iterator = movies.iterator(); iterator.hasNext();){
			 Movie movie = (Movie) iterator.next(); 
			 System.out.print("Name: " + movie.getName()); 
			 System.out.println("  Rating: " + movie.getRating()); 
        }
	}
	

	public void updateMovie(Integer movieID, float rating) {
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		
		Movie movie = (Movie)session.get(Movie.class, movieID); // We take the object
		movie.setRating(rating);
		session.update(movie);
		
		tx.commit();
		} catch (HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}
}

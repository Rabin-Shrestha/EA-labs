package edu.mum.hw2.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Book;
import edu.mum.hw2.domain.CD;
import edu.mum.hw2.domain.DVD;

public class Application {

	private static EntityManagerFactory emf;
	 
	static { 
		try { 
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		} 
	} 
 
	public static void main(String[] args) {
 
		addProduct(); 
		printOrderReport(); 
		emf.close();
	} 
 
	private static void printOrderReport() { 
		// TODO Auto-generated method stub 
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try { 
			tx.begin();
			//code for report creation 
			CD cd = em.find(CD.class, 1);
			DVD dvd =  em.find(DVD.class, 2);
			Book book = em.find(Book.class, 3);
			
			System.out.println("<-------CD Report-------->");
			System.out.println("Name: "+cd.getName());
			System.out.println("Artist: "+cd.getArtist());
			System.out.println("Description"+cd.getDescription());
			
			System.out.println("<-------DVD Report-------->");
			System.out.println("Description: "+dvd.getDescription());
			System.out.println("Genre: "+dvd.getGenre());
			System.out.println("Name: "+dvd.getName());
			
			System.out.println("<-------Book Report-------->");
			System.out.println("Name: "+book.getName());
			System.out.println("Description: "+book.getDescription());
			System.out.println("Title: "+book.getTitle());
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally { 
			if ((em != null) && (em.isOpen())) em.close();
		}	 
	} 
 
	private static void addProduct() { 
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try { 
			tx.begin();
 
			// TODO your code
			CD cd = new CD();
			DVD dvd =  new DVD();
			Book book = new Book();
			
			cd.setName("Avatar CD");
			cd.setDescription("Very good movie CD");
			cd.setArtist("Tom Hanks CD");
			
			dvd.setName("Avatar DVD");
			dvd.setDescription("Very good movie DVD");
			dvd.setGenre("Tom Hanks DVD");
			
			book.setName("Avatar Book");
			book.setDescription("Very good Book");
			book.setTitle("Tom Hanks Book");
			
			em.persist(cd);
			em.persist(dvd);
			em.persist(book);
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
			System.out.println("hello");
		} finally { 
			if ((em != null) && (em.isOpen()))
				em.close();
		} 
	} 
}

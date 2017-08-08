package edu.mum.tvcritics.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.mum.tvcritics.entity.Cast;

@Repository
public class CastDao {

	private SessionFactory sf;

	public CastDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional
	public void createCast(Cast cast) {
		try {
			// Step-2: Implementation
			Session session = sf.getCurrentSession();
			session.save(cast);
		} catch (HibernateException e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cast> getAllCast() {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("from Cast");
		// castList = query.list();
		return query.list();
	}

	@Transactional
	public Cast getCastbyId(int castId) {
		Session session = sf.getCurrentSession();
		Cast cast = (Cast)session.get(Cast.class,castId);
		return cast;
	}

	@Transactional
	public void castUpdate(Cast cast) {
		Session session = sf.getCurrentSession();
		/*String name = cast.getName();
		String birthPlace = cast.getBirthPlace();
		String charcaterName = cast.getCharcaterName();
		String biography = cast.getBiography();
		Query query = session.createQuery("Update Cast c set c.name = :name, c.birthPlace = :birthPlace, c.charcaterName = :charcaterName, c.biography = :biography where c.id = :castid");
		query.setParameter("castid", castId);
		query.setParameter("name", name);
		query.setParameter("birthPlace", birthPlace);
		query.setParameter("charcaterName", charcaterName);
		query.setParameter("biography", biography);
		query.executeUpdate();*/
		session.update(cast);
		
	}

	@Transactional
	public void castDelete(int castId) {
		Session session = sf.getCurrentSession();
		//Query query = session.createQuery("Delete from Cast c where c.id = :castid");
		//query.setParameter("castid", castId);
		//query.executeUpdate();
		Cast cast = (Cast)session.get(Cast.class,castId);
		if(cast != null){
			session.delete(cast);
		}
	}

}

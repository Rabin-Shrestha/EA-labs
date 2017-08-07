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
	public Cast getCast(int castId) {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("Select c from Cast c where c.id = :castid");
		query.setParameter("castid", castId);
		Cast cast = (Cast) query.uniqueResult();
		return cast;
	}

	@Transactional
	public void castUpdate(int castId, Cast cast) {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("Update Cast c where c.id = :castid");
		query.setParameter("castid", castId);
		query.executeUpdate();
	}

	@Transactional
	public void castDelete(int castId) {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("Delete from Cast c where c.id = :castid");
		query.setParameter("castid", castId);
		query.executeUpdate();
	}

}

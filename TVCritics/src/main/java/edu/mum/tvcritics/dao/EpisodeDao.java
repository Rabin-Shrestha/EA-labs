package edu.mum.tvcritics.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.mum.tvcritics.entity.Episode;

@Repository
public class EpisodeDao {

	private SessionFactory sf;

	public EpisodeDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional
	public void createEpisode(Episode episode) {
		Session session = sf.getCurrentSession();
		session.save(episode);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Episode> getAllEpisode() {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("from Episode");
		return query.list();
	}

	@Transactional
	public Episode getEpisodebyId(int EpisodeId) {
		Session session = sf.getCurrentSession();
		Episode Episode = (Episode) session.get(Episode.class, new Integer(EpisodeId));
		return Episode;
	}

	@Transactional
	public void EpisodeUpdate(Episode Episode) {
		Session session = sf.getCurrentSession();
		session.update(Episode);
	}

	@Transactional
	public void EpisodeDelete(Integer EpisodeId) {
		Session session = sf.getCurrentSession();
		Episode Episode = (Episode) session.get(Episode.class,new Integer(EpisodeId));
		if (Episode != null) {
			session.delete(Episode);
		}
	}
}

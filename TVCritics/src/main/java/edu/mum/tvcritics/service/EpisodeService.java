package edu.mum.tvcritics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.tvcritics.dao.EpisodeDao;
import edu.mum.tvcritics.entity.Episode;

@Service
public class EpisodeService {

	private EpisodeDao EpisodeDao;

	public EpisodeService(EpisodeDao EpisodeDao) {
		this.EpisodeDao = EpisodeDao;
	}

	public void createEpisode(Episode Episode) {
		EpisodeDao.createEpisode(Episode);
	}

	public List<Episode> getEpisodeList() {
		return EpisodeDao.getAllEpisode();
	}

	public Episode getEpisodebyId(int EpisodeId) {
		return EpisodeDao.getEpisodebyId(EpisodeId);
	}

	public void EpisodeUpdate(Episode Episode) {
		EpisodeDao.EpisodeUpdate(Episode);
	}

	public void EpisodeDelete(int EpisodeId) {
		EpisodeDao.EpisodeDelete(EpisodeId);
	}
}

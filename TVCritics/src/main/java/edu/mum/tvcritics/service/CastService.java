package edu.mum.tvcritics.service;

import java.util.List;

import edu.mum.tvcritics.dao.CastDao;
import edu.mum.tvcritics.entity.Cast;

public class CastService {

	private CastDao castDao;
	
	public CastService(CastDao castDao) {
		this.castDao = castDao;
	}

	public void createCast(Cast cast) {
		castDao.createCast(cast);
	}
	
	public List<Cast> getCastList(){
		return castDao.getAllCast();
	}
	
	public Cast getCastbyId(int castId){
		return castDao.getCastbyId(castId);
	}
	
	public void castUpdate(Cast cast){
		castDao.castUpdate(cast);
	}
	
	public void castDelete(int castId){
		castDao.castDelete(castId);
	}
}

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
		System.out.println("From Service: "+cast.getName());
		castDao.createCast(cast);
	}
	
	public List<Cast> getCastList(){
		return castDao.getAllCast();
	}
	
	public Cast getCast(int castId){
		return castDao.getCast(castId);
	}
	
	public void castUpdate(int castId, Cast cast){
		castDao.castUpdate(castId, cast);
	}
	
	public void castDelete(int castId){
		castDao.castDelete(castId);
	}
}

package net.ssday.service;

import net.ssday.dao.MySqlDao;
import net.ssday.entity.Article;
import java.util.ArrayList;

public class IndexServiceImpl implements IndexService {
	private MySqlDao mySqlDao;
	
	public IndexServiceImpl(MySqlDao mySqlDao){
		this.mySqlDao=mySqlDao;
	}
	
	public IndexServiceImpl(){
		
	}
	
	public MySqlDao getMySqlDao() {
		return mySqlDao;
	}

	public void setMySqlDao(MySqlDao mySqlDao) {
		this.mySqlDao = mySqlDao;
	}
	
	@Override
	public ArrayList<Article> show() {
		// TODO Auto-generated method stub
		ArrayList<Article> articles= null;
		articles=new ArrayList(this.mySqlDao.query());
		return articles;
	}

}

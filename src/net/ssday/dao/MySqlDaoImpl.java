package net.ssday.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import net.ssday.entity.Article;
import net.ssday.entity.Word;

public class MySqlDaoImpl implements MySqlDao {
	HibernateTemplate hibernateTemplate;

	public MySqlDaoImpl(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate=hibernateTemplate;
	}
	
	public MySqlDaoImpl(){
		
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Article> query() {
		// TODO Auto-generated method stub
		String hql = "from Article article order by article.time desc";
		List<Article> articles = null;
		articles=this.hibernateTemplate.find(hql);
		return articles;
	}

	@Override
	public boolean create(Article article) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(article);
		return true;
	}

	@Override
	public Article query(String title) {
		// TODO Auto-generated method stub
		String hql = "from Article article where article.title=:n";
		List<Article> articles = this.hibernateTemplate.findByNamedParam(hql, "n", title);
		Article article = null;
		if (articles != null && articles.size() > 0) {
			article = articles.get(0);
		}
		return article;
	}

}

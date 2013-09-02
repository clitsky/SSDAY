package net.ssday.dao;

import java.util.List;

import net.ssday.entity.Article;
import net.ssday.entity.Word;

public interface MySqlDao {
	public List<Article> query();
	public Article query(String title);
	public boolean create(Article article);
}

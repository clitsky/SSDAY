package net.ssday.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import net.ssday.dao.MySqlDao;
import net.ssday.entity.Article;

import com.opensymphony.xwork2.ActionSupport;

public class WriteAction extends ActionSupport {
	private String title;
	private String author;
	private String content;
	private String time;
	private MySqlDao mySqlDao;
	private String keywords;
	
	
	public String getKeywords() {
		return keywords;
	}



	public void setKeywords(String keys) {
		this.keywords = keys;
	}



	public MySqlDao getMySqlDao() {
		return mySqlDao;
	}



	public void setMySqlDao(MySqlDao mySqlDao) {
		this.mySqlDao = mySqlDao;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}


	public String changeCharset(String original, String target, String str){
		try {
			byte[] bytes=str.getBytes(original);
			str=new String(bytes,target);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
//		this.author=this.changeCharset("ISO-8859-1", "UTF-8", this.author);
//		this.title=this.changeCharset("ISO-8859-1", "UTF-8", this.title);
//		this.keywords=this.changeCharset("ISO-8859-1", "UTF-8", this.keywords);
//		this.content=this.changeCharset("ISO-8859-1", "UTF-8", this.content);
		this.time=new Date().toLocaleString().substring(0, 10);
		
		Article article=new Article();
		article.setAuthor(this.author);
		article.setContent(this.content);
		article.setTime(this.time);
		article.setKeywords(this.keywords);
		article.setTitle(this.title);
		System.out.println(title);
		System.out.println(time);
		System.out.println(content);
		System.out.println(author);
		
		this.mySqlDao.create(article);
		
		return super.execute();
	}
}

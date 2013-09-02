package net.ssday.action;

import java.io.UnsupportedEncodingException;

import net.ssday.dao.MySqlDao;
import net.ssday.entity.Article;

import com.opensymphony.xwork2.ActionSupport;

public class ReadAction extends ActionSupport {
	private String title;
	private String[] paragraphs;
	private String content;
	private MySqlDao mySqlDao;
	
	
	public MySqlDao getMySqlDao() {
		return mySqlDao;
	}


	public void setMySqlDao(MySqlDao mySqlDao) {
		this.mySqlDao = mySqlDao;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String[] getParagraphs() {
		return paragraphs;
	}


	public void setParagraphs(String[] paragraphs) {
		this.paragraphs = paragraphs;
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
		System.out.println(this.title);
		this.title=this.changeCharset("ISO-8859-1", "UTF-8", this.title);

		Article article=null;
		article=this.mySqlDao.query(this.title);
		if(article!=null){
			this.content=article.getContent();
			this.paragraphs=this.content.split("\n");
		}
		System.out.println(this.title);
//		System.out.println(this.paragraphs.length);
		
		return SUCCESS;
	}
}

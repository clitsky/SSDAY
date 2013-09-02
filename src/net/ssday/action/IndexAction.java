package net.ssday.action;

import java.util.ArrayList;
import java.util.Iterator;

import net.ssday.entity.Article;
import net.ssday.service.IndexService;
import net.ssday.util.Page;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private IndexService indexService;
	ArrayList<Article> articles=new ArrayList();
	Page page=new Page();
	int currentPage;
	int totalPage;
	
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(this.indexService!=null)
			articles=this.indexService.show();
		
		if(this.currentPage==0)
			this.currentPage=1;
		
		int size=articles.size();
		if(size%10==0)
			this.totalPage=size/10;
		else
			this.totalPage=size/10+1;
		
		page.setCurrentPage(this.currentPage);
		page.setTotalPage(this.totalPage);
		
		System.out.println(this.currentPage);
		System.out.println(this.totalPage);
		
		if(this.currentPage<=this.totalPage){
			articles=new ArrayList(articles.subList((this.currentPage-1)*10, ((this.currentPage-1)*10+10)>size?size:((this.currentPage-1)*10+10)));
			page.setArticles(this.articles);
		}
		
		Iterator<Article> it1=articles.iterator();
		
		while(it1.hasNext()){
			Article atmp1=it1.next();
			atmp1.setParagraphs(atmp1.getContent().split("\n"));
		}
		
		if(articles.size()!=0)
			return SUCCESS;
		return INPUT;
	}

}

package bizLogic;

import java.util.ArrayList;

import vo.News;

public class NewsBL {
	private ArrayList<News> newslist;
	
	public NewsBL(){}
	
	public ArrayList<News> getNewsList(){
		
		News news = new News("title","content");
		newslist.add(news);
		
		return newslist;
	}
}

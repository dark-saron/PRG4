package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Article;

/**
 * 
 * @author Shayla
 *	 06_20_2013
 *
 *	Funktionen: liste get und set
 *	Funktionen (nicht implementieren): ordnen
 *  
 */

public class ArticelListLogic {
	
	public LinkedList<Article> getArticleList()
	{
		DBManager.open();
		LinkedList<Article> list =  DBManager.queryAllArticle();
		DBManager.close();
		
		return list;
	}
	
	//future feature
	public LinkedList<Article> orderArticleList(int order)
	{	
		//call of db funktion to get list with articles with order []
		return null;
	}
	
	public LinkedList<Article> filterArticleList(int filter)
	{
		//call of db funktion to get list with articles with filter []
		return null;
	}
	
	
	
}

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
		if(DBManager.queryAllArticle() == null)
			return null;
		
		return DBManager.queryAllArticle();
	}
	
	public LinkedList<Article> setArticleList()
	{
		if(DBManager.queryAllArticle() == null)
			return null;
		
		return DBManager.queryAllArticle();
	}
	
}

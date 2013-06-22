package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Article;

/**
 * 
 * @author Sabine Lück
 *
 *Funktion: get
 *Funktion new Article
 *Funktion: bearbeiten Article
 *Funktion: lösch article
 *Funktion: 
 */

public class ArticelLogic {

	private DBManager dbManager;
	
	public ArticelLogic()
	{
		dbManager = new DBManager();
		
	}
	public boolean deleteArticle(int artID)
	{
		if(artID == -1)
			return false;
		return true;
	}
	
	public Article getArticle(int artID)
	{
		if(artID == -1)
			return null;
		return null;
	}
	
	//anlegen eines neuen Artikeln
	public boolean setNewArticle(int id, String type, String description, String place, String name,
			String photo, String ean_Isbn, String externalId)
	{
		//TODO: überprüfung des unhaltes
		Article art = new Article(id, type, description, place, name, photo, ean_Isbn, externalId);
		boolean status;
		
		//db connection um ein insert aufzurufen
		dbManager.open();
		status = dbManager.queryInsertArticle(art);
		dbManager.close();
		
		return status;
	}
	
	//bearbeiten eines Artikeln
	public boolean setArticle(Article article)
	{
		//db connection um ein insert aufzurufen
		return dbManager.queryInsertArticle(article);
	}
}

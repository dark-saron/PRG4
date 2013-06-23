package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Article;

/**
 * 
 * @author Sabine L�ck
 *
 *Funktion: get
 *Funktion new Article
 *Funktion: bearbeiten Article
 *Funktion: l�sch article
 *Funktion: 
 */

public class ArticelLogic {

	private DBManager dbManager;
	private Article art;
	
	public ArticelLogic()
	{
		dbManager = new DBManager();
		art = new Article();
		
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
		DBManager.open();
		art = dbManager.queryArticleDetails(artID);
		DBManager.close();
		
		return art;
	}
	
	//anlegen eines neuen Artikeln
	public boolean setNewArticle(int id, String type, String description, String place, String name,
			String photo, String ean_Isbn, String externalId)
	{
		//TODO: �berpr�fung des unhaltes
		Article art = new Article(id, type, description, place, name, photo, ean_Isbn, externalId);
		boolean status;
		
		//db connection um ein insert aufzurufen
		dbManager.open();
		status = dbManager.queryInsertArticle(art);
		dbManager.close();
		
		return status;
	}
	
	//bearbeiten eines Artikeln
	public boolean setArticle(int id, String type, String description, String place, String name,
			String photo, String ean_Isbn, String externalId)
	{
		Article art = new Article(id, type, description, place, name, photo, ean_Isbn, externalId);
		System.out.println(id + type + description + place + name + photo + ean_Isbn + externalId);
		boolean status;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		status = dbManager.queryUpdateArticle(art);
		DBManager.close();
		
		return status;
	}
}

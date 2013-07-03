package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import javax.servlet.RequestDispatcher;

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
	private Article art;
	private Boolean flag;
	
	public ArticelLogic()
	{
		dbManager = new DBManager();
		art = new Article();
		
	}
	public boolean deleteArticle(int artID)
	{
		flag = false;
		if(artID == -1)
			return flag;
		DBManager.open();
		flag = dbManager.queryDeleteArticle(artID);
		DBManager.close();
		
		return flag;
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

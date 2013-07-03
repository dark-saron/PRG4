function chkArticleFormular () {
	
	var errorText = "";
	
  if (document.forms['fArticle']['name'].value == "") {
	
    errorText += "<br>Bitte Ihren Namen eingeben!<br>";
    document.forms['fArticle']['name'].style.background = "red";
  }
  if (document.forms['fArticle']['description'].value == "") {
		
	    errorText += "<br>Bitte eine Beschreibung eingeben!<br>";
	    document.forms['fArticle']['description'].style.background = "red";
	  }
/*  if (document.forms['fArticle']['ean_isbn'].value == "") {
	
	    errorText += "<br>Bitte eine EAN/ ISBN eingeben eingeben!";
	    document.forms['fArticle']['ean_isbn'].style.background = "red";
	  }*/
  if (document.forms['fArticle']['externalID'].value == "") {
		
	    errorText += "Bitte Ihren Namen eingeben!";
	    document.forms['fArticle']['externalID'].style.background = "red";
	  }

  if (document.forms['fArticle']['place'].value == "") {
		
	    errorText += "\nBitte Ihren Namen eingeben!";
	    document.forms['fArticle']['place'].style.background = "red";
	  }

  	if(errorText != "")
  	{
  	  	document.getElementById("errorMsg").innerHTML = errorText;
  	  	return false;

  	}
  	
  	document.getElementById("fArticle").submit();
  		
}

function chkContactFormular () {
	
	var errorText = "";
	
  if (document.forms['formarticle']['name'].value == "") {
	
    errorText += "<br>Bitte Ihren Namen eingeben!<br>";
    document.forms['fArticle']['name'].style.background = "red";
  }
  
/*  if (document.forms['formarticle']['description'].value == "") {
		
	    errorText += "<br>Bitte eine Beschreibung eingeben!<br>";
	    document.forms['formarticle']['description'].style.background = "red";
	  }
  if (document.forms['formarticle']['ean_isbn'].value == "") {
	
	    errorText += "<br>Bitte eine EAN/ ISBN eingeben eingeben!";
	    document.forms['formarticle']['ean_isbn'].style.background = "red";
	  } */
  if (document.forms['formarticle']['externalID'].value == "") {
		alert("Falsche eingabe!");
	    errorText += "Bitte die Externe ID eingeben!";
	    document.forms['formarticle']['externalID'].style.background = "red";
	  }

  if (document.forms['formarticle']['place'].value == "") {
		
	    errorText += "\nBitte Lagerplatz eingeben!";
	    document.forms['formarticle']['place'].style.background = "red";
	  }

  if(errorText != "")
	{
	  	document.getElementById("errorMsg").innerHTML = errorText;
	  	return false;

	}

  document.getElementById("fArticle").submit();
}

function chkOfferFormular () {
	var flag=0;
	var errorText = "";
	
  if (document.forms['fOffer']['article_Id'].value == "") {
	
    errorText += "<br>Bitte Ihren Namen eingeben!<br>";
    document.forms['fOffer']['article_Id'].style.background = "red";
  }
  if (document.forms['fOffer']['startsaleprice'].value == "") {
		
	    errorText += "<br>Bitte eine Beschreibung eingeben!<br>";
	    document.forms['fOffer']['startsaleprice'].style.background = "red";
	  }
  if (document.forms['fOffer']['buynowprice'].value == "") {
	
	    errorText += "<br>Bitte eine EAN/ ISBN eingeben eingeben!";
	    document.forms['fOffer']['buynowprice'].style.background = "red";
	  }
  if (document.forms['fOffer']['start'].value == "") {
	    errorText += "Bitte Ihren Namen eingeben!";
	    document.forms['fOffer']['start'].style.background = "red";
	  }

  if (document.forms['fOffer']['auctionhouse'].value == "") {
		
	    errorText += "\nBitte Ihren Namen eingeben!";
	    document.forms['fOffer']['auctionhouse'].style.background = "red";
	  }

  if (document.forms['fOffer']['url'].value == "") {
	    errorText += "Bitte Ihren Namen eingeben!";
	    document.forms['fOffer']['url'].style.background = "red";
	  }

if (document.forms['fOffer']['end'].value == "") {
		
	    errorText += "\nBitte Ihren Namen eingeben!";
	    document.forms['fOffer']['end'].style.background = "red";
	  }

  
  if(errorText != "")
	{
	  	document.getElementById("errorMsg").innerHTML = errorText;
	  	return false;

	}
  
	document.getElementById("fOffer").submit();
}

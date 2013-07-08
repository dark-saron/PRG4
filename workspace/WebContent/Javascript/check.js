function chkArticleFormular () {
	
	var flag = true;
	
  if (document.forms['fArticle']['name'].value == "") {
	
	  flag = false; 
	  document.forms['fArticle']['name'].style.background = "red";
  }
 if (document.forms['fArticle']['externalID'].value == "") {
		
	  flag = false; 
	  document.forms['fArticle']['externalID'].style.background = "red";
	  }

  if (document.forms['fArticle']['place'].value == "") {
		
	    flag = false; 
	    document.forms['fArticle']['place'].style.background = "red";
	  }

  	if(!flag)
  	{
  	  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
  	  	return false;

  	}
  	
  	document.getElementById("fArticle").submit();
  		
}

function chkContactFormular () {
	
	var flag = true;
	
  if (document.forms['fContact']['cFirst_Name'].value == "") {
	  flag = false;
    document.forms['fContact']['cFirst_Name'].style.background = "red";
  }
  
  if (document.forms['fContact']['cLast_Name'].value == "") {
	  flag = false;
	  document.forms['fContact']['cLast_Name'].style.background = "red";
	  }
  if (document.forms['fContact']['aFirst_Name'].value == "") {
	  flag = false;
    document.forms['fContact']['aFirst_Name'].style.background = "red";
  }
  
  if (document.forms['fContact']['aLast_Name'].value == "") {
	  flag = false;
	  document.forms['fContact']['aLast_Name'].style.background = "red";
	  }

  if (document.forms['fContact']['aZip'].value == "") {
	  flag = false;
	  document.forms['fContact']['aZip'].style.background = "red";
	  }
  if (document.forms['fContact']['aCity'].value == "") {
	  flag = false;
	  document.forms['fContact']['aCity'].style.background = "red";
	  }

  if (document.forms['fContact']['aCountry'].value == "") {
	  flag = false;
	  document.forms['fContact']['aCountry'].style.background = "red";
	  }
  
	if(!flag)
  	{
  	  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
  	  	return false;

  	}

  document.getElementById("fContact").submit();
}

function chkOfferFormular () {
	var flag= true;
	
  if (document.forms['fOffer']['startsaleprice'].value == "") {
	  flag = false;
	  document.forms['fOffer']['startsaleprice'].style.background = "red";
	  }
  if (document.forms['fOffer']['buynowprice'].value == "") {
	  flag = false;
	  document.forms['fOffer']['buynowprice'].style.background = "red";
	  }
  if (document.forms['fOffer']['start'].value == "") {
	  flag = false;
	  document.forms['fOffer']['start'].style.background = "red";
	  }

  if (document.forms['fOffer']['auctionhouse'].value == "") {
	  flag = false;
	  document.forms['fOffer']['auctionhouse'].style.background = "red";
	  }

  if (document.forms['fOffer']['url'].value == "") {
	  flag = false;
	  document.forms['fOffer']['url'].style.background = "red";
	  }

  if(!flag)
	{
	  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
	  	return false;

	}
  
	document.getElementById("fOffer").submit();
}

function onChanged(elementId)
{
	if(document.getElementById(elementId).style.display == "none")
		document.getElementById(elementId).style.display = "block";
	else
		document.getElementById(elementId).style.display = "none";
}

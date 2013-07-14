
function chkArticleFormular () 
{
	
	var flag = true;
	
  if (document.forms['fArticle']['name'].value == "")
  {
	
	  flag = false; 
	  document.forms['fArticle']['name'].style.background = "red";
  }
  else
	  {
	  document.forms['fArticle']['name'].style.background = "white";

	  }

  if (document.forms['fArticle']['place'].value == "") 
  {
		
	    flag = false; 
	    document.forms['fArticle']['place'].style.background = "red";
	  }
  else
  {
  document.forms['fArticle']['place'].style.background = "white";

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
	
  if (document.forms['fContact']['cFirst_Name'].value == "")
  {
	  flag = false;
	  document.forms['fContact']['cFirst_Name'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['cFirst_Name'].style.background = "white";
  }

  
  if (document.forms['fContact']['cLast_Name'].value == "") 
  {
	  flag = false;
	  document.forms['fContact']['cLast_Name'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['cLast_Name'].style.background = "white";
  }
  
  if (document.forms['fContact']['aFirst_Name'].value == "") 
  {
	  flag = false;
	  document.forms['fContact']['aFirst_Name'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['aFirst_Name'].style.background = "white";
  }
  
  if (document.forms['fContact']['aLast_Name'].value == "" ) 	
  {
	  flag = false;
	  document.forms['fContact']['aLast_Name'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['aLast_Name'].style.background = "white";
  }

  if ((document.forms['fContact']['aZip'].value).length >= 0 && !( /^\d+$/.test(document.forms['fContact']['aZip'].value)) ) 
  {
	  flag = false;
	  document.forms['fContact']['aZip'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['aZip'].style.background = "white";
  }

  if (document.forms['fContact']['aCity'].value == "" ) 
  {
	  flag = false;
	  document.forms['fContact']['aCity'].style.background = "red";
 }
  else
  {
	  document.forms['fContact']['aCity'].style.background = "white";
  }

  if (document.forms['fContact']['aCountry'].value == "" ) 
  {
	  flag = false;
	  document.forms['fContact']['aCountry'].style.background = "red";
  }
  else
  {
	  document.forms['fContact']['aCountry'].style.background = "white";
  }
  
	if(!flag)
  	{
  	  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
  	  	return false;

  	}
	

  document.getElementById("fContact").submit();
}

function chkOfferFormular () 
{
	var flag= true;
	
  if (document.forms['fOffer']['startsaleprice'].value == "" || !(/^\d/.test(document.forms['fOffer']['startsaleprice'].value))) 
  {
	  flag = false;
	  document.forms['fOffer']['startsaleprice'].style.background = "red";
  }
  else
  {
	  if(document.forms['fOffer']['startsaleprice'].value.indexOf(",") != -1)
	  {
		  flag = false;
		  document.forms['fOffer']['startsaleprice'].style.background = "red";

	  }
	  else
		  document.forms['fOffer']['startsaleprice'].style.background = "white";
  
  }
  if (document.forms['fOffer']['buynowprice'].value == "" || !(/^\d/.test(document.forms['fOffer']['buynowprice'].value))) 
  {
	  flag = false;
	  document.forms['fOffer']['buynowprice'].style.background = "red";
  }
  else
  {
	  if(document.forms['fOffer']['buynowprice'].value.indexOf(",") != -1)
	  {
		  flag = false;
		  document.forms['fOffer']['buynowprice'].style.background = "red";
	  }

	  else
		  document.forms['fOffer']['buynowprice'].style.background = "white";
  }
  if (document.forms['fOffer']['start'].value == "") 
  {
	  flag = false;
	  document.forms['fOffer']['start'].style.background = "red";
  }
  else
  {
	  document.forms['fOffer']['start'].style.background = "white";
  }

  if (document.forms['fOffer']['auctionhouse'].value == "") 
  {
	  flag = false;
	  document.forms['fOffer']['auctionhouse'].style.background = "red";
  }
  else
  {
	  document.forms['fOffer']['auctionhouse'].style.background = "white";
  }
  
  if (document.forms['fOffer']['url'].value == "") 
  {
	  flag = false;
	  document.forms['fOffer']['url'].style.background = "red";
  }
  else
  {
	  document.forms['fOffer']['url'].style.background = "white";
  }
  
  
  if (document.forms['fOffer']['externalID'].value == "") 
  {	
	  flag = false; 
	  document.forms['fOffer']['externalID'].style.background = "red";
  }
  else
  {
	 document.forms['fOffer']['externalID'].style.background = "white";
  }
  
  if(!flag)
	{
	  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
	  	return false;

	}
  
	document.getElementById("fOffer").submit();
}

function chkBillFormular()
{
	var flag= true;
	if (document.forms['fBill']['newSellerAddress'].checked)
	{
		if (document.forms['fBill']['aFirst_Name'].value == "") 
		{
			flag = false;
		    document.forms['fBill']['aFirst_Name'].style.background = "red";
		}
		else
		{
			  document.forms['fBill']['aFirst_Name'].style.background = "white";
		}
		  
		  if (document.forms['fBill']['aLast_Name'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['aLast_Name'].style.background = "red";
		  }
		  else
		  {
			  document.forms['fBill']['aLast_Name'].style.background = "white";
		  }
		  
		  if (document.forms['fBill']['aStreet_Nr'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['aStreet_Nr'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['aStreet_Nr'].style.background = "white";
		  }
		  
		  if ((document.forms['fBill']['aZip'].value).length >= 0 && !( /^\d+$/.test(document.forms['fBill']['aZip'].value)) ) {
			  flag = false;
			  document.forms['fBill']['aZip'].style.background = "red";
			  }
		  else
			  {
			  document.forms['fBill']['aZip'].style.background = "white";
			  }

		  if (document.forms['fBill']['aCity'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['aCity'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['aCity'].style.background = "white";
		  }

		  if (document.forms['fBill']['aCountry'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['aCountry'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['aCountry'].style.background = "white";
		  }
	}
	
	if (document.forms['fBill']['newBuyerAddress'].checked)
	{
		if (document.forms['fBill']['bFirst_Name'].value == "") 
		{
			flag = false;
		    document.forms['fBill']['bFirst_Name'].style.background = "red";
		}
		else
		{
			  document.forms['fBill']['bFirst_Name'].style.background = "white";
		}
		  
		  if (document.forms['fBill']['bLast_Name'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['bLast_Name'].style.background = "red";
		  }
		  else
		  {
			  document.forms['fBill']['bLast_Name'].style.background = "white";
		  }
		  
		  if (document.forms['fBill']['bStreet_Nr'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['bStreet_Nr'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['bStreet_Nr'].style.background = "white";
		  }
		  
		  if ((document.forms['fBill']['bZip'].value).length >= 0 && !( /^\d+$/.test(document.forms['fBill']['bZip'].value)) ) {
			  flag = false;
			  document.forms['fBill']['bZip'].style.background = "red";
			  }
		  else
			  {
			  document.forms['fBill']['bZip'].style.background = "white";
			  }

		  if (document.forms['fBill']['bCity'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['bCity'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['bCity'].style.background = "white";
		  }

		  if (document.forms['fBill']['bCountry'].value == "" ) {
			  flag = false;
			  document.forms['fBill']['bCountry'].style.background = "red";
			  }
		  else
		  {
		  document.forms['fBill']['bCountry'].style.background = "white";
		  }
	}
			  
	  if (document.forms['fBill']['shippingCost'].value == "" || !(/^\d/.test(document.forms['fBill']['shippingCost'].value))) 
	  {
		  flag = false;
		  document.forms['fBill']['shippingCost'].style.background = "red";
	  }
	  else
	  {
		  if(document.forms['fBill']['shippingCost'].value.indexOf(",") != -1)
		  {
			  flag = false;
			  document.forms['fBill']['shippingCost'].style.background = "red";

		  }
		  else
			  document.forms['fBill']['shippingCost'].style.background = "white";
	  
	  }
	  
	  if (document.forms['fBill']['total'].value == "" || !(/^\d/.test(document.forms['fBill']['total'].value))) 
	  {
		  flag = false;
		  document.forms['fBill']['total'].style.background = "red";
	  }
	  else
	  {
		  if(document.forms['fBill']['total'].value.indexOf(",") != -1)
		  {
			  flag = false;
			  document.forms['fBill']['total'].style.background = "red";

		  }
		  else
			  document.forms['fBill']['total'].style.background = "white";
	  
	  }
	  
	  if(!flag)
		{
		  	document.getElementById("errorMsg").innerHTML = "Bitte korrigieren Sie Ihre Eingaben.";
		  	return false;

		}
	  
		document.getElementById("fBill").submit();
}


function onChanged(elementId)
{
	if(document.getElementById(elementId).style.display == "none")
		document.getElementById(elementId).style.display = "block";
	else
		document.getElementById(elementId).style.display = "none";
	
	
}


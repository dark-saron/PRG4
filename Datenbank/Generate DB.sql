SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`IArticle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`IArticle` (
  `idIArticle` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  `Description` VARCHAR(200) NULL ,
  `Place` VARCHAR(45) NOT NULL ,
  `Photo` VARCHAR(45) NULL ,
  `EAN_ISBN` VARCHAR(45) NULL ,
  `externalID` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idIArticle`) ,
  UNIQUE INDEX `idIArtikel_UNIQUE` (`idIArticle` ASC) ,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) ,
  UNIQUE INDEX `EAN_ISBN_UNIQUE` (`EAN_ISBN` ASC) ,
  UNIQUE INDEX `externalID_UNIQUE` (`externalID` ASC) )
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Book`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Book` (
  `idBook` INT NOT NULL AUTO_INCREMENT ,
  `Format` VARCHAR(45) NOT NULL ,
  `Language` VARCHAR(45) NOT NULL ,
  `Pages` INT NOT NULL ,
  `Publisher` VARCHAR(45) NOT NULL ,
  `IArticle_idIArticle` INT NULL ,
  PRIMARY KEY (`idBook`, `IArticle_idIArticle`) ,
  UNIQUE INDEX `idBuch_UNIQUE` (`idBook` ASC) ,
  INDEX `fk_Book_IArticle1_idx` (`IArticle_idIArticle` ASC) ,
  CONSTRAINT `fk_Book_IArticle1`
    FOREIGN KEY (`IArticle_idIArticle` )
    REFERENCES `mydb`.`IArticle` (`idIArticle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`CD_DVD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`CD_DVD` (
  `idCD_DVD` INT NOT NULL AUTO_INCREMENT ,
  `Format` VARCHAR(45) NOT NULL ,
  `Language` VARCHAR(45) NOT NULL ,
  `Discs` INT NOT NULL ,
  `Length` INT NOT NULL ,
  `Label` VARCHAR(45) NOT NULL ,
  `RegionID` VARCHAR(45) NOT NULL ,
  `IArticle_idIArticle` INT NULL ,
  PRIMARY KEY (`idCD_DVD`, `IArticle_idIArticle`) ,
  UNIQUE INDEX `idCD_DVD_UNIQUE` (`idCD_DVD` ASC) ,
  INDEX `fk_CD_DVD_IArticle1_idx` (`IArticle_idIArticle` ASC) ,
  CONSTRAINT `fk_CD_DVD_IArticle1`
    FOREIGN KEY (`IArticle_idIArticle` )
    REFERENCES `mydb`.`IArticle` (`idIArticle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Game`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Game` (
  `idGame` INT NOT NULL AUTO_INCREMENT ,
  `Genre` VARCHAR(45) NOT NULL ,
  `Language` VARCHAR(45) NOT NULL ,
  `Release_date` DATE NOT NULL ,
  `Size` FLOAT NOT NULL ,
  `subtitles` VARCHAR(45) NOT NULL ,
  `manual` VARCHAR(45) NOT NULL ,
  `Age_allowance` VARCHAR(45) NOT NULL ,
  `Publisher` VARCHAR(45) NOT NULL ,
  `IArticle_idIArticle` INT NULL ,
  PRIMARY KEY (`idGame`, `IArticle_idIArticle`) ,
  INDEX `fk_Game_IArticle1_idx` (`IArticle_idIArticle` ASC) ,
  CONSTRAINT `fk_Game_IArticle1`
    FOREIGN KEY (`IArticle_idIArticle` )
    REFERENCES `mydb`.`IArticle` (`idIArticle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Office_supply`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Office_supply` (
  `idoffice_supplies` INT NOT NULL AUTO_INCREMENT ,
  `IArticle_idIArticle` INT NULL ,
  PRIMARY KEY (`idoffice_supplies`, `IArticle_idIArticle`) ,
  UNIQUE INDEX `idBüroartikel_UNIQUE` (`idoffice_supplies` ASC) ,
  INDEX `fk_Office_supply_IArticle1_idx` (`IArticle_idIArticle` ASC) ,
  CONSTRAINT `fk_Office_supply_IArticle1`
    FOREIGN KEY (`IArticle_idIArticle` )
    REFERENCES `mydb`.`IArticle` (`idIArticle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT ,
  `Username` VARCHAR(45) NOT NULL ,
  `pw` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idUser`) ,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Address` (
  `idAddress` INT NOT NULL AUTO_INCREMENT ,
  `Firstname` VARCHAR(45) NOT NULL ,
  `Lastname` VARCHAR(45) NOT NULL ,
  `Street_Nr` VARCHAR(45) NOT NULL ,
  `Zip` VARCHAR(45) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `country` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAddress`) ,
  UNIQUE INDEX `idAddress_UNIQUE` (`idAddress` ASC) )
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Contact`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Contact` (
  `idContact` INT NOT NULL AUTO_INCREMENT ,
  `First_Name` VARCHAR(45) NOT NULL ,
  `Last_Name` VARCHAR(45) NOT NULL ,
  `Title` VARCHAR(45) NULL ,
  `Email` VARCHAR(45) NULL ,
  `Phone` VARCHAR(45) NULL ,
  `Mobile` VARCHAR(45) NULL ,
  `User_idUser` INT NULL ,
  `Shippingadress_idAddress` INT NOT NULL ,
  `Billingadress_idAddress1` INT NOT NULL ,
  PRIMARY KEY (`idContact`, `User_idUser`, `Shippingadress_idAddress`, `Billingadress_idAddress1`) ,
  UNIQUE INDEX `idContacts_UNIQUE` (`idContact` ASC) ,
  INDEX `fk_Contact_User1_idx` (`User_idUser` ASC) ,
  INDEX `fk_Contact_Address1_idx` (`Shippingadress_idAddress` ASC) ,
  INDEX `fk_Contact_Address2_idx` (`Billingadress_idAddress1` ASC) ,
  CONSTRAINT `fk_Contact_User1`
    FOREIGN KEY (`User_idUser` )
    REFERENCES `mydb`.`User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_Address1`
    FOREIGN KEY (`Shippingadress_idAddress` )
    REFERENCES `mydb`.`Address` (`idAddress` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_Address2`
    FOREIGN KEY (`Billingadress_idAddress1` )
    REFERENCES `mydb`.`Address` (`idAddress` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Offer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Offer` (
  `idOffer` INT NOT NULL AUTO_INCREMENT ,
  `Startsaleprice` FLOAT NOT NULL ,
  `Buynowprice` FLOAT NOT NULL ,
  `Start` DATE NOT NULL ,
  `End` DATE NULL ,
  `Product` VARCHAR(45) NOT NULL ,
  `Auctionhouse` VARCHAR(45) NOT NULL ,
  `URL` VARCHAR(45) NOT NULL ,
  `Status` VARCHAR(45) NOT NULL ,
  `CreatorID` INT NOT NULL ,
  `IArticle_idIArticle` INT NULL ,
  `User_idUser` INT NULL ,
  PRIMARY KEY (`idOffer`, `IArticle_idIArticle`, `User_idUser`) ,
  UNIQUE INDEX `idOffer_UNIQUE` (`idOffer` ASC) ,
  INDEX `fk_Offer_IArticle1_idx` (`IArticle_idIArticle` ASC) ,
  INDEX `fk_Offer_User1_idx` (`User_idUser` ASC) ,
  CONSTRAINT `fk_Offer_IArticle1`
    FOREIGN KEY (`IArticle_idIArticle` )
    REFERENCES `mydb`.`IArticle` (`idIArticle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Offer_User1`
    FOREIGN KEY (`User_idUser` )
    REFERENCES `mydb`.`User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Bill` (
  `idBill` INT NOT NULL AUTO_INCREMENT ,
  `Buyer` VARCHAR(45) NOT NULL ,
  `Offer_ID` VARCHAR(45) NOT NULL ,
  `Total` FLOAT NOT NULL ,
  `Bought_at` DATE NOT NULL ,
  `Shipped_at` DATE NULL ,
  `Is_paid` TINYINT(1) NOT NULL ,
  `Paid_at` DATE NOT NULL ,
  `Shipping_cost` FLOAT NOT NULL ,
  `Offer_idOffer` INT NULL ,
  `Offer_IArticle_idIArticle` INT NULL ,
  `Offer_User_idUser` INT NULL ,
  `Contact_idContact` INT NULL ,
  PRIMARY KEY (`idBill`, `Offer_idOffer`, `Offer_IArticle_idIArticle`, `Offer_User_idUser`, `Contact_idContact`) ,
  UNIQUE INDEX `idBill_UNIQUE` (`idBill` ASC) ,
  INDEX `fk_Bill_Offer1_idx` (`Offer_idOffer` ASC, `Offer_IArticle_idIArticle` ASC, `Offer_User_idUser` ASC) ,
  INDEX `fk_Bill_Contact1_idx` (`Contact_idContact` ASC) ,
  CONSTRAINT `fk_Bill_Offer1`
    FOREIGN KEY (`Offer_idOffer` , `Offer_IArticle_idIArticle` , `Offer_User_idUser` )
    REFERENCES `mydb`.`Offer` (`idOffer` , `IArticle_idIArticle` , `User_idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_Contact1`
    FOREIGN KEY (`Contact_idContact` )
    REFERENCES `mydb`.`Contact` (`idContact` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

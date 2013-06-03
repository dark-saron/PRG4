SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Article` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Article` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Type` VARCHAR(10) NOT NULL ,
  `Name` VARCHAR(45) NOT NULL ,
  `Place` VARCHAR(45) NOT NULL ,
  `externalID` VARCHAR(45) NOT NULL ,
  `EAN_ISBN` VARCHAR(45) NULL ,
  `Description` VARCHAR(300) NULL ,
  `Photo` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `idIArtikel_UNIQUE` (`ID` ASC) ,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) ,
  UNIQUE INDEX `EAN_ISBN_UNIQUE` (`EAN_ISBN` ASC) ,
  UNIQUE INDEX `externalID_UNIQUE` (`externalID` ASC) )
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Username` VARCHAR(45) NOT NULL ,
  `pw` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `idUser_UNIQUE` (`ID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Address` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Address` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Firstname` VARCHAR(45) NOT NULL ,
  `Lastname` VARCHAR(45) NOT NULL ,
  `Street_Nr` VARCHAR(45) NOT NULL ,
  `Zip` VARCHAR(45) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `country` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `idAddress_UNIQUE` (`ID` ASC) )
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Contact` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Contact` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `First_Name` VARCHAR(45) NOT NULL ,
  `Last_Name` VARCHAR(45) NOT NULL ,
  `Title` VARCHAR(45) NULL ,
  `Email` VARCHAR(45) NULL ,
  `Phone` VARCHAR(45) NULL ,
  `Mobile` VARCHAR(45) NULL ,
  `UserID` INT NULL ,
  `ShippingadressID` INT NOT NULL ,
  `BillingadressID` INT NOT NULL ,
  PRIMARY KEY (`ID`, `UserID`, `ShippingadressID`, `BillingadressID`) ,
  UNIQUE INDEX `idContacts_UNIQUE` (`ID` ASC) ,
  INDEX `fk_Contact_User1_idx` (`UserID` ASC) ,
  INDEX `fk_Contact_Address1_idx` (`ShippingadressID` ASC) ,
  INDEX `fk_Contact_Address2_idx` (`BillingadressID` ASC) ,
  CONSTRAINT `fk_Contact_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `mydb`.`User` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_Address1`
    FOREIGN KEY (`ShippingadressID` )
    REFERENCES `mydb`.`Address` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_Address2`
    FOREIGN KEY (`BillingadressID` )
    REFERENCES `mydb`.`Address` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `mydb`.`Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Status` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Status` (
  `ID` INT NOT NULL ,
  `status` VARCHAR(12) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Offer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Offer` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Offer` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Startsaleprice` FLOAT NOT NULL ,
  `Buynowprice` FLOAT NOT NULL ,
  `Start` DATE NOT NULL ,
  `End` DATE NULL ,
  `Auctionhouse` VARCHAR(45) NOT NULL ,
  `URL` VARCHAR(45) NOT NULL ,
  `ArticleID` INT NULL ,
  `UserID` INT NULL ,
  `StatusID` INT NOT NULL ,
  PRIMARY KEY (`ID`, `ArticleID`, `UserID`, `StatusID`) ,
  UNIQUE INDEX `idOffer_UNIQUE` (`ID` ASC) ,
  INDEX `fk_Offer_IArticle1_idx` (`ArticleID` ASC) ,
  INDEX `fk_Offer_User1_idx` (`UserID` ASC) ,
  INDEX `fk_Offer_Status1_idx` (`StatusID` ASC) ,
  CONSTRAINT `fk_Offer_IArticle1`
    FOREIGN KEY (`ArticleID` )
    REFERENCES `mydb`.`Article` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Offer_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `mydb`.`User` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Offer_Status1`
    FOREIGN KEY (`StatusID` )
    REFERENCES `mydb`.`Status` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bill` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Bill` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `Total` FLOAT NOT NULL ,
  `Bought_at` DATE NOT NULL ,
  `Shipped_at` DATE NULL ,
  `Is_paid` TINYINT(1) NOT NULL ,
  `Paid_at` DATE NOT NULL ,
  `Shipping_cost` FLOAT NOT NULL ,
  `OfferID` INT NULL ,
  `Offer_ArticleID` INT NULL ,
  `Offer_UserID` INT NULL ,
  `ContactID` INT NULL ,
  PRIMARY KEY (`ID`, `OfferID`, `Offer_ArticleID`, `Offer_UserID`, `ContactID`) ,
  UNIQUE INDEX `idBill_UNIQUE` (`ID` ASC) ,
  INDEX `fk_Bill_Offer1_idx` (`OfferID` ASC, `Offer_ArticleID` ASC, `Offer_UserID` ASC) ,
  INDEX `fk_Bill_Contact1_idx` (`ContactID` ASC) ,
  CONSTRAINT `fk_Bill_Offer1`
    FOREIGN KEY (`OfferID` , `Offer_ArticleID` , `Offer_UserID` )
    REFERENCES `mydb`.`Offer` (`ID` , `ArticleID` , `UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_Contact1`
    FOREIGN KEY (`ContactID` )
    REFERENCES `mydb`.`Contact` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Article`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Article` (`ID`, `Type`, `Name`, `Place`, `externalID`, `EAN_ISBN`, `Description`, `Photo`) VALUES (1, 'Buch', '55 populäre Irrtümer über Pflanzen', 'box', 'BN0111', 'ISBN 9783-440-09971-1', '', NULL);
INSERT INTO `mydb`.`Article` (`ID`, `Type`, `Name`, `Place`, `externalID`, `EAN_ISBN`, `Description`, `Photo`) VALUES (2, 'Buch', 'Besondere Leistungsfeststellung Englisch', 'Ablage1', 'BN0012	', 'ISBN 9783-894-49652-4', '10. Klasse, Mündliche Prüfung', NULL);
INSERT INTO `mydb`.`Article` (`ID`, `Type`, `Name`, `Place`, `externalID`, `EAN_ISBN`, `Description`, `Photo`) VALUES (3, 'CDR', 'Crazy Machines - Neues aus dem Labor', 'GR3', 'BN0020', 'ISBN 4012-160-34336-7	', 'Puzzlespiel für Windows 98/ME/XP', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`User` (`ID`, `Username`, `pw`) VALUES (1, 'Jacobshagen', '1234');
INSERT INTO `mydb`.`User` (`ID`, `Username`, `pw`) VALUES (2, 'db_admin', '1234');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Address`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Address` (`ID`, `Firstname`, `Lastname`, `Street_Nr`, `Zip`, `city`, `country`) VALUES (1, 'Richard', 'Löwenherz', 'crossroad 1', '99086', 'Jerusalem', 'israel');
INSERT INTO `mydb`.`Address` (`ID`, `Firstname`, `Lastname`, `Street_Nr`, `Zip`, `city`, `country`) VALUES (2, 'James', 'Kirk', 'federation str. 1701', '52327', 'Riverside', 'USA');
INSERT INTO `mydb`.`Address` (`ID`, `Firstname`, `Lastname`, `Street_Nr`, `Zip`, `city`, `country`) VALUES (3, 'William', 'Shatner', 'homestreet 3', '98765', 'hometown', 'USA');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Contact`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Contact` (`ID`, `First_Name`, `Last_Name`, `Title`, `Email`, `Phone`, `Mobile`, `UserID`, `ShippingadressID`, `BillingadressID`) VALUES (1, 'Richard', 'Löwenherz', 'Sir', 'richard.loewenherz@crusade.org', NULL, NULL, 1, 1, 1);
INSERT INTO `mydb`.`Contact` (`ID`, `First_Name`, `Last_Name`, `Title`, `Email`, `Phone`, `Mobile`, `UserID`, `ShippingadressID`, `BillingadressID`) VALUES (2, 'James', 'Kirk', 'Admiral', 'J.T.Kirk@sternenflotte.us', '001911', '0123456789', 2, 2, 3);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Status`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Status` (`ID`, `status`) VALUES (1, 'offen');
INSERT INTO `mydb`.`Status` (`ID`, `status`) VALUES (2, 'gekauft');
INSERT INTO `mydb`.`Status` (`ID`, `status`) VALUES (3, 'abgelaufen');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mydb`.`Offer`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Offer` (`ID`, `Startsaleprice`, `Buynowprice`, `Start`, `End`, `Auctionhouse`, `URL`, `ArticleID`, `UserID`, `StatusID`) VALUES (1, 0.50, 2.99, '01.05.2013', '05.05.2013', 'Booklooker', 'a', 2, 1, 2);
INSERT INTO `mydb`.`Offer` (`ID`, `Startsaleprice`, `Buynowprice`, `Start`, `End`, `Auctionhouse`, `URL`, `ArticleID`, `UserID`, `StatusID`) VALUES (2, 0.50, 2.99, '01.05.2013', '05.05.2013', 'Booklooker', 'b', 3, 1, 2);
INSERT INTO `mydb`.`Offer` (`ID`, `Startsaleprice`, `Buynowprice`, `Start`, `End`, `Auctionhouse`, `URL`, `ArticleID`, `UserID`, `StatusID`) VALUES (3, 5, 10, '06.05.2013', NULL, 'Booklooker', 'c', 1, 2, 1);

COMMIT;

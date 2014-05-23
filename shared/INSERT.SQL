/*
* INSERTION PERSONNE
*/
INSERT INTO `personne`(`idpersonne`, `namepersonne`, `passpersonne`, `mailpersonne`, `idjoueur`, `idadmin`) 
VALUES (1,'Walson','ReneWalson','rene.walson@gmail.com',null,null);

INSERT INTO `personne`(`idpersonne`, `namepersonne`, `passpersonne`, `mailpersonne`, `idjoueur`, `idadmin`) 
VALUES (2,'Quentin','QuentinReseau','quentin.reseau@gmail.com',null,null);

INSERT INTO `personne`(`idpersonne`, `namepersonne`, `passpersonne`, `mailpersonne`, `idjoueur`, `idadmin`) 
VALUES (3,'Ivan','Chocolat','klarman.ivan@gmail.com',null,null);
/*
* INSERTION JOUEUR
*/
/*********************************************************************************************************/
/************************************* ATTENTION CHANGER LA TABLE ****************************************/
/****************************************** POUR LES UPDATES *********************************************/
/*********************************************************************************************************/
UPDATE `test`.`personne` SET `idjoueur` = '1' WHERE `personne`.`idpersonne` = '1';
UPDATE `test`.`personne` SET `idjoueur` = '0' WHERE `personne`.`idpersonne` = '0';

INSERT INTO `joueur`(`idjoueur`, `levelclassement`, `nbpoint`, `nbvaisseau`, `idpersonne`) VALUES (0,'1','0','0','0');
INSERT INTO `joueur`(`idjoueur`, `levelclassement`, `nbpoint`, `nbvaisseau`, `idpersonne`) VALUES (1,'1','0','0','1');
/*
* INSERTION ADMIN 
*/
UPDATE `test`.`administrateur` SET `idadmin` = '0' WHERE `administrateur`.`idpersonne` = 2;
INSERT INTO `administrateur`(`idadmin`, `idpersonne`) VALUES (0,2);
/*
* INSERTION USINE
*/
INSERT INTO `usine`(`idusine`, `nameusine`, `levelusine`, `qteprodbymin`, `idjoueur`, `idtypeusine`) VALUES (0,'0','10',0,null);
INSERT INTO `usine`(`idusine`, `nameusine`, `levelusine`, `qteprodbymin`, `idjoueur`, `idtypeusine`) VALUES (1,'0','10',0,null);
/*
* INSERTION TYPE USINE
*/
INSERT INTO `type_usine`(`idtypeusine`, `nomtypeusine`) VALUES (0,'USINE OR');
INSERT INTO `type_usine`(`idtypeusine`, `nomtypeusine`) VALUES (1,'USINE METAL');
INSERT INTO `type_usine`(`idtypeusine`, `nomtypeusine`) VALUES (2,'USINE PIERRE');
INSERT INTO `type_usine`(`idtypeusine`, `nomtypeusine`) VALUES (3,'USINE NOURRITURE');
/*
* INSERTION TYPE RESSOURCE
*/
INSERT INTO `type_ressource`(`idtyperessource`, `nametyperessource`) VALUES (0,'OR');
INSERT INTO `type_ressource`(`idtyperessource`, `nametyperessource`) VALUES (1,'METAL');
INSERT INTO `type_ressource`(`idtyperessource`, `nametyperessource`) VALUES (2,'PIERRE');
INSERT INTO `type_ressource`(`idtyperessource`, `nametyperessource`) VALUES (3,'NOURRITURE');
/*
* INSERTION TYPE VAISSEAUX
*/
INSERT INTO `type_vaisseau`(`idtypevaisseau`, `nametypevaisseau`, `valattackvaisseau`, `valdefvaisseau`) VALUES (0,'Chasseur Léger','50','10');
INSERT INTO `type_vaisseau`(`idtypevaisseau`, `nametypevaisseau`, `valattackvaisseau`, `valdefvaisseau`) VALUES (1,'Chasseur Lourd','80','25');
INSERT INTO `type_vaisseau`(`idtypevaisseau`, `nametypevaisseau`, `valattackvaisseau`, `valdefvaisseau`) VALUES (2,'Destructeur','120','20');
/*
* INSERTION CONSTRUCTION VAISSEAUX
*/
INSERT INTO `construire`(`idjoueur`, `idtypevaisseau`, `qtevaisseauprod`) VALUES ('1',0,2);
INSERT INTO `construire`(`idjoueur`, `idtypevaisseau`, `qtevaisseauprod`) VALUES ('0',0,3);
INSERT INTO `construire`(`idjoueur`, `idtypevaisseau`, `qtevaisseauprod`) VALUES ('0',1,4);
INSERT INTO `construire`(`idjoueur`, `idtypevaisseau`, `qtevaisseauprod`) VALUES ('1',2,3);
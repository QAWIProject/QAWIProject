CREATE TABLE usine (idusine bigint NOT NULL, nameusine varchar(255), levelusine bigint, qteprodbymin bigint, idjoueur bigint, idtypeusine bigint);

CREATE TABLE joueur (idjoueur bigint NOT NULL, levelclassement bigint, nbpoint bigint, nbvaisseau bigint, idpersonne bigint);

CREATE TABLE personne (idpersonne bigint NOT NULL, namepersonne varchar(255), passpersonne varchar(255), mailpersonne varchar(255), idjoueur bigint, idadmin bigint);

CREATE TABLE type_vaisseau (idtypevaisseau bigint NOT NULL, nametypevaisseau varchar(255), valattackvaisseau bigint, valdefvaisseau bigint);

CREATE TABLE type_ressource (idtyperessource bigint NOT NULL, nametyperessource varchar(255));

CREATE TABLE administrateur (idadmin bigint NOT NULL, idpersonne bigint);

CREATE TABLE type_usine (idtypeusine bigint NOT NULL, nomtypeusine varchar(255));

CREATE TABLE construire (idjoueur bigint NOT NULL, idtypevaisseau bigint NOT NULL, qtevaisseauprod bigint);

CREATE TABLE produire (idusine bigint NOT NULL, idtyperessource bigint NOT NULL, qteressprod bigint);

ALTER TABLE usine ADD CONSTRAINT PK_usine PRIMARY KEY (idusine);

ALTER TABLE joueur ADD CONSTRAINT PK_joueur PRIMARY KEY (idjoueur);

ALTER TABLE personne ADD CONSTRAINT PK_personne PRIMARY KEY (idpersonne);

ALTER TABLE type_vaisseau ADD CONSTRAINT PK_type_vaisseau PRIMARY KEY (idtypevaisseau);

ALTER TABLE type_ressource ADD CONSTRAINT PK_type_ressource PRIMARY KEY (idtyperessource);

ALTER TABLE administrateur ADD CONSTRAINT PK_administrateur PRIMARY KEY (idadmin);

ALTER TABLE type_usine ADD CONSTRAINT PK_type_usine PRIMARY KEY (idtypeusine);

ALTER TABLE construire ADD CONSTRAINT PK_construire PRIMARY KEY (idjoueur, idtypevaisseau);

ALTER TABLE produire ADD CONSTRAINT PK_produire PRIMARY KEY (idusine, idtyperessource);

ALTER TABLE usine ADD CONSTRAINT FK_usine_idjoueur FOREIGN KEY (idjoueur) REFERENCES joueur (idjoueur);

ALTER TABLE usine ADD CONSTRAINT FK_usine_idtypeusine FOREIGN KEY (idtypeusine) REFERENCES type_usine (idtypeusine);

ALTER TABLE joueur ADD CONSTRAINT FK_joueur_idpersonne FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne);

ALTER TABLE personne ADD CONSTRAINT FK_personne_idjoueur FOREIGN KEY (idjoueur) REFERENCES joueur (idjoueur);

ALTER TABLE personne ADD CONSTRAINT FK_personne_idadmin FOREIGN KEY (idadmin) REFERENCES administrateur (idadmin);

ALTER TABLE administrateur ADD CONSTRAINT FK_administrateur_idpersonne FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne);

ALTER TABLE construire ADD CONSTRAINT FK_construire_idjoueur FOREIGN KEY (idjoueur) REFERENCES joueur (idjoueur);

ALTER TABLE construire ADD CONSTRAINT FK_construire_idtypevaisseau FOREIGN KEY (idtypevaisseau) REFERENCES type_vaisseau (idtypevaisseau);

ALTER TABLE produire ADD CONSTRAINT FK_produire_idusine FOREIGN KEY (idusine) REFERENCES usine (idusine);

ALTER TABLE produire ADD CONSTRAINT FK_produire_idtyperessource FOREIGN KEY (idtyperessource) REFERENCES type_ressource (idtyperessource);


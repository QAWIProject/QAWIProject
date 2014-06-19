#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


CREATE TABLE UTILISATEUR(
        id_utilisateur        int (11) Auto_increment  NOT NULL ,
        nom_utilisateur       Varchar (255) NOT NULL ,
        email_utilisateur     Varchar (250) NOT NULL ,
        mdp_utilisateur       Varchar (255) NOT NULL ,
        est_admin_utilisateur Bool NOT NULL ,
        nb_point_utilisateur  Int ,
        PRIMARY KEY (id_utilisateur )
)ENGINE=InnoDB;


CREATE TABLE PLANETE(
        id_planete             int (11) Auto_increment  NOT NULL ,
        nom_planete            Varchar (25) NOT NULL ,
        coordonee_planete      Int NOT NULL ,
        qte_or_planete         Int ,
        qte_argent_planete     Int ,
        qte_pierre_planete     Int ,
        qte_nourriture_planete Int ,
        id_utilisateur         Int NOT NULL ,
        id_univers             Int NOT NULL ,
        PRIMARY KEY (id_planete )
)ENGINE=InnoDB;


CREATE TABLE UNIVERS(
        id_univers  int (11) Auto_increment  NOT NULL ,
        nom_univers Varchar (25) NOT NULL ,
        PRIMARY KEY (id_univers )
)ENGINE=InnoDB;


CREATE TABLE VAISSEAU(
        id_veaiseau      int (11) Auto_increment  NOT NULL ,
        etat_vaisseau    Varchar (25) ,
        id_planete       Int NOT NULL ,
        id_type_vaisseau Int NOT NULL ,
        PRIMARY KEY (id_veaiseau )
)ENGINE=InnoDB;


CREATE TABLE TYPE_VAISSEAU(
        id_type_vaisseau                int (11) Auto_increment  NOT NULL ,
        nom_type_vaisseau               Varchar (25) NOT NULL ,
        prix_or_type_vaisseau           Int ,
        prix_argent_type_vaisseau       Int ,
        prix_pierre_type_vaisseau       Int ,
        prix_nourriture_type_vaisseau   Int ,
        nb_pts_attaque_type_vaisseau    Int ,
        nb_pts_defense_type_vaisseau    Int ,
        tmps_construction_type_vaisseau Int ,
        PRIMARY KEY (id_type_vaisseau )
)ENGINE=InnoDB;


CREATE TABLE BATIMENT(
        id_batiment                     int (11) Auto_increment  NOT NULL ,
        cout_or_reel_batiment           Int ,
        cout_argent_reel_batiment       Int ,
        cout_pierre_reel_batiment       Int ,
        cout_nourriture_reel_batiment   Int ,
        niveau_batiment                 Int ,
        tmps_construction_reel_batiment Int ,
        id_planete                      Int NOT NULL ,
        id_type_batiment                Int ,
        PRIMARY KEY (id_batiment )
)ENGINE=InnoDB;


CREATE TABLE TYPE_BATIMENT(
        id_type_batiment                        int (11) Auto_increment  NOT NULL ,
        nom_type_batiment                       Varchar (25) ,
        cout_or_initial_type_batiment           Int ,
        cout_argent_initial_type_batiment       Int ,
        cout_pierre_initial_type_batiment       Int ,
        cout_nourriture_initial_type_batiment   Int ,
        tmps_construction_initial_type_batiment Int ,
        PRIMARY KEY (id_type_batiment )
)ENGINE=InnoDB;


CREATE TABLE USINE(
        id_usine                        int (11) Auto_increment  NOT NULL ,
        cout_or_reel_usine              Int ,
        cout_argent_reel_usine          Int ,
        cout_pierre_reel_usine          Int ,
        cout_nourriture_reel_usine      Int ,
        qte_prod_or_reel_usine          Int ,
        qte_prod_argent_reel_usine      Int ,
        qte_prod_pierre_reel_usine      Int ,
        qte_prod_nourriture_reel_usine  Int ,
        niveau_usine                    Int ,
        tmps_construction_reel_batiment Int ,
        id_planete                      Int NOT NULL ,
        id_type_usine                   Int NOT NULL ,
        PRIMARY KEY (id_usine )
)ENGINE=InnoDB;


CREATE TABLE TYPE_USINE(
        id_type_usine                          int (11) Auto_increment  NOT NULL ,
        nom_type_usine                         Varchar (25) ,
        cout_or_initial_type_usine             Int ,
        cout_argent_initial_type_usine         Int ,
        cout_pierre_initial_type_usine         Int ,
        cout_nourriture_initial_type_usine     Int ,
        qte_prod_or_initial_type_usine         Int ,
        qte_prod_argent_initial_type_usine     Int ,
        qte_prod_pierre_initial_type_usine     Int ,
        qte_prod_nourriture_initial_type_usine Int ,
        tmps_construction_initial_type_usine   Int ,
        PRIMARY KEY (id_type_usine )
)ENGINE=InnoDB;

ALTER TABLE PLANETE ADD CONSTRAINT FK_PLANETE_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES UTILISATEUR(id_utilisateur);
ALTER TABLE PLANETE ADD CONSTRAINT FK_PLANETE_id_univers FOREIGN KEY (id_univers) REFERENCES UNIVERS(id_univers);
ALTER TABLE VAISSEAU ADD CONSTRAINT FK_VAISSEAU_id_planete FOREIGN KEY (id_planete) REFERENCES PLANETE(id_planete);
ALTER TABLE VAISSEAU ADD CONSTRAINT FK_VAISSEAU_id_type_vaisseau FOREIGN KEY (id_type_vaisseau) REFERENCES TYPE_VAISSEAU(id_type_vaisseau);
ALTER TABLE BATIMENT ADD CONSTRAINT FK_BATIMENT_id_planete FOREIGN KEY (id_planete) REFERENCES PLANETE(id_planete);
ALTER TABLE BATIMENT ADD CONSTRAINT FK_BATIMENT_id_type_batiment FOREIGN KEY (id_type_batiment) REFERENCES TYPE_BATIMENT(id_type_batiment);
ALTER TABLE USINE ADD CONSTRAINT FK_USINE_id_planete FOREIGN KEY (id_planete) REFERENCES PLANETE(id_planete);
ALTER TABLE USINE ADD CONSTRAINT FK_USINE_id_type_usine FOREIGN KEY (id_type_usine) REFERENCES TYPE_USINE(id_type_usine);

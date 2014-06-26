INSERT INTO univers(nom_univers) VALUES('BETA1');


INSERT INTO utilisateur (nom_utilisateur, email_utilisateur, mdp_utilisateur, est_admin_utilisateur, nb_point_utilisateur)
VALUES ('Walson','walson.g.rene@gmail.com','walsonMDP',false,2);

INSERT INTO utilisateur (nom_utilisateur, email_utilisateur, mdp_utilisateur, est_admin_utilisateur, nb_point_utilisateur)
VALUES ('Ivan','ivan@gmail.com','ivanMDP',false,1);

INSERT INTO utilisateur (nom_utilisateur, email_utilisateur, mdp_utilisateur, est_admin_utilisateur, nb_point_utilisateur)
VALUES ('Quentin','quentin@gmail.com','QuentinMDP',false,0);


INSERT INTO planete (nom_planete, coordonee_planete, qte_or_planete, qte_argent_planete, qte_pierre_planete, qte_nourriture_planete, id_utilisateur, id_univers) 
VALUES ('GameOfThrones',1,1000,1000,1000,1000, (SELECT id_utilisateur FROM utilisateur WHERE nom_utilisateur='Walson'), (SELECT id_univers FROM univers WHERE nom_univers='BETA1'));

INSERT INTO planete (nom_planete, coordonee_planete, qte_or_planete, qte_argent_planete, qte_pierre_planete, qte_nourriture_planete, id_utilisateur, id_univers)
VALUES ('IvanWorld',1,1000,1000,1000,1000, (SELECT id_utilisateur FROM utilisateur WHERE nom_utilisateur='Ivan'),(SELECT id_univers FROM univers WHERE nom_univers='BETA1'));

INSERT INTO planete (nom_planete, coordonee_planete, qte_or_planete, qte_argent_planete, qte_pierre_planete, qte_nourriture_planete, id_utilisateur, id_univers)
VALUES ('QuentinJava',1,1000,1000,1000,1000, (SELECT id_utilisateur FROM utilisateur WHERE nom_utilisateur='Quentin'), (SELECT id_univers FROM univers WHERE nom_univers='BETA1'));


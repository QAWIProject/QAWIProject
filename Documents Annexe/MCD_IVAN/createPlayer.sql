INSERT INTO `utilisateur`(`id_util`, `nom_util`, `email_util`, `mdp_util`, `est_admin_util`, `id_planete`) VALUES (0,"Ivan","klarman.ivan@gmail.com","MDP1992",false,null);
INSERT INTO `planete`(`id_planete`, `nom_planete`, `qte_or`, `qte_argent`, `qte_pierre`, `qte_nourriture`, `id_util`) VALUES (0,"Azeroth",100,100,100,0,0);
UPDATE `utilisateur` SET `id_planete`=0;

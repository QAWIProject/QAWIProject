-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mer 09 Juillet 2014 à 20:48
-- Version du serveur :  5.5.34
-- Version de PHP :  5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `QAWI`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

CREATE TABLE `appartenir` (
  `id_planete` bigint(20) NOT NULL,
  `id_univers` bigint(20) NOT NULL,
  PRIMARY KEY (`id_planete`,`id_univers`),
  KEY `FK_appartenir_id_univers` (`id_univers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

CREATE TABLE `batiment` (
  `id_batiment` bigint(20) NOT NULL AUTO_INCREMENT,
  `niveau_batiment` bigint(20) DEFAULT NULL,
  `cout_batiment` bigint(20) DEFAULT NULL,
  `id_planete` bigint(20) DEFAULT NULL,
  `id_type_batiment` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_batiment`),
  KEY `FK_batiment_id_planete` (`id_planete`),
  KEY `FK_batiment_id_type_batiment` (`id_type_batiment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `planete`
--

CREATE TABLE `planete` (
  `id_planete` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_planete` varchar(255) DEFAULT NULL,
  `qte_or` bigint(20) DEFAULT NULL,
  `qte_argent` bigint(20) DEFAULT NULL,
  `qte_pierre` bigint(20) DEFAULT NULL,
  `qte_nourriture` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_planete`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `planete`
--

INSERT INTO `planete` (`id_planete`, `nom_planete`, `qte_or`, `qte_argent`, `qte_pierre`, `qte_nourriture`) VALUES
(0, 'Azeroth', 134, 155, 870, 200),
(7, 'Molarine', 2370, 11850, 4740, 16920),
(8, 'Goldorak', 200, 200, 200, 200),
(9, 'Kyuto', 200, 200, 200, 200),
(10, 'AlexPlanete', 200, 200, 200, 200),
(11, 'Martor', 200, 200, 200, 200),
(12, 'Martor1992', 200, 200, 200, 200);

-- --------------------------------------------------------

--
-- Structure de la table `type_batiment`
--

CREATE TABLE `type_batiment` (
  `id_type_batiment` bigint(20) NOT NULL,
  `nom_type_batiment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_batiment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_usine`
--

CREATE TABLE `type_usine` (
  `id_type_usine` bigint(20) NOT NULL,
  `nom_type_usine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_usine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_usine`
--

INSERT INTO `type_usine` (`id_type_usine`, `nom_type_usine`) VALUES
(0, 'Usine Or'),
(1, 'Usine Argent'),
(2, 'Usine Pierre'),
(3, 'Usine Nourriture');

-- --------------------------------------------------------

--
-- Structure de la table `type_vaisseau`
--

CREATE TABLE `type_vaisseau` (
  `id_type_vaisseau` bigint(20) NOT NULL,
  `nom_type_vaisseau` varchar(255) DEFAULT NULL,
  `prix_or_type_vaisseau` bigint(20) DEFAULT NULL,
  `prix_argent_type_vaisseau` bigint(20) DEFAULT NULL,
  `prix_pierre_type_vaisseau` bigint(20) DEFAULT NULL,
  `prix_nourriture_type_vaisseau` bigint(20) DEFAULT NULL,
  `nb_point_attaque_type_vaisseau` bigint(20) DEFAULT NULL,
  `nb_point_vaisseau_type_vaisseau` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_type_vaisseau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_vaisseau`
--

INSERT INTO `type_vaisseau` (`id_type_vaisseau`, `nom_type_vaisseau`, `prix_or_type_vaisseau`, `prix_argent_type_vaisseau`, `prix_pierre_type_vaisseau`, `prix_nourriture_type_vaisseau`, `nb_point_attaque_type_vaisseau`, `nb_point_vaisseau_type_vaisseau`) VALUES
(0, 'Chasseur Léger', 20, 10, 10, 0, 50, 10),
(1, 'Chasseur Lourd', 40, 20, 20, 0, 70, 20),
(2, 'Vaisseau de Bataille', 80, 30, 20, 20, 200, 250),
(3, 'Vaisseau de Destruction', 30, 100, 30, 50, 400, 300),
(4, 'Croiseur', 80, 120, 50, 50, 200, 600),
(5, 'Bombardier', 500, 250, 200, 80, 1000, 400),
(6, 'Qawi ZX', 1000, 1000, 1200, 500, 1000, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `univers`
--

CREATE TABLE `univers` (
  `id_univers` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_univers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_univers`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `usine`
--

CREATE TABLE `usine` (
  `id_usine` bigint(20) NOT NULL AUTO_INCREMENT,
  `cout_or` bigint(20) NOT NULL,
  `cout_argent` bigint(20) NOT NULL,
  `cout_pierre` bigint(20) NOT NULL,
  `cout_nourriture` bigint(20) NOT NULL,
  `prod_usine` bigint(20) DEFAULT NULL,
  `niveau_usine` bigint(20) DEFAULT NULL,
  `id_planete` bigint(20) DEFAULT NULL,
  `id_type_usine` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usine`),
  KEY `FK_usine_id_planete` (`id_planete`),
  KEY `FK_usine_id_type_usine` (`id_type_usine`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `usine`
--

INSERT INTO `usine` (`id_usine`, `cout_or`, `cout_argent`, `cout_pierre`, `cout_nourriture`, `prod_usine`, `niveau_usine`, `id_planete`, `id_type_usine`) VALUES
(1, 40, 40, 40, 40, 400, 2, 0, 0),
(2, 20, 20, 20, 20, 200, 1, 0, 1),
(3, 20, 20, 20, 20, 200, 1, 0, 2),
(4, 20, 20, 20, 20, 200, 1, 0, 3),
(5, 100, 100, 100, 100, 10, 1, 7, 0),
(6, 100, 100, 200, 200, 50, 1, 7, 1),
(7, 400, 400, 400, 400, 20, 1, 7, 2),
(8, 450, 500, 500, 500, 70, 1, 7, 3);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_util` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_util` varchar(255) DEFAULT NULL,
  `email_util` varchar(255) DEFAULT NULL,
  `mdp_util` varchar(255) DEFAULT NULL,
  `point_util` int(11) NOT NULL,
  `est_admin_util` tinyint(1) DEFAULT NULL,
  `id_planete` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_util`),
  KEY `FK_utilisateur_id_planete` (`id_planete`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_util`, `nom_util`, `email_util`, `mdp_util`, `point_util`, `est_admin_util`, `id_planete`) VALUES
(0, 'Ivan', 'klarman.ivan@gmail.com', 'MDP1992', 0, 0, 0),
(1, 'Walson', 'walson.rene@gmail.com', 'toto1992', 0, 0, 7),
(2, 'Quentin', 'quentin.esgi@gmail.com', 'chatte1234', 0, 1, NULL),
(3, 'Admin', 'admin.qawi@gmail.com', 'admin1992', 0, 1, NULL),
(4, 'Goldorak', 'goldo@gmail.com', 'goldorak', 0, 0, 8),
(5, 'Kyuto', 'kyuto@yahoo.fr', 'kyuto1992', 0, 0, 9),
(6, 'Alexandra', 'alex@hotmail.com', 'alexandra', 0, 0, 10),
(7, 'Mesiane', 'mesiane12@gmail.com', 'mesiane1992', 0, 0, 11),
(8, 'Mesiane128', 'mesiane123@gmail.com', 'toto1992', 0, 0, 12);

-- --------------------------------------------------------

--
-- Structure de la table `vaisseau`
--

CREATE TABLE `vaisseau` (
  `id_vaisseau` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_planete` bigint(20) DEFAULT NULL,
  `id_type_vaisseau` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_vaisseau`),
  KEY `FK_vaisseau_id_planete` (`id_planete`),
  KEY `FK_vaisseau_id_type_vaisseau` (`id_type_vaisseau`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=155 ;

--
-- Contenu de la table `vaisseau`
--

INSERT INTO `vaisseau` (`id_vaisseau`, `id_planete`, `id_type_vaisseau`) VALUES
(143, 0, 0),
(144, 0, 1),
(145, 0, 0),
(146, 0, 0),
(147, 0, 0),
(148, 0, 1),
(149, 0, 1),
(150, 0, 0),
(151, 0, 0),
(152, 0, 1),
(153, 0, 1),
(154, 0, 0);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD CONSTRAINT `FK_appartenir_id_planete` FOREIGN KEY (`id_planete`) REFERENCES `planete` (`id_planete`),
  ADD CONSTRAINT `FK_appartenir_id_univers` FOREIGN KEY (`id_univers`) REFERENCES `univers` (`id_univers`);

--
-- Contraintes pour la table `batiment`
--
ALTER TABLE `batiment`
  ADD CONSTRAINT `FK_batiment_id_planete` FOREIGN KEY (`id_planete`) REFERENCES `planete` (`id_planete`),
  ADD CONSTRAINT `FK_batiment_id_type_batiment` FOREIGN KEY (`id_type_batiment`) REFERENCES `type_batiment` (`id_type_batiment`);

--
-- Contraintes pour la table `usine`
--
ALTER TABLE `usine`
  ADD CONSTRAINT `FK_usine_id_planete` FOREIGN KEY (`id_planete`) REFERENCES `planete` (`id_planete`),
  ADD CONSTRAINT `FK_usine_id_type_usine` FOREIGN KEY (`id_type_usine`) REFERENCES `type_usine` (`id_type_usine`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_utilisateur_id_planete` FOREIGN KEY (`id_planete`) REFERENCES `planete` (`id_planete`);

--
-- Contraintes pour la table `vaisseau`
--
ALTER TABLE `vaisseau`
  ADD CONSTRAINT `FK_vaisseau_id_planete` FOREIGN KEY (`id_planete`) REFERENCES `planete` (`id_planete`),
  ADD CONSTRAINT `FK_vaisseau_id_type_vaisseau` FOREIGN KEY (`id_type_vaisseau`) REFERENCES `type_vaisseau` (`id_type_vaisseau`);

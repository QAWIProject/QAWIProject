-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mer 25 Juin 2014 à 11:11
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
  `id_util` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_planete`),
  KEY `FK_planete_id_util` (`id_util`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `planete`
--

INSERT INTO `planete` (`id_planete`, `nom_planete`, `qte_or`, `qte_argent`, `qte_pierre`, `qte_nourriture`, `id_util`) VALUES
(0, 'Azeroth', 0, 0, 0, 0, 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `usine`
--

INSERT INTO `usine` (`id_usine`, `cout_or`, `cout_argent`, `cout_pierre`, `cout_nourriture`, `prod_usine`, `niveau_usine`, `id_planete`, `id_type_usine`) VALUES
(1, 0, 0, 0, 0, 10, 1, 0, 0),
(2, 0, 0, 0, 0, 10, 1, 0, 1),
(3, 0, 0, 0, 0, 10, 1, 0, 2),
(4, 20, 30, 40, 30, 400, 2, 0, 3);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_util`, `nom_util`, `email_util`, `mdp_util`, `point_util`, `est_admin_util`, `id_planete`) VALUES
(0, 'Ivan', 'klarman.ivan@gmail.com', 'MDP1992', 0, 0, 0),
(1, 'Walson', 'walson.rene@gmail.com', 'toto1992', 0, 0, NULL),
(2, 'Quentin', 'quentin.esgi@gmail.com', 'chatte1234', 0, 1, NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=128 ;

--
-- Contenu de la table `vaisseau`
--

INSERT INTO `vaisseau` (`id_vaisseau`, `id_planete`, `id_type_vaisseau`) VALUES
(1, 0, 1),
(2, 0, 2),
(3, 0, 1),
(67, 0, 1),
(68, 0, 1),
(69, 0, 1),
(70, 0, 1),
(71, 0, 1),
(72, 0, 1),
(73, 0, 1),
(74, 0, 1),
(75, 0, 1),
(76, 0, 1),
(77, 0, 1),
(78, 0, 1),
(79, 0, 1),
(80, 0, 1),
(81, 0, 1),
(82, 0, 1),
(83, 0, 1),
(84, 0, 1),
(85, 0, 1),
(86, 0, 1),
(87, 0, 1),
(88, 0, 1),
(89, 0, 1),
(90, 0, 1),
(91, 0, 1),
(92, 0, 1),
(93, 0, 1),
(94, 0, 1),
(95, 0, 1),
(96, 0, 1),
(97, 0, 1),
(98, 0, 1),
(99, 0, 1),
(100, 0, 1),
(101, 0, 1),
(102, 0, 1),
(103, 0, 1),
(104, 0, 1),
(105, 0, 1),
(106, 0, 1),
(107, 0, 1),
(108, 0, 1),
(109, 0, 1),
(110, 0, 1),
(111, 0, 1),
(112, 0, 1),
(113, 0, 1),
(114, 0, 1),
(115, 0, 1),
(116, 0, 1),
(117, 0, 1),
(118, 0, 1),
(119, 0, 1),
(120, 0, 1),
(121, 0, 1),
(122, 0, 1),
(123, 0, 1),
(124, 0, 1),
(125, 0, 1),
(126, 0, 1),
(127, 0, 1);

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
-- Contraintes pour la table `planete`
--
ALTER TABLE `planete`
  ADD CONSTRAINT `FK_planete_id_util` FOREIGN KEY (`id_util`) REFERENCES `utilisateur` (`id_util`);

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

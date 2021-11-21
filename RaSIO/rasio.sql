-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 21 nov. 2021 à 15:30
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `rasio`
--

-- --------------------------------------------------------

--
-- Structure de la table `circuit`
--

DROP TABLE IF EXISTS `circuit`;
CREATE TABLE IF NOT EXISTS `circuit` (
  `nomCircuit` varchar(50) NOT NULL,
  `tailleCircuit` float NOT NULL,
  `paysCircuit` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `circuit`
--

INSERT INTO `circuit` (`nomCircuit`, `tailleCircuit`, `paysCircuit`) VALUES
('kek', 2581.5, 'fr'),
('lol', 48.3, 'fr');

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `nomCourse` varchar(50) NOT NULL,
  `typeCourse` varchar(50) NOT NULL,
  `nbSpectateurs` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`nomCourse`, `typeCourse`, `nbSpectateurs`) VALUES
('test', 'cestbeau', 64852);

-- --------------------------------------------------------

--
-- Structure de la table `ecurie`
--

DROP TABLE IF EXISTS `ecurie`;
CREATE TABLE IF NOT EXISTS `ecurie` (
  `nomEcurie` varchar(50) NOT NULL,
  `sponsorEcurie` varchar(50) NOT NULL,
  `motoristeEcurie` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ecurie`
--

INSERT INTO `ecurie` (`nomEcurie`, `sponsorEcurie`, `motoristeEcurie`) VALUES
('yo', 'good', 'yep');

-- --------------------------------------------------------

--
-- Structure de la table `mecanicien`
--

DROP TABLE IF EXISTS `mecanicien`;
CREATE TABLE IF NOT EXISTS `mecanicien` (
  `quaificationMec` varchar(50) NOT NULL,
  `dateQualifMec` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `nomPersonnel` varchar(50) NOT NULL,
  `prenomPersonnel` varchar(50) NOT NULL,
  `adressePersonnel` varchar(50) NOT NULL,
  `villePersonnel` varchar(50) NOT NULL,
  `cpPersonnel` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pilote`
--

DROP TABLE IF EXISTS `pilote`;
CREATE TABLE IF NOT EXISTS `pilote` (
  `numPilote` int(50) NOT NULL,
  `nationalitePilote` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `spectateur`
--

DROP TABLE IF EXISTS `spectateur`;
CREATE TABLE IF NOT EXISTS `spectateur` (
  `nomSpec` varchar(50) NOT NULL,
  `prenomSpec` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `pseudo` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`pseudo`, `mdp`) VALUES
('admin', 'admin'),
('jeje', '123');

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `marqueVoiture` varchar(50) NOT NULL,
  `modeleVoiture` varchar(50) NOT NULL,
  `nbCheveauxVoiture` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 17 déc. 2019 à 15:06
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tileee`
--

-- --------------------------------------------------------

--
-- Structure de la table `cards`
--

DROP TABLE IF EXISTS `cards`;
CREATE TABLE IF NOT EXISTS `cards` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `word` varchar(45) NOT NULL,
  `translation` varchar(45) NOT NULL,
  `starting_language` varchar(25) NOT NULL,
  `ending_language` varchar(25) NOT NULL,
  `value` double NOT NULL DEFAULT '0.5',
  PRIMARY KEY (`card_id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cards`
--

INSERT INTO `cards` (`card_id`, `user_id`, `word`, `translation`, `starting_language`, `ending_language`, `value`) VALUES
(21, 1, 'Bien que', 'Although', 'français', 'anglais', 0.5),
(22, 1, 'Et ainsi de suite', 'And so forth', 'français', 'anglais', 0.5),
(23, 1, 'Tout au long de', 'Throughout', 'français', 'anglais', 0.5),
(24, 1, 'Mettre en production/déployer', 'To deploy', 'français', 'anglais', 0.5),
(6, 1, 'Tedious', 'Fastidieux', 'français', 'anglais', 0.5),
(7, 1, 'Error-prone', 'Sujet au erreurs', 'franÃ§ais', 'anglais', 0.5),
(8, 1, 'Malicieusement', 'Maliciously', 'franÃ§ais', 'anglais', 0.5),
(9, 1, 'ProbabilitÃ©', 'Likelihood', 'franÃ§ais', 'anglais', 0.5),
(10, 1, 'Entrer en collision', 'To collide', 'franÃ§ais', 'anglais', 0.5),
(11, 1, 'sauf si', 'Unless', 'franÃ§ais', 'anglais', 0.5),
(12, 1, 'DerniÃ¨re', 'Latter', 'franÃ§ais', 'anglais', 0.5),
(13, 1, 'UnicitÃ©', 'Uniqueness', 'franÃ§ais', 'anglais', 0.5),
(14, 1, 'Inclure', 'To House', 'franÃ§ais', 'anglais', 0.5),
(15, 1, 'Gestionnaire', 'Handler', 'franÃ§ais', 'anglais', 0.5),
(16, 1, 'Remplacer', 'Supersede', 'franÃ§ais', 'anglais', 0.5),
(17, 1, 'subvenir aux besoins de', 'to provide for', 'franÃ§ais', 'anglais', 0.5),
(18, 1, 'ReprÃ©senter/dÃ©crire', 'to depict', 'franÃ§ais', 'anglais', 0.5),
(19, 1, 'AmÃ©liorer', 'to enhance', 'franÃ§ais', 'anglais', 0.5),
(20, 1, 'Caisse a outil', 'Go-to tool kit', 'franÃ§ais', 'anglais', 0.5),
(25, 1, 'S\'efforcer', 'to strive', 'franÃ§ais', 'anglais', 0.5),
(26, 1, 'par consequent', 'Therefore', 'franÃ§ais', 'anglais', 0.5),
(27, 1, 'avoir l\'intention de', 'to intend on+ing', 'franÃ§ais', 'anglais', 0.5),
(28, 1, 'de mÃªme que', 'Along with', 'franÃ§ais', 'anglais', 0.5),
(29, 1, 'faire prÃ©cÃ©der', 'to preface', 'franÃ§ais', 'anglais', 0.5),
(30, 1, 'Raccourci', 'Shortcut', 'franÃ§ais', 'anglais', 0.5),
(31, 1, 'une commande (informatique)', 'Switch', 'franÃ§ais', 'anglais', 0.5),
(32, 1, 'DÃ©gonfler/faire baisser/relancer', 'to deflate', 'franÃ§ais', 'anglais', 0.5),
(33, 1, 'Concurant', 'Concurrent', 'franÃ§ais', 'anglais', 0.5),
(34, 1, 'execution', 'Runtime', 'franÃ§ais', 'anglais', 0.5);

-- --------------------------------------------------------

--
-- Structure de la table `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `user_id` int(11) NOT NULL,
  `list_name` varchar(20) NOT NULL,
  `friend_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `invitations`
--

DROP TABLE IF EXISTS `invitations`;
CREATE TABLE IF NOT EXISTS `invitations` (
  `issuer_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `tag_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `invitations`
--

INSERT INTO `invitations` (`issuer_id`, `receiver_id`, `tag_name`) VALUES
(2, 3, 'Informatique'),
(3, 2, 'Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(15) NOT NULL,
  `password` varchar(65) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `registrationdate` date NOT NULL,
  `validation` tinyint(1) NOT NULL DEFAULT '0',
  `hashcode` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`user_id`, `login`, `password`, `mail`, `registrationdate`, `validation`, `hashcode`) VALUES
(2, 'Maxime', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-13', 1, '73756334726961736740746475686373656465736978617365786153'),
(3, 'Max', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-14', 1, '73756334726961736740746475686373656465736978617365786153'),
(4, 'Max59', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-16', 1, '737563347269617367407464756863736564657369786173653935786153'),
(5, 'Max59', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-16', 1, '737563347269617367407464756863736564657369786173653935786153');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

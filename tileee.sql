-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 15, 2019 at 03:51 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tileee`
--

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `id` int(11) NOT NULL,
  `word` varchar(45) NOT NULL,
  `translate` varchar(45) NOT NULL,
  `value` double NOT NULL DEFAULT '0.5',
  `lang1` varchar(25) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lang2` varchar(25) NOT NULL,
  `tag1` varchar(25) NOT NULL,
  `tag2` varchar(25) DEFAULT NULL,
  `tag3` varchar(25) DEFAULT NULL,
  `tag4` varchar(25) DEFAULT NULL,
  `tag5` varchar(25) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `word`, `translate`, `value`, `lang1`, `id_user`, `date`, `lang2`, `tag1`, `tag2`, `tag3`, `tag4`, `tag5`) VALUES
(21, 'Bien que', 'Although', 0.5, 'français', 1, '2019-11-23 18:12:22', 'anglais', '', NULL, NULL, NULL, NULL),
(22, 'Et ainsi de suite', 'And so forth', 0.5, 'français', 1, '2019-11-23 18:19:16', 'anglais', '', NULL, NULL, NULL, NULL),
(23, 'Tout au long de', 'Throughout', 0.5, 'français', 1, '2019-11-23 18:20:45', 'anglais', '', NULL, NULL, NULL, NULL),
(24, 'Mettre en production/déployer', 'To deploy', 0.5, 'français', 1, '2019-11-23 18:21:47', 'anglais', '', NULL, NULL, NULL, NULL),
(6, 'Tedious', 'Fastidieux', 0.5, 'français', 1, '2019-11-23 16:54:16', 'anglais', 'Adjectif', NULL, NULL, NULL, NULL),
(7, 'Error-prone', 'Sujet au erreurs', 0.5, 'franÃ§ais', 1, '2019-11-23 16:55:21', 'anglais', 'Adjectif', NULL, NULL, NULL, NULL),
(8, 'Malicieusement', 'Maliciously', 0.5, 'franÃ§ais', 1, '2019-11-23 16:56:22', 'anglais', 'Adjectif', NULL, NULL, NULL, NULL),
(9, 'ProbabilitÃ©', 'Likelihood', 0.5, 'franÃ§ais', 1, '2019-11-23 16:58:39', 'anglais', 'Nom', NULL, NULL, NULL, NULL),
(10, 'Entrer en collision', 'To collide', 0.5, 'franÃ§ais', 1, '2019-11-23 17:00:35', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(11, 'sauf si', 'Unless', 0.5, 'franÃ§ais', 1, '2019-11-23 17:12:31', 'anglais', 'Adverbe', NULL, NULL, NULL, NULL),
(12, 'DerniÃ¨re', 'Latter', 0.5, 'franÃ§ais', 1, '2019-11-23 17:24:55', 'anglais', 'Adjectif', NULL, NULL, NULL, NULL),
(13, 'UnicitÃ©', 'Uniqueness', 0.5, 'franÃ§ais', 1, '2019-11-23 17:33:52', 'anglais', 'Adverbe', NULL, NULL, NULL, NULL),
(14, 'Inclure', 'To House', 0.5, 'franÃ§ais', 1, '2019-11-23 17:38:16', 'anglais', '', NULL, NULL, NULL, NULL),
(15, 'Gestionnaire', 'Handler', 0.5, 'franÃ§ais', 1, '2019-11-23 17:42:39', 'anglais', 'Nom', NULL, NULL, NULL, NULL),
(16, 'Remplacer', 'Supersede', 0.5, 'franÃ§ais', 1, '2019-11-23 17:47:29', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(17, 'subvenir aux besoins de', 'to provide for', 0.5, 'franÃ§ais', 1, '2019-11-23 17:50:47', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(18, 'ReprÃ©senter/dÃ©crire', 'to depict', 0.5, 'franÃ§ais', 1, '2019-11-23 17:53:10', 'anglais', '', NULL, NULL, NULL, NULL),
(19, 'AmÃ©liorer', 'to enhance', 0.5, 'franÃ§ais', 1, '2019-11-23 17:55:11', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(20, 'Caisse a outil', 'Go-to tool kit', 0.5, 'franÃ§ais', 1, '2019-11-23 18:01:57', 'anglais', 'Nom', NULL, NULL, NULL, NULL),
(25, 'S\'efforcer', 'to strive', 0.5, 'franÃ§ais', 1, '2019-11-23 18:23:38', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(26, 'par consequent', 'Therefore', 0.5, 'franÃ§ais', 1, '2019-11-23 18:24:38', 'anglais', '', NULL, NULL, NULL, NULL),
(27, 'avoir l\'intention de', 'to intend on+ing', 0.5, 'franÃ§ais', 1, '2019-11-23 18:39:29', 'anglais', '', NULL, NULL, NULL, NULL),
(28, 'de mÃªme que', 'Along with', 0.5, 'franÃ§ais', 1, '2019-11-23 18:42:42', 'anglais', '', NULL, NULL, NULL, NULL),
(29, 'faire prÃ©cÃ©der', 'to preface', 0.5, 'franÃ§ais', 1, '2019-11-23 18:44:49', 'anglais', '', NULL, NULL, NULL, NULL),
(30, 'Raccourci', 'Shortcut', 0.5, 'franÃ§ais', 1, '2019-11-23 18:51:58', 'anglais', 'Nom', NULL, NULL, NULL, NULL),
(31, 'une commande (informatique)', 'Switch', 0.5, 'franÃ§ais', 1, '2019-11-23 18:58:43', 'anglais', '', NULL, NULL, NULL, NULL),
(32, 'DÃ©gonfler/faire baisser/relancer', 'to deflate', 0.5, 'franÃ§ais', 1, '2019-11-24 12:00:17', 'anglais', 'Verbe', NULL, NULL, NULL, NULL),
(33, 'Concurant', 'Concurrent', 0.5, 'franÃ§ais', 1, '2019-11-24 12:01:22', 'anglais', '', NULL, NULL, NULL, NULL),
(34, 'execution', 'Runtime', 0.5, 'franÃ§ais', 1, '2019-11-24 12:05:43', 'anglais', 'Informatique', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `invitations`
--

CREATE TABLE `invitations` (
  `id_giver` int(11) NOT NULL,
  `id_guest` int(11) NOT NULL,
  `tag` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invitations`
--

INSERT INTO `invitations` (`id_giver`, `id_guest`, `tag`) VALUES
(2, 3, 'Informatique'),
(3, 2, 'Informatique');

-- --------------------------------------------------------

--
-- Table structure for table `listfriend`
--

CREATE TABLE `listfriend` (
  `id_user` int(11) NOT NULL,
  `list` varchar(20) NOT NULL,
  `id_friend` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `pass` varchar(65) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `dateinscription` varchar(10) NOT NULL,
  `validation` tinyint(1) NOT NULL DEFAULT '0',
  `hashcode` varchar(70) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `name`, `pass`, `mail`, `dateinscription`, `validation`, `hashcode`) VALUES
(2, 'Maxime', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-13', 1, '73756334726961736740746475686373656465736978617365786153'),
(3, 'Max', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 'maximedeschodt@gmail.com', '2019-12-14', 1, '73756334726961736740746475686373656465736978617365786153');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cards`
--
ALTER TABLE `cards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

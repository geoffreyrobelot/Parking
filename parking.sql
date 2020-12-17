-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 22 mai 2020 à 16:31
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `parking`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `num` int(11) NOT NULL,
  `nom` varchar(25) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(25) COLLATE utf8_bin NOT NULL,
  `type` varchar(25) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `carte`
--

INSERT INTO `carte` (`num`, `nom`, `prenom`, `type`, `date`) VALUES
(1, 'Barjavel', 'Rene', 'Employe', '2020-05-05'),
(2, 'Miloud', 'Bernard', 'Visiteur', '2020-05-05'),
(3, 'Michel', 'Jean', 'Employe', '2020-05-05'),
(4, 'Bussi', 'Michel', 'Employe', '2020-05-07'),
(5, 'Koh lanta', 'Claude', 'Employe', '2020-05-10'),
(6, 'Kolanta', 'Sam', 'Employe', '2020-05-10'),
(7, 'Babar', 'Evian', 'Employe', '2020-05-18'),
(9, 'Hello', 'Renard', 'Visiteur', '2020-05-18'),
(10, 'Lermitte', 'Jean claude', 'Employe', '2020-05-22'),
(11, 'Jeanjean', 'Jacouille', 'Visiteur', '2020-05-22');

-- --------------------------------------------------------

--
-- Structure de la table `operateur`
--

CREATE TABLE `operateur` (
  `num` int(11) NOT NULL,
  `login` varchar(25) COLLATE utf8_bin NOT NULL,
  `mdp` varchar(25) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `operateur`
--

INSERT INTO `operateur` (`num`, `login`, `mdp`) VALUES
(1, 'root', 'root'),
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `stationnement`
--

CREATE TABLE `stationnement` (
  `num` int(11) NOT NULL,
  `dateentree` date NOT NULL,
  `datesortie` date DEFAULT NULL,
  `numCarte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `stationnement`
--

INSERT INTO `stationnement` (`num`, `dateentree`, `datesortie`, `numCarte`) VALUES
(1, '2020-05-19', '2020-05-22', 5),
(5, '2020-05-19', '2020-05-19', 5),
(6, '2020-05-19', '2020-05-19', 5),
(7, '2020-05-19', '2020-05-19', 5),
(8, '2020-05-19', '2020-05-19', 5),
(9, '2020-05-19', '2020-05-19', 5),
(10, '2020-05-19', '2020-05-19', 5),
(11, '2020-05-19', '2020-05-19', 7),
(12, '2020-05-19', '2020-05-19', 5),
(13, '2020-05-19', '2020-05-19', 5),
(14, '2020-05-19', '2020-05-19', 7),
(15, '2020-05-19', '2020-05-19', 7),
(16, '2020-05-19', '2020-05-19', 5),
(17, '2020-05-19', '2020-05-19', 5),
(18, '2020-05-19', '2020-05-19', 7),
(19, '2020-05-19', '2020-05-19', 5),
(20, '2020-05-19', '2020-05-19', 4),
(21, '2020-05-19', '2020-05-19', 4),
(22, '2020-05-19', '2020-05-19', 5),
(23, '2020-05-19', '2020-05-19', 4),
(24, '2020-05-19', '2020-05-19', 4),
(25, '2020-05-19', '2020-05-19', 7),
(26, '2020-05-19', '2020-05-19', 5),
(27, '2020-05-19', '2020-05-19', 5),
(28, '2020-05-19', '2020-05-19', 7),
(29, '2020-05-19', '2020-05-19', 5),
(30, '2020-05-19', '2020-05-19', 6),
(31, '2020-05-20', '2020-05-20', 4),
(32, '2020-05-20', '2020-05-20', 4),
(33, '2020-05-20', '2020-05-20', 4),
(34, '2020-05-20', '2020-05-20', 4),
(35, '2020-05-20', '2020-05-20', 6),
(36, '2020-05-20', '2020-05-20', 7),
(37, '2020-05-20', '2020-05-20', 6),
(38, '2020-05-20', '2020-05-20', 7),
(39, '2020-05-20', '2020-05-20', 7),
(40, '2020-05-20', '2020-05-20', 7),
(41, '2020-05-20', '2020-05-20', 7),
(42, '2020-05-20', '2020-05-20', 5),
(43, '2020-05-20', '2020-05-20', 7),
(44, '2020-05-20', '2020-05-20', 7),
(45, '2020-05-20', '2020-05-20', 7),
(46, '2020-05-20', '2020-05-20', 5),
(47, '2020-05-20', '2020-05-20', 6),
(48, '2020-05-20', '2020-05-20', 5),
(49, '2020-05-20', '2020-05-20', 5),
(50, '2020-05-20', '2020-05-22', 4),
(51, '2020-05-20', '2020-05-22', 6),
(52, '2020-05-20', '2020-05-20', 7),
(53, '2020-05-22', '2020-05-22', 5),
(54, '2020-05-22', '2020-05-22', 7),
(55, '2020-05-22', '2020-05-22', 7),
(56, '2020-05-22', '2020-05-22', 6),
(57, '2020-05-22', '2020-05-22', 7),
(58, '2020-05-22', '2020-05-22', 1),
(59, '2020-05-22', '2020-05-22', 1),
(60, '2020-05-22', '2020-05-22', 1),
(61, '2020-05-22', '2020-05-22', 1),
(62, '2020-05-22', '2020-05-22', 1),
(63, '2020-05-22', '2020-05-22', 1),
(64, '2020-05-22', '2020-05-22', 4),
(65, '2020-05-22', '2020-05-22', 1),
(66, '2020-05-22', '2020-05-22', 3),
(67, '2020-05-22', '2020-05-22', 3),
(68, '2020-05-22', '2020-05-22', 4),
(69, '2020-05-22', '2020-05-22', 5),
(70, '2020-05-22', NULL, 1),
(71, '2020-05-22', '2020-05-22', 5);

-- --------------------------------------------------------

--
-- Structure de la table `stationnementvisiteur`
--

CREATE TABLE `stationnementvisiteur` (
  `num` int(11) NOT NULL,
  `dateentree` date NOT NULL,
  `datesortie` date DEFAULT NULL,
  `numCarte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `stationnementvisiteur`
--

INSERT INTO `stationnementvisiteur` (`num`, `dateentree`, `datesortie`, `numCarte`) VALUES
(1, '2020-05-19', '2020-05-22', 2),
(2, '2020-05-20', '2020-05-22', 9),
(3, '2020-05-22', '2020-05-22', 9),
(4, '2020-05-22', '2020-05-22', 9),
(5, '2020-05-22', '2020-05-22', 2),
(6, '2020-05-22', '2020-05-22', 9),
(7, '2020-05-22', '2020-05-22', 9),
(8, '2020-05-22', '2020-05-22', 2),
(9, '2020-05-22', '2020-05-22', 9),
(10, '2020-05-22', '2020-05-22', 9),
(11, '2020-05-22', NULL, 9),
(12, '2020-05-22', '2020-05-22', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `operateur`
--
ALTER TABLE `operateur`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `stationnement`
--
ALTER TABLE `stationnement`
  ADD PRIMARY KEY (`num`),
  ADD KEY `numCarte` (`numCarte`);

--
-- Index pour la table `stationnementvisiteur`
--
ALTER TABLE `stationnementvisiteur`
  ADD PRIMARY KEY (`num`),
  ADD KEY `numCarte` (`numCarte`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `carte`
--
ALTER TABLE `carte`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `operateur`
--
ALTER TABLE `operateur`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `stationnement`
--
ALTER TABLE `stationnement`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT pour la table `stationnementvisiteur`
--
ALTER TABLE `stationnementvisiteur`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `stationnement`
--
ALTER TABLE `stationnement`
  ADD CONSTRAINT `stationnement_ibfk_1` FOREIGN KEY (`numCarte`) REFERENCES `carte` (`num`);

--
-- Contraintes pour la table `stationnementvisiteur`
--
ALTER TABLE `stationnementvisiteur`
  ADD CONSTRAINT `stationnementvisiteur_ibfk_1` FOREIGN KEY (`numCarte`) REFERENCES `carte` (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

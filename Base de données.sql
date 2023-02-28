-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 24 fév. 2023 à 04:14
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestiondaoarticle`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `reference` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `grammage` double DEFAULT NULL,
  `couleur` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`id`, `nom`, `description`, `prix`, `quantite`, `reference`, `marque`, `grammage`, `couleur`) VALUES
(1, 'Pain', 'nourriture', 450, 4, '', '', 0, ''),
(3, 'pain', 'le pain', 450, 41, '', '', 0, ''),
(4, 'Le Pain', 'c est du pain', 450, 450, 'StyloAs', 'Okpen', 0, ''),
(5, 'FAYA', 'Personne', 500, 4, 'Stylo', 'okpen', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandeart`
--

CREATE TABLE `commandeart` (
  `idCmdArt` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idArticle` int(11) NOT NULL,
  `qtArticle` int(11) NOT NULL,
  `facture` varchar(255) NOT NULL,
  `prixTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandelot`
--

CREATE TABLE `commandelot` (
  `idCmdLot` int(11) NOT NULL,
  `idLotArt` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `qtLot` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `lotarticle`
--

CREATE TABLE `lotarticle` (
  `idLot` int(11) NOT NULL,
  `qtArticle` int(11) NOT NULL,
  `prixLot` float NOT NULL,
  `pourcentage` float NOT NULL,
  `reference` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `libelleLot` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `commandeart`
--
ALTER TABLE `commandeart`
  ADD PRIMARY KEY (`idCmdArt`),
  ADD KEY `FK_CommandeArtClient` (`idClient`),
  ADD KEY `FK_CommandeArtArticle` (`idArticle`);

--
-- Index pour la table `commandelot`
--
ALTER TABLE `commandelot`
  ADD PRIMARY KEY (`idCmdLot`),
  ADD KEY `FK_CommandeLotLotArt` (`idLotArt`),
  ADD KEY `FK_CommandeLotClient` (`idClient`);

--
-- Index pour la table `lotarticle`
--
ALTER TABLE `lotarticle`
  ADD PRIMARY KEY (`idLot`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commandeart`
--
ALTER TABLE `commandeart`
  MODIFY `idCmdArt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commandelot`
--
ALTER TABLE `commandelot`
  MODIFY `idCmdLot` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `lotarticle`
--
ALTER TABLE `lotarticle`
  MODIFY `idLot` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commandeart`
--
ALTER TABLE `commandeart`
  ADD CONSTRAINT `FK_CommandeArtArticle` FOREIGN KEY (`idArticle`) REFERENCES `articles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CommandeArtClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commandelot`
--
ALTER TABLE `commandelot`
  ADD CONSTRAINT `FK_CommandeLotClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CommandeLotLotArt` FOREIGN KEY (`idLotArt`) REFERENCES `lotarticle` (`idLot`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 jan. 2023 à 16:26
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `store-management`
--

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `unite` varchar(60) DEFAULT NULL,
  `nom` varchar(500) NOT NULL,
  `PV` float NOT NULL,
  `PVT` float NOT NULL DEFAULT 0,
  `PAU` float DEFAULT NULL,
  `PAT` float DEFAULT NULL,
  `secteur` varchar(500) NOT NULL,
  `date_expiration` date NOT NULL,
  `statut` varchar(500) NOT NULL,
  `ajouter_le` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `products`
--

INSERT INTO `products` (`id`, `quantite`, `unite`, `nom`, `PV`, `PVT`, `PAU`, `PAT`, `secteur`, `date_expiration`, `statut`, `ajouter_le`) VALUES
(2, 20, 'tube', 'PARACETAMOL', 0.5, 10, 0.3, 6, 'Secteur 4', '2023-12-14', 'Active', '2022-12-04 22:22:58'),
(4, 15, 'Comprimes', 'AMIDOL', 0.5, 10, 0.3, 6, 'Secteur 4', '2023-12-14', 'Active', '2022-12-12 23:32:48'),
(5, 20, 'Comprimes', 'QUININE', 0.5, 10, 0.3, 6, 'Secteur 7', '2023-12-14', 'Active', '2022-12-13 00:05:50');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `created_at`) VALUES
(1, 'admin', '123456', '2022-11-28 10:45:21');

-- --------------------------------------------------------

--
-- Structure de la table `withdrawals`
--

CREATE TABLE `withdrawals` (
  `id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL,
  `nom_produit` varchar(500) NOT NULL,
  `prix_vente` float NOT NULL,
  `prix_vente_total` float NOT NULL,
  `quantite_vendu` int(11) NOT NULL,
  `date_vente` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `withdrawals`
--

INSERT INTO `withdrawals` (`id`, `produit_id`, `nom_produit`, `prix_vente`, `prix_vente_total`, `quantite_vendu`, `date_vente`) VALUES
(1, 4, 'AMIDOL', 1, 5, 5, '2023-01-11 14:34:35');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `withdrawals`
--
ALTER TABLE `withdrawals`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `withdrawals`
--
ALTER TABLE `withdrawals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

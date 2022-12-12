-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2017 at 11:09 PM
-- Server version: 5.6.15-log
-- PHP Version: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbrh`
--

-- --------------------------------------------------------

--
-- Table structure for table `avance`
--

CREATE TABLE IF NOT EXISTS `avance` (
  `code` int(15) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `nif` varchar(50) NOT NULL,
  `salaire` varchar(20) NOT NULL,
  `anposte` varchar(50) NOT NULL,
  `montant` varchar(50) NOT NULL,
  `dateavance` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `avance`
--

INSERT INTO `avance` (`code`, `nom`, `prenom`, `sexe`, `nif`, `salaire`, `anposte`, `montant`, `dateavance`) VALUES
(9, 'JOSEPH', 'Jennie', 'Féminin', '004-267-096-8', '85000', 'Secretaire', '88787', '2017-02-23'),
(8, 'JOSEPH', 'Jennie', 'Féminin', '004-267-096-8', '85000', 'Secretaire', '40000', '2017-02-23'),
(4, 'PAUL', 'Edelin', 'Masculin', '004-850-850-8', '95000', 'Administrateur', '85000', '2017-02-23'),
(5, 'JOSEPH', 'Jennie', 'Féminin', '004-267-096-8', '85000', 'Secretaire', '600', '2017-02-23');

-- --------------------------------------------------------

--
-- Table structure for table `conge`
--

CREATE TABLE IF NOT EXISTS `conge` (
  `ref` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `dateemb` varchar(25) NOT NULL,
  `poste` varchar(50) NOT NULL,
  `statut` varchar(25) NOT NULL,
  `typeconge` varchar(30) NOT NULL,
  `datedebut` varchar(25) NOT NULL,
  `datefin` varchar(25) NOT NULL,
  `njour` int(11) NOT NULL,
  `nif` varchar(50) NOT NULL,
  PRIMARY KEY (`ref`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=71 ;

--
-- Dumping data for table `conge`
--

INSERT INTO `conge` (`ref`, `nom`, `prenom`, `dateemb`, `poste`, `statut`, `typeconge`, `datedebut`, `datefin`, `njour`, `nif`) VALUES
(59, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. S. Solde', '2016-08-21', '2016-08-27', 6, '004-267-096-8'),
(60, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. S. Solde', '2016-08-21', '2016-08-27', 7, '004-267-096-8'),
(61, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. S. Solde', '2016-08-21', '2016-08-27', 1, '004-267-096-8'),
(62, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. S. Solde', '2016-08-21', '2016-08-28', 1, '004-267-096-8'),
(68, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. Payé', '2016-08-22', '2016-08-24', 2, '004-267-096-8'),
(69, 'JOSEPH', 'Jennie', '2016-08-11', 'Secretaire', 'Nommé Tps Plein', 'Cg. Payé', '2016-08-22', '2016-08-31', 9, '004-267-096-8'),
(70, 'LAURATY', 'jean lucien', '2016-08-20', 'chef', 'Contrat Tps Plein', 'Cg. Payé', '2016-09-06', '2016-09-20', 14, '004-267-090-1');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `datenais` date NOT NULL,
  `lieunais` varchar(50) NOT NULL,
  `nif` varchar(25) NOT NULL,
  `gsanguin` varchar(10) NOT NULL,
  `netude` varchar(25) NOT NULL,
  `poste` varchar(50) NOT NULL,
  `dateemb` date NOT NULL,
  `statut` varchar(20) NOT NULL,
  `salaire` int(11) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`nom`, `prenom`, `sexe`, `datenais`, `lieunais`, `nif`, `gsanguin`, `netude`, `poste`, `dateemb`, `statut`, `salaire`, `telephone`, `email`) VALUES
('LAURATY', 'jean lucien', 'Masculin', '2016-08-20', 'Cap Ht', '004-267-090-1', 'A+', 'Certificat', 'chef', '2016-08-20', 'Contrat Tps Plein', 65, '(509)01-55-15-14', 'lau@yahoo.fr'),
('LAURATY', 'Cedric Yohan', 'Féminin', '2015-10-16', 'PAP Ouest', '004-267-096-1', 'O+', 'Master', 'Prof Francais', '2015-11-18', 'Nommé Tps Plein', 100000, '(509)59-59-99-97', 'ced@yahoo.fr'),
('JOSEPH', 'Jennie', 'Féminin', '1996-08-16', 'Aquin', '004-267-096-8', 'AB+', 'Licence', 'Secretaire', '2016-08-11', 'Nommé Tps Plein', 85000, '(509)84-48-48-48', 'ker@yahoo.fr'),
('JOSEPH', 'Eliphete', 'Masculin', '2001-08-16', 'Limbe', '004-267-097-8', 'AB-', 'Licence', 'Chef de Service', '2009-08-15', 'Contrat Tps Plein', 65000, '(509)54-84-84-18', 'joseph@yahoo.fr'),
('DORVIL', 'Samson', 'Masculin', '2005-08-13', 'PAP', '004-267-098-0', 'O+', 'Master', 'SG', '2007-08-08', 'Nommé Tps Plein', 98000, '(509)65-66-56-56', 'dorvilier@yahoo.fr'),
('JOSEPH', 'Pierline', 'Féminin', '2009-08-15', 'Aquin', '004-267-098-1', 'AB-', 'Doctorat', 'Chef Cuisine', '2013-08-23', 'Contrat Tps Plein', 65000, '(509)11-66-46-66', 'pierline@yahoo.fr'),
('ALBERT', 'Marie Regine', 'Féminin', '2002-08-17', 'Aquin', '004-267-098-2', 'AB-', 'Doctorat', 'President', '2014-08-14', 'Nommé Tps Plein', 978000, '(509)49-94-94-94', 'lau@yahoo.fr'),
('PAUL', 'Edelin', 'Masculin', '1991-01-11', 'Cap Ht', '004-850-850-8', 'AB-', 'Master', 'Administrateur', '2013-06-20', 'Contrat Tps Plein', 95000, '(509)85-69-85-85', 'paul@yahoo.fr');

-- --------------------------------------------------------

--
-- Table structure for table `login_table`
--

CREATE TABLE IF NOT EXISTS `login_table` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_table`
--

INSERT INTO `login_table` (`username`, `password`) VALUES
('lauraty', 'pass1'),
('cedric', 'pass2');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE IF NOT EXISTS `promotion` (
  `Code` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `nif` varchar(50) NOT NULL,
  `niveau` varchar(30) NOT NULL,
  `anposte` varchar(50) NOT NULL,
  `nposte` varchar(50) NOT NULL,
  `datepromo` varchar(50) NOT NULL,
  `nsalaire` varchar(50) NOT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`Code`, `nom`, `prenom`, `sexe`, `nif`, `niveau`, `anposte`, `nposte`, `datepromo`, `nsalaire`) VALUES
(18, 'LAURATY', 'Jean Lucien', 'Masculin', '004-267-096-0', 'Certificat', 'chef', 'President', '2005-08-19', '100000'),
(19, 'LAURATY', 'Cedric', 'Masculin', '004-267-096-1', 'Certificat', 'chef2', 'Prof Francais', '2016-08-10', '100000'),
(20, 'ALBERT', 'Marie Regine', 'Féminin', '004-267-098-2', 'Doctorat', 'Secretaire', 'Chef de Service', '2016-08-22', '100000'),
(21, 'ALBERT', 'Marie Regine', 'Féminin', '004-267-098-2', 'Doctorat', 'Chef de Service', 'President', '2016-08-22', '978000'),
(22, 'DORVILIER', 'Samuel', 'Masculin', '004-267-098-0', 'Master', 'Chargé de Mission', 'SG', '2016-08-24', '98000');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2020 at 09:19 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrestomenu`
--

-- --------------------------------------------------------

--
-- Table structure for table `bayar`
--

CREATE TABLE `bayar` (
  `NoPesanan` varchar(5) NOT NULL,
  `KodeMenu` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bayar`
--

INSERT INTO `bayar` (`NoPesanan`, `KodeMenu`) VALUES
('2', '7'),
('2', '12'),
('3', '8'),
('3', '16'),
('3', '2'),
('3', '4'),
('4', '5'),
('4', '7'),
('5', '1'),
('5', '5'),
('5', '2'),
('5', '3');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `KodeMenu` varchar(5) NOT NULL,
  `NamaMenu` varchar(20) NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`KodeMenu`, `NamaMenu`, `Harga`) VALUES
('1', 'Ayam bakar', 10000),
('10', 'Kangkung cah ayam', 7500),
('11', 'Soto ayam', 8000),
('12', 'Nasi putih', 3000),
('13', 'Nasi uduk', 4000),
('14', 'Telor ceplok', 3500),
('15', 'Chicken steak', 12000),
('16', 'Es kelapa', 5000),
('17', 'Es jeruk   ', 4000),
('18', 'Dalgona', 19000),
('19', 'Es Kepal Milo', 9000),
('2', 'Ayam goreng', 11000),
('20', 'Es teh manis', 3000),
('21', 'Air mineral', 4000),
('22', 'Jus alpuket', 7500),
('23', 'Jus mangga', 7500),
('24', 'Jus melon', 8000),
('25', 'Jus sirsak ', 8000),
('26', 'Jus strawberry', 8000),
('27', 'Es cappucino', 7000),
('28', 'bubur', 30000),
('3', 'Soto ayam', 12000),
('4', 'Mie ayam', 9000),
('5', 'Nasi goreng', 11000),
('6', 'Mie goreng', 10000),
('7', 'Cumi asam manis', 8500),
('8', 'Udang goreng tepung', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `NoPesanan` varchar(5) NOT NULL,
  `NoMeja` varchar(5) NOT NULL,
  `TanggalPesanan` varchar(12) NOT NULL,
  `JumlahPesanan` int(11) NOT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`NoPesanan`, `NoMeja`, `TanggalPesanan`, `JumlahPesanan`, `Status`) VALUES
('1', '1', '02/8/2020', 2, 'sudahbayar'),
('2', '12', '02/8/2020', 2, 'sudahbayar'),
('3', '34', '02/8/2020', 4, 'belumbayar'),
('4', '12', '04/8/2020', 2, 'belumbayar'),
('5', '10', '04/8/2020', 4, 'belumbayar');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `Jabatan` varchar(20) NOT NULL,
  `Gaji` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Username`, `Password`, `Jabatan`, `Gaji`) VALUES
('Sri Wahyuni', '1234', 'admin', 3000000),
('Rachmat Fauzi', '2345', 'admin', 3000000),
('Nanda Rizki', '3456', 'admin', 3000000),
('Ayu Putri', '4567', 'admin', 3000000),
('Mitha Rachmani', '5678', 'admin', 3000000),
('Bella Rane', '123456', 'pelayan', 3000000),
('Lisa', '123456', 'pelayan', 2375000),
('Jennie', '123456', 'pelayan', 2375000),
('Jisoo', '123456', 'pelayan', 2375000),
('Rose', '123456', 'kasir', 2375000),
('Somi', '123456', 'kasir', 2375000),
('Irene', '123456', 'kasir', 2375000),
('Tyuzu', '123456', 'kasir', 2375000),
('Yoona', '123456', 'kasir', 2375000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`KodeMenu`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`NoPesanan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

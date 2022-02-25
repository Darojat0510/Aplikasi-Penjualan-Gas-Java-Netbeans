-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jul 2021 pada 05.17
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.3.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `papantulis`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kodebarang` varchar(20) NOT NULL,
  `namabarang` varchar(250) DEFAULT NULL,
  `ukuran` varchar(50) NOT NULL,
  `hargabeli` int(11) DEFAULT NULL,
  `hargajual` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kodebarang`, `namabarang`, `ukuran`, `hargabeli`, `hargajual`, `stok`) VALUES
('B001', 'Medical /Industri Gas Insallation', '1 Meter', 200000, 300000, 21),
('B002', 'Medical /Industri Gas Insallation', '2 Meter', 300000, 400000, 30),
('B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 300000, 400000, 29),
('B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 400000, 600000, 31),
('B005', 'Carbon Dioxide Gas/Liquid(C02)', '2 Meter', 400000, 600000, 23),
('B006', 'Nitrogen Gas /Liquid(N2)', '1 Meter', 350000, 500000, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `notrans` varchar(20) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `supplier` varchar(200) DEFAULT NULL,
  `kdbrng` varchar(20) DEFAULT NULL,
  `nmbrng` varchar(200) DEFAULT NULL,
  `ukuran` varchar(50) DEFAULT NULL,
  `hbeli` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `subtot` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`notrans`, `tgl`, `supplier`, `kdbrng`, `nmbrng`, `ukuran`, `hbeli`, `jumlah`, `subtot`, `total`) VALUES
('P001', '2021-07-07', 'PT MAJU BERSAMA', 'B002', 'Medical /Industri Gas Insallation', '2 Meter', 400000, 1, 400000, 2200000),
('P001', '2021-07-07', 'PT MAJU BERSAMA', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 2, 1200000, 2200000),
('P001', '2021-07-07', 'PT MAJU BERSAMA', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 1, 600000, 2200000),
('P002', '2021-07-07', 'PT MAJU BERSAMA', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 1, 600000, 3000000),
('P002', '2021-07-07', 'PT MAJU BERSAMA', 'B005', 'Carbon Dioxide Gas/Liquid(C02)', '2 Meter', 600000, 2, 1200000, 3000000),
('P002', '2021-07-07', 'PT MAJU BERSAMA', 'B005', 'Carbon Dioxide Gas/Liquid(C02)', '2 Meter', 600000, 2, 1200000, 3000000),
('P003', '2021-07-07', 'PT MAJU BERSAMA', 'B001', 'Medical /Industri Gas Insallation', '1 Meter', 300000, 1, 300000, 1100000),
('P003', '2021-07-07', 'PT MAJU BERSAMA', 'B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 400000, 1, 400000, 1100000),
('P003', '2021-07-07', 'PT MAJU BERSAMA', 'B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 400000, 1, 400000, 1100000),
('P004', '2021-07-07', 'PT MAJU BERSAMA', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 1, 600000, 1300000),
('P004', '2021-07-07', 'PT MAJU BERSAMA', 'B001', 'Medical /Industri Gas Insallation', '1 Meter', 300000, 1, 300000, 1300000),
('P004', '2021-07-07', 'PT MAJU BERSAMA', 'B002', 'Medical /Industri Gas Insallation', '2 Meter', 400000, 1, 400000, 1300000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `idpengguna` varchar(20) NOT NULL,
  `nama` varchar(250) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `hakakses` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`idpengguna`, `nama`, `username`, `password`, `hakakses`) VALUES
('U001', 'Darojat', 'darojat', 'darojat', 'Pemilik'),
('U002', 'Ajat', 'ajat', 'ajat', 'Kasir'),
('U003', 'ajat aja', 'ajataja', 'ajataja', 'Persediaan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `notrans` varchar(20) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `pembeli` varchar(200) DEFAULT NULL,
  `kdbrng` varchar(20) DEFAULT NULL,
  `nmbrng` varchar(200) DEFAULT NULL,
  `ukuran` varchar(50) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `subtot` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `ubay` int(11) DEFAULT NULL,
  `ukem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`notrans`, `tgl`, `pembeli`, `kdbrng`, `nmbrng`, `ukuran`, `harga`, `jumlah`, `subtot`, `total`, `ubay`, `ukem`) VALUES
('T001', '2021-07-07', 'Den', 'B002', 'Medical /Industri Gas Insallation', '2 Meter', 400000, 1, 400000, 1600000, 2000000, 400000),
('T001', '2021-07-07', 'Den', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 1, 600000, 1600000, 2000000, 400000),
('T001', '2021-07-07', 'Den', 'B005', 'Carbon Dioxide Gas/Liquid(C02)', '2 Meter', 600000, 1, 600000, 1600000, 2000000, 400000),
('T002', '2021-07-07', 'Den', 'B002', 'Medical /Industri Gas Insallation', '2 Meter', 400000, 1, 400000, 2000000, 3000000, 1000000),
('T002', '2021-07-07', 'Den', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 2, 1200000, 2000000, 3000000, 1000000),
('T002', '2021-07-07', 'Den', 'B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 400000, 1, 400000, 2000000, 3000000, 1000000),
('T003', '2021-07-07', 'den', 'B001', 'Medical /Industri Gas Insallation', '1 Meter', 300000, 1, 300000, 1700000, 2000000, 300000),
('T003', '2021-07-07', 'den', 'B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 400000, 1, 400000, 1700000, 2000000, 300000),
('T003', '2021-07-07', 'den', 'B003', 'Oxygen Gas/Liquid(02)', '1 Meter', 400000, 1, 400000, 1700000, 2000000, 300000),
('T003', '2021-07-07', 'den', 'B004', 'Nitrogen Gas /Liquid(N2)', '2 Meter', 600000, 1, 600000, 1700000, 2000000, 300000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `idsupplier` varchar(20) NOT NULL,
  `nama` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `notelpon` varchar(50) DEFAULT NULL,
  `alamat` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`idsupplier`, `nama`, `email`, `notelpon`, `alamat`) VALUES
('S001', 'PT MAJU BERSAMA', 'bersama@gmail.com', '02188979898', 'jl merdeka raya n023'),
('S002', 'PT ADIL BERSAMA', 'adilbersam@gmail.com', '02189281928', 'jl ciputat raya no 23');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kodebarang`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`idpengguna`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idsupplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

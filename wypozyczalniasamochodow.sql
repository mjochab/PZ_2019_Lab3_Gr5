-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Maj 2019, 01:00
-- Wersja serwera: 10.1.28-MariaDB
-- Wersja PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `nowabazadanych`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `administrator`
--

CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL,
  `pracownik_id` int(11) DEFAULT NULL,
  `login` varchar(30) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `haslo` varchar(30) CHARACTER SET utf16 COLLATE utf16_polish_ci DEFAULT NULL,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `pesel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `administrator`
--

INSERT INTO `administrator` (`admin_id`, `pracownik_id`, `login`, `haslo`, `imie`, `nazwisko`, `pesel`) VALUES
(1, 1, 'tommy', 'tommy', 'Tomasz', 'Chudzik', 1337);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `historia_udostepnien`
--

CREATE TABLE `historia_udostepnien` (
  `his_udostepnienie_id` int(11) NOT NULL,
  `klient_id` int(11) DEFAULT NULL,
  `marka` varchar(30) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `rocznik` int(11) DEFAULT NULL,
  `przebieg` float DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL,
  `cena` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `historia_udostepnien`
--

INSERT INTO `historia_udostepnien` (`his_udostepnienie_id`, `klient_id`, `marka`, `model`, `rocznik`, `przebieg`, `data_od`, `data_do`, `cena`) VALUES
(1, 1, 'Audi', 'A4', 1996, 189500, '2019-05-06', '2019-05-11', 590),
(2, 4, 'Audi', 'A1', 2005, 189500, '2019-05-03', '2019-05-12', 320),
(3, 3, 'Citroen', 'C5', 2005, 98500, '2019-04-24', '2019-04-30', 700);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `historia_wypozyczen`
--

CREATE TABLE `historia_wypozyczen` (
  `his_wypozyczenie_id` int(11) NOT NULL,
  `klient_id` int(11) DEFAULT NULL,
  `samochod_id` int(11) DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `historia_wypozyczen`
--

INSERT INTO `historia_wypozyczen` (`his_wypozyczenie_id`, `klient_id`, `samochod_id`, `data_od`, `data_do`) VALUES
(1, 1, 5, '2019-05-01', '2019-05-05'),
(2, 3, 4, '2019-05-01', '2019-05-05'),
(3, 4, 10, '2019-05-03', '2019-05-07'),
(4, 5, 1, '2019-04-24', '2019-04-29'),
(5, 2, 8, '2019-05-09', '2019-05-11'),
(6, 11, 24, '2019-05-09', '2019-08-10'),
(7, 20, 36, '2019-05-15', '2019-06-01'),
(8, 8, 19, '2019-06-29', '2019-07-08'),
(9, 1, 26, '2019-09-20', '2019-11-01'),
(10, 13, 22, '2019-05-14', '2019-05-19'),
(11, 15, 42, '2019-03-10', '2019-04-05'),
(12, 6, 28, '2019-05-30', '2019-06-01'),
(13, 18, 28, '2019-05-20', '2019-07-20'),
(14, 22, 29, '2019-05-02', '2019-08-04'),
(15, 4, 30, '2019-07-01', '2019-08-01'),
(16, 16, 38, '2019-06-14', '2019-08-01'),
(17, 19, 44, '2019-07-02', '2019-07-04'),
(18, 9, 3, '2019-05-15', '2019-05-17'),
(19, 19, 28, '2019-08-20', '2019-08-22'),
(20, 12, 17, '2019-02-02', '2019-03-02');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `klient_id` int(11) NOT NULL,
  `login` varchar(30) DEFAULT NULL,
  `haslo` varchar(30) DEFAULT NULL,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `data_urodzenia` date DEFAULT NULL,
  `miejscowosc` varchar(40) DEFAULT NULL,
  `pesel` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`klient_id`, `login`, `haslo`, `imie`, `nazwisko`, `data_urodzenia`, `miejscowosc`, `pesel`) VALUES
(1, 'klient', '123456', 'Adi', 'Nowak', '2000-12-12', 'Tarnów', 1337),
(2, 'tommy', 'tommy', 'Tomasz', 'Chudzik', '1993-12-12', 'Radymno', 1337),
(3, 'user1', 'user1', 'Jan', 'Kowalski', '1986-12-12', 'Rzeszów', 1337),
(4, 'user2', 'user', 'Piotr', 'Frankowski', '1966-10-18', 'Rzeszów', 1337),
(5, 'user3', 'user', 'Maciej', 'Frankowski', '2001-05-01', 'Kraków', 1337),
(6, 'Pawel99', 'Pawel00', 'Pawe?', 'Rzeszowski', '1998-08-11', 'Rzeszów', 1337),
(7, 'Janosik99', 'JaJanosik88', 'Marian', 'Akademicki', '1998-08-17', '?a?cut', 1337),
(8, 'Pawel99', 'Pawel00', 'Pawe?', 'Rzeszowski', '1998-08-11', 'Rzeszów', 1337),
(9, 'Janosik99', 'JaJanosik88', 'Marian', 'Akademicki', '1998-08-17', '?a?cut', 1337),
(11, 'Slawek59-9', 'abcd1234', 'S?awek', 'Niedziela', '1959-12-11', 'Gda?sk', 1337),
(12, 'Kwiat', '787878', 'Jan', 'Ró?a', '1996-12-01', 'Warszawa', 1337),
(13, 'administrator22', 'admin123', 'Kamil', 'Trzynasty', '1977-09-02', 'Jas?o', 1337),
(14, 'user4', 'TrustMe', 'Edward', 'Kminek', '1959-09-12', 'Lwów', 1337),
(15, 'user5', 'handlePasswd', 'Grzegorz', 'Marek', '1975-09-05', 'Drezno', 1337),
(16, 'user6', 'user6', 'Jan', 'Kowalski', '1969-03-03', 'Warszawa', 1337),
(17, 'user7', 'user7', 'Janina', 'Familia', '1992-01-01', 'Toru?', 1337),
(18, 'user7', 'user6', 'Jan', 'Kowalski', '1969-03-03', 'Warszawa', 1337),
(19, 'user8', 'user8', 'Radoslaw', 'Kubek', '1999-09-01', 'Paryz', 1337),
(20, 'user7', 'user7', 'Janina', 'Familia', '1992-01-01', 'Toru?', 1337),
(21, 'user9', 'user9', 'Florian', 'Kolorowy', '2000-02-02', 'Grodzisk Ma?opolski', 1337),
(22, 'user9', 'user9', 'Florian', 'Kolorowy', '2000-02-02', 'Grodzisk Ma?opolski', 1337),
(23, 'user8', 'user8', 'Radoslaw', 'Kubek', '1999-09-01', 'Paryz', 1337);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `pracownik_id` int(11) NOT NULL,
  `klient_id` int(11) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `haslo` varchar(30) DEFAULT NULL,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `pesel` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`pracownik_id`, `klient_id`, `login`, `haslo`, `imie`, `nazwisko`, `pesel`) VALUES
(1, 2, 'tommy', 'tommy', 'Tomasz', 'Chudzik', 1337),
(2, 3, 'user1', 'user', 'Jan', 'Kowalski', 1337),
(3, 11, 'admin', 'admin32312', 'Slawek', 'Niedziala', 1337),
(4, 8, 'TrustMeImAdmin', 'admin4422', 'Pawel', 'Rzeszowski', 1337);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `samochod`
--

CREATE TABLE `samochod` (
  `samochod_id` int(11) NOT NULL,
  `marka` varchar(30) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `rodzaj` varchar(30) NOT NULL,
  `paliwo` varchar(30) NOT NULL,
  `przebieg` int(11) NOT NULL,
  `Cena` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `samochod`
--

INSERT INTO `samochod` (`samochod_id`, `marka`, `model`, `rodzaj`, `paliwo`, `przebieg`, `Cena`) VALUES
(1, 'Audi', '80', 'Kombi', 'Benzyna', 189000, 250),
(2, 'Audi', 'A3', 'Hatchback', 'Diesel', 189000, 450),
(3, 'Audi', 'A8', 'Limuzyna', 'Benzyna', 59000, 1289),
(4, 'Peugeot', '307', 'Hatchback', 'Diesel', 349000, 380),
(5, 'Peugeot', '3008', 'SUV', 'Diesel', 143000, 670),
(6, 'Mercedes', 'CLK', 'Coupe', 'Benzyna', 23000, 2300),
(7, 'Mercedes', 'GLC', 'SUV', 'Benzyna', 3000, 1200),
(8, 'Ferrari', 'F12', 'Coupe', 'Benzyna', 1000, 6750),
(9, 'Fiat', 'Multipla', 'Minivan', 'LPG', 345500, 50),
(10, 'Fiat', 'Chroma', 'Kombi', 'LPG', 545500, 150),
(11, 'Mazda', 'RX-7', 'Coupe', 'Benzyna', 120000, 240),
(12, 'Fiat', '125p', 'Benzyna', 'Kombi', 132000, 320),
(13, 'Lincoln', 'Navigator', 'SUV', 'Diesel', 90000, 300),
(14, 'Porsche', '911', 'Coupe', 'Benzyna', 50000, 550),
(15, 'Toyota', 'Camry', 'Sedan', 'Benzyna', 95000, 100),
(16, 'Nissan', 'Stagea', 'Kombi', 'Benzyna', 40500, 300),
(17, 'Lexus', 'IS300', 'Sedan', 'Benzyna', 40000, 200),
(18, 'Ford', 'Mondeo MkIV', 'Sedan', 'Diesel', 98750, 100),
(19, 'Fiat', '126p', 'Fastback', 'Benzyna', 175000, 140),
(20, 'Opel', 'Vectra', 'Hatchback', 'Diesel', 66000, 200),
(21, 'Ford', 'Fiesta', 'Hatchback', 'Benzyna', 35000, 200),
(22, 'Smart', 'Forfour', 'Hatchback', 'Benzyna', 36000, 100),
(23, 'Subaru', 'Impreza', 'Sedan', 'Benzyna', 60000, 340),
(24, 'Subaru', 'Brat', 'Pick-Up', 'Benzyna', 50220, 125),
(25, 'Nissan', 'Micra', 'Kabriolet', 'Benzyna', 80000, 750),
(26, 'Honda', 'Legend', 'Sedan', 'Benzyna', 24000, 200),
(27, 'Toyota', 'MR-2', 'Coupe', 'Benzyna', 73000, 750),
(28, 'Ford', 'Mustang', 'Fastback', 'Benzyna', 87000, 124),
(29, 'Volkswagen', 'Passat', 'Sedan', 'Diesel', 151000, 125),
(30, 'Jeep', 'Wrangler', 'Hatchback', 'Diesel', 88000, 300),
(31, 'Toyota', 'Land Cruiser', 'SUV', 'Diesel', 20800, 150),
(32, 'Mercedes', 'Klasy A', 'Hatchback', 'Benzyna', 20000, 160),
(33, 'Skoda', 'Suberb', 'Sedan', 'Benzyna', 99000, 200),
(34, 'Mazda', 'RX-8', 'Sedan', 'Benzyna', 85000, 200),
(35, 'Opel', 'Corsa', 'Hatchback', 'Benzyna', 75000, 200),
(36, 'Citroen', 'C1', 'Hatchback', 'Benzyna', 24000, 900),
(37, 'Land Rover', 'Defender 90', 'Pick-up', 'Diesel', 85000, 500),
(38, 'MG', 'ZR', 'Hatchback', 'Benzyna', 90000, 700),
(39, 'Fiat', '500', 'Hatchback', 'Benzyna', 3000, 212),
(40, 'Honda', 'Civic', 'Sedan', 'Benzyna', 75000, 70),
(41, 'Nissan', '240SX', 'Hatchback', 'Benzyna', 75000, 450),
(42, 'Opel', 'Speedster', 'Coupe', 'Benzyna', 85000, 600),
(43, 'Lotus', 'Omega', 'Sedan', 'Benzyna', 10000, 250),
(44, 'Vauxhall', 'Monaro', 'Coupe', 'Benzyna', 25000, 100),
(45, 'Abarth', '500', 'Hatchback', 'Benzyna', 30000, 400),
(46, 'Mini', 'Cooper', 'Hatchback', 'Benzyna', 45000, 500);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `udostepnienie`
--

CREATE TABLE `udostepnienie` (
  `udostepnienie_id` int(11) NOT NULL,
  `klient_id` int(11) DEFAULT NULL,
  `marka` varchar(30) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `rocznik` int(11) DEFAULT NULL,
  `przebieg` float DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL,
  `cena` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `udostepnienie`
--

INSERT INTO `udostepnienie` (`udostepnienie_id`, `klient_id`, `marka`, `model`, `rocznik`, `przebieg`, `data_od`, `data_do`, `cena`) VALUES
(1, 1, 'Volkswagen', 'Passat', 2010, 45000, '2019-05-01', '2019-05-05', 1000),
(2, 3, 'Volkswagen', 'Bora', 1996, 425400, '2019-05-03', '2019-05-08', 230),
(3, 5, 'Lamborghini', 'Urus', 2019, 3000, '2019-05-09', '2019-05-11', 8000),
(4, 15, 'Fiat', 'Punto', 1999, 12500, '2019-05-10', '2019-05-12', 100),
(5, 17, 'Fiat', 'Panda', 2005, 75000, '2019-05-11', '2019-05-12', 50),
(6, 6, 'Honda', 'CRX', 1995, 30000, '2019-05-12', '2019-05-20', 100),
(7, 5, 'Lotus', 'Omega', 1995, 1000, '2019-05-20', '2019-05-30', 200),
(8, 8, 'Toyota', 'Corolla', 2008, 75000, '2019-05-10', '2019-05-30', 100),
(9, 7, 'Toyota', 'Camry', 1999, 125000, '2019-05-10', '2019-05-14', 100),
(10, 7, 'Nissan', 'Skyline R34', 1997, 50000, '2019-05-11', '2019-05-20', 150),
(11, 11, 'Opel', 'Vectra', 2010, 21000, '2019-05-15', '2019-06-10', 150);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenie`
--

CREATE TABLE `wypozyczenie` (
  `wypozyczenie_id` int(11) NOT NULL,
  `klient_id` int(11) DEFAULT NULL,
  `pracownik_id` int(11) DEFAULT NULL,
  `samochod_id` int(11) DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `wypozyczenie`
--

INSERT INTO `wypozyczenie` (`wypozyczenie_id`, `klient_id`, `pracownik_id`, `samochod_id`, `data_od`, `data_do`) VALUES
(1, 1, 1, 8, '2019-05-01', '2019-05-07'),
(2, 3, 1, 10, '2019-04-24', '2019-04-27'),
(3, 4, 1, 7, '2019-05-02', '2019-04-07'),
(4, 6, 2, 27, '2019-05-14', '2019-05-24'),
(5, 12, 1, 5, '2019-05-08', '2019-06-06'),
(7, 8, 2, 23, '2019-05-15', '2019-05-30'),
(8, 4, 2, 30, '2019-05-15', '2019-05-31'),
(9, 2, 2, 32, '2019-05-31', '2020-08-11'),
(10, 6, 4, 40, '2019-05-14', '2019-05-15'),
(11, 17, 2, 25, '2019-05-16', '2019-05-20'),
(12, 11, 2, 46, '2019-03-05', '2019-04-05'),
(13, 7, 1, 8, '2019-05-17', '2019-11-01'),
(14, 1, 3, 21, '2019-05-20', '2019-05-22'),
(15, 17, 4, 30, '2019-03-30', '2019-05-20'),
(16, 7, 2, 40, '2019-05-02', '2019-06-01'),
(17, 13, 1, 40, '2019-05-20', '2019-07-21'),
(18, 19, 3, 44, '2019-06-02', '2019-06-05'),
(19, 12, 2, 45, '2019-05-20', '2019-05-22'),
(20, 19, 1, 4, '2019-05-20', '2019-05-22');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `pracownik_id` (`pracownik_id`);

--
-- Indexes for table `historia_udostepnien`
--
ALTER TABLE `historia_udostepnien`
  ADD PRIMARY KEY (`his_udostepnienie_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indexes for table `historia_wypozyczen`
--
ALTER TABLE `historia_wypozyczen`
  ADD PRIMARY KEY (`his_wypozyczenie_id`),
  ADD KEY `klient_id` (`klient_id`),
  ADD KEY `samochod_id` (`samochod_id`);

--
-- Indexes for table `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`klient_id`);

--
-- Indexes for table `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`pracownik_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indexes for table `samochod`
--
ALTER TABLE `samochod`
  ADD PRIMARY KEY (`samochod_id`);

--
-- Indexes for table `udostepnienie`
--
ALTER TABLE `udostepnienie`
  ADD PRIMARY KEY (`udostepnienie_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indexes for table `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  ADD PRIMARY KEY (`wypozyczenie_id`),
  ADD KEY `klient_id` (`klient_id`),
  ADD KEY `samochod_id` (`samochod_id`),
  ADD KEY `pracownik_id` (`pracownik_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `administrator`
--
ALTER TABLE `administrator`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`pracownik_id`) REFERENCES `pracownik` (`pracownik_id`);

--
-- Ograniczenia dla tabeli `historia_udostepnien`
--
ALTER TABLE `historia_udostepnien`
  ADD CONSTRAINT `historia_udostepnien_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`klient_id`);

--
-- Ograniczenia dla tabeli `historia_wypozyczen`
--
ALTER TABLE `historia_wypozyczen`
  ADD CONSTRAINT `historia_wypozyczen_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`klient_id`),
  ADD CONSTRAINT `historia_wypozyczen_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`);

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD CONSTRAINT `pracownik_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`klient_id`);

--
-- Ograniczenia dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  ADD CONSTRAINT `udostepnienie_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`klient_id`);

--
-- Ograniczenia dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  ADD CONSTRAINT `wypozyczenie_ibfk_1` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`klient_id`),
  ADD CONSTRAINT `wypozyczenie_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`),
  ADD CONSTRAINT `wypozyczenie_ibfk_3` FOREIGN KEY (`pracownik_id`) REFERENCES `pracownik` (`pracownik_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

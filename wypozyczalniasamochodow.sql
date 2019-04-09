-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Kwi 2019, 18:36
-- Wersja serwera: 10.1.32-MariaDB
-- Wersja PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `wypozyczalniasamochodow`
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
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `pracownik_id` (`pracownik_id`);

--
-- Indeksy dla tabeli `historia_udostepnien`
--
ALTER TABLE `historia_udostepnien`
  ADD PRIMARY KEY (`his_udostepnienie_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indeksy dla tabeli `historia_wypozyczen`
--
ALTER TABLE `historia_wypozyczen`
  ADD PRIMARY KEY (`his_wypozyczenie_id`),
  ADD KEY `klient_id` (`klient_id`),
  ADD KEY `samochod_id` (`samochod_id`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`klient_id`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`pracownik_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indeksy dla tabeli `samochod`
--
ALTER TABLE `samochod`
  ADD PRIMARY KEY (`samochod_id`);

--
-- Indeksy dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  ADD PRIMARY KEY (`udostepnienie_id`),
  ADD KEY `klient_id` (`klient_id`);

--
-- Indeksy dla tabeli `wypozyczenie`
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
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

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

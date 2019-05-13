-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Maj 2019, 23:47
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt_zespolowe`
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
(5, 2, 8, '2019-05-09', '2019-05-11');

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
(5, 'user3', 'user', 'Maciej', 'Frankowski', '2001-05-01', 'Kraków', 1337);

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
(2, 3, 'user1', 'user', 'Jan', 'Kowalski', 1337);

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
(10, 'Fiat', 'Chroma', 'Kombi', 'LPG', 545500, 150);

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
(3, 5, 'Lamborghini', 'Urus', 2019, 3000, '2019-05-09', '2019-05-11', 8000);

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
(3, 4, 1, 7, '2019-05-02', '2019-04-07');

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

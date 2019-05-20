-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 20 Maj 2019, 11:54
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
-- Struktura tabeli dla tabeli `samochod`
--

CREATE TABLE `samochod` (
  `samochod_id` int(11) NOT NULL,
  `marka` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `rodzaj` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `rocznik` varchar(4) COLLATE utf32_polish_ci DEFAULT NULL,
  `paliwo` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `przebieg` int(11) DEFAULT NULL,
  `cena` float DEFAULT NULL,
  `dostepnosc` varchar(3) COLLATE utf32_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `samochod`
--

INSERT INTO `samochod` (`samochod_id`, `marka`, `model`, `rodzaj`, `rocznik`, `paliwo`, `przebieg`, `cena`, `dostepnosc`) VALUES
(1, 'Audi', 'A3', 'Hatchback', '1996', 'Benzyna', 195000, 195000, 'TAK'),
(2, 'Ford', 'Fiesta', 'Hatchback', '2003', 'Diesel', 125000, 250, 'TAK'),
(3, 'Audi', 'A4', 'Sedan', '1996', 'Benzyna', 195000, 420, 'NIE');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `udostepnienie`
--

CREATE TABLE `udostepnienie` (
  `udostepnienie_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `samochod_id` int(11) DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `udostepnienie`
--

INSERT INTO `udostepnienie` (`udostepnienie_id`, `user_id`, `samochod_id`, `data_od`, `data_do`) VALUES
(1, 11, 1, '2019-05-01', '2019-05-03');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `login` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `haslo` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `imie` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `nazwisko` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `data_urodzenia` date DEFAULT NULL,
  `miejscowosc` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `tel` int(9) DEFAULT NULL,
  `email` varchar(45) COLLATE utf32_polish_ci DEFAULT NULL,
  `pesel` int(11) DEFAULT NULL,
  `rodzaj` varchar(13) COLLATE utf32_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`user_id`, `login`, `haslo`, `imie`, `nazwisko`, `data_urodzenia`, `miejscowosc`, `tel`, `email`, `pesel`, `rodzaj`) VALUES
(36, 'tommy', 'tommy', 'Tomasz', 'Chudzik', '1993-12-12', 'Radymno', 535000535, 'email@email.pl', 2147483647, 'admin'),
(37, 'luki', 'luki', 'Łukasz', 'Kowalski', '1993-12-12', 'Sanok', 535000535, 'email@email.pl', 2147483647, 'admin'),
(38, 'fifi', 'fifi', 'Filip', 'Konior', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'admin'),
(39, 'pati', 'pati', 'Patryk', 'Krawiec', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'admin'),
(40, 'adi', 'adi', 'Adrian', 'Czupich', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'admin'),
(41, 'klient1', 'klient1', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(42, 'klient2', 'klient2', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(43, 'klient3', 'klient3', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(44, 'klient4', 'klient4', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(45, 'klient5', 'klient5', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(46, 'worker1', 'worker1', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(47, 'worker2', 'worker2', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(48, 'worker3', 'worker3', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(49, 'worker4', 'worker4', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(50, 'worker5', 'worker5', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenie`
--

CREATE TABLE `wypozyczenie` (
  `wypozyczenie_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `samochod_id` int(11) DEFAULT NULL,
  `data_od` date DEFAULT NULL,
  `data_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `wypozyczenie`
--

INSERT INTO `wypozyczenie` (`wypozyczenie_id`, `user_id`, `samochod_id`, `data_od`, `data_do`) VALUES
(1, 12, 2, '2019-05-01', '2019-05-07');

--
-- Indeksy dla zrzutów tabel
--

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
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `marka` (`samochod_id`),
  ADD KEY `user_id_3` (`user_id`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indeksy dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  ADD PRIMARY KEY (`wypozyczenie_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `samochod_id` (`samochod_id`),
  ADD KEY `samochod_id_2` (`samochod_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `samochod`
--
ALTER TABLE `samochod`
  MODIFY `samochod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  MODIFY `udostepnienie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  MODIFY `wypozyczenie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  ADD CONSTRAINT `udostepnienie_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `udostepnienie_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`);

--
-- Ograniczenia dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  ADD CONSTRAINT `wypozyczenie_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `wypozyczenie_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

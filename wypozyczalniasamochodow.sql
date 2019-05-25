-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Maj 2019, 12:54
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
  `rocznik` int(11) DEFAULT NULL,
  `paliwo` varchar(30) COLLATE utf32_polish_ci DEFAULT NULL,
  `przebieg` int(11) DEFAULT NULL,
  `cena` int(11) DEFAULT NULL,
  `dostepnosc` varchar(3) COLLATE utf32_polish_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `samochod`
--

INSERT INTO `samochod` (`samochod_id`, `marka`, `model`, `rodzaj`, `rocznik`, `paliwo`, `przebieg`, `cena`, `dostepnosc`, `user_id`) VALUES
(1, 'Audi', 'A3', 'Suv', 1996, 'Benzyna', 195000, 1500, 'TAK', 47),
(2, 'Audi', 'A3', 'Coupe', 1996, 'Benzyna', 250000, 130, 'NIE', 46),
(3, 'Pegueot', '206', 'Hatchback', 2006, 'Diesel', 150000, 250, 'TAK', 50),
(4, 'Renault', 'Laguna', 'Kombi', 1999, 'Gaz', 250000, 135, 'NIE', 51),
(5, 'Renault', 'Megane', 'Kombi', 2009, 'Diesel', 250000, 125, 'TAK', 48),
(6, 'Renault', 'Clio', 'Coupe', 2006, 'Gaz', 150000, 1500, 'NIE', 45),
(7, 'Citroen', 'C4', 'Hatchback', 2006, 'Benzyna', 150000, 150, 'NIE', 48);

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
(1, 49, 2, '2019-04-25', '2019-04-29'),
(2, 47, 7, '2019-05-11', '2019-05-14');

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
(38, 'klient1', 'klient1', 'Jan', 'Nowak', '1993-12-12', 'Lancut', 535000535, 'email@email.pl', 2147483647, 'worker'),
(42, 'klient2', 'klient3', 'Jan', 'Nowak', '1993-12-12', 'Lancut', 535000535, 'email@email.pl', 2147483647, 'worker'),
(43, 'klient3', 'klient3', 'Jan', 'Nowak', '1993-12-12', 'Łańcut', 535000535, 'email@email.pl', 2147483647, 'worker'),
(45, 'klient5', 'klient5', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'klient'),
(46, 'worker1', 'worker1', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(47, 'worker2', 'worker2', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(48, 'worker3', 'worker3', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'worker'),
(49, 'pracownik', 'pracownik', 'Łukasz', 'Kowalski', '1996-01-02', 'Sanok', 123456789, 'kofcio0@vp.pl', 1234567891, 'worker'),
(50, 'tommy', 'tommy', 'Tomasz', 'Chudzik', '1993-12-12', 'Radymno', 535000535, 'email@email.pl', 2147483647, 'admin'),
(51, 'luki', 'luki', 'Łukasz', 'Kowalski', '1993-12-12', 'Sanok', 535000535, 'email@email.pl', 2147483647, 'admin'),
(52, 'fifi', 'fifi', 'Filip', 'Konior', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'admin'),
(53, 'pati', 'pati', 'Patryk', 'Krawiec', '1993-12-12', 'Rzeszów', 535000535, 'email@email.pl', 2147483647, 'admin'),
(54, 'adi', 'adi', 'Adrian', 'Czupich', '1993-12-12', 'Łancut', 535000535, 'email@email.pl', 2147483647, 'admin');

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
(1, 49, 2, '2019-05-06', '2019-05-08'),
(2, 47, 7, '2019-05-01', '2019-05-03');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `samochod`
--
ALTER TABLE `samochod`
  ADD PRIMARY KEY (`samochod_id`),
  ADD KEY `user_id` (`user_id`);

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
  MODIFY `samochod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  MODIFY `udostepnienie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  MODIFY `wypozyczenie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `samochod`
--
ALTER TABLE `samochod`
  ADD CONSTRAINT `samochod_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Ograniczenia dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  ADD CONSTRAINT `udostepnienie_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `udostepnienie` (`user_id`),
  ADD CONSTRAINT `udostepnienie_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`);

--
-- Ograniczenia dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  ADD CONSTRAINT `wypozyczenie_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `udostepnienie` (`user_id`),
  ADD CONSTRAINT `wypozyczenie_ibfk_2` FOREIGN KEY (`samochod_id`) REFERENCES `samochod` (`samochod_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

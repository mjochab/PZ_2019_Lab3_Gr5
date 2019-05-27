-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 28 Maj 2019, 01:51
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
(1, 'Audi', 'Q8', 'Suv', 2015, 'Benzyna', 95000, 1500, 'NIE', 93),
(2, 'Audi', 'A3', 'Hatchback', 1996, 'Benzyna', 250000, 130, 'NIE', 93),
(3, 'Pegueot', '206', 'Hatchback', 2006, 'Diesel', 150000, 250, 'NIE', 48),
(4, 'Renault', 'Laguna', 'Kombi', 1999, 'Gaz', 250000, 135, 'TAK', 91),
(5, 'Renault', 'Megane', 'Kombi', 2009, 'Diesel', 250000, 125, 'TAK', 93),
(6, 'Renualt', 'Clio', 'Hatchback', 2006, 'Gaz', 150000, 1500, 'NIE', 93),
(7, 'Citroen', 'C4', 'Hatchback', 2006, 'Benzyna', 150000, 150, 'NIE', 92),
(8, 'Audi', 'TT', 'Coupe', 2005, 'Benzyna', 58000, 300, 'NIE', 93),
(9, 'Mazda', '6', 'Sedan', 2015, 'Benzyna', 15000, 500, 'TAK', 43),
(10, 'Audi', 'A8', 'Limuzyna', 2013, 'Diesel', 35000, 900, 'TAK', 93),
(11, 'Volvo', 'V40', 'Kombi', 2002, 'Benzyna', 195000, 150, 'TAK', 93),
(12, 'Peugoet', '1007', 'Hatchback', 2005, 'Gaz', 158000, 1300, 'TAK', 93),
(13, 'Porsche', 'Panamera', 'Suv', 2018, 'Benzyna', 23000, 950, 'TAK', 93),
(14, 'Maseratti', 'Quattroporte', 'Sedan', 2005, 'Diesel', 123500, 850, 'TAK', 93),
(15, 'Citroen', 'C6', 'Limuzyna', 2005, 'Diesel', 325000, 350, 'TAK', 93),
(16, 'Volkswagen', 'Passat', 'Sedan', 1999, 'Diesel', 198000, 2500, 'TAK', 93),
(17, 'Mercedes', 'G63', 'Suv', 2019, 'Benzyna', 5000, 1800, 'TAK', 93),
(18, 'Mercedes', 'CLK', 'Coupe', 2003, 'Diesel', 350500, 350, 'TAK', 93),
(19, 'Fiat', 'Tipo', 'Sedan', 2018, 'Gaz', 58400, 500, 'TAK', 38),
(20, 'Fiat', 'Panda', 'Hatchback', 2007, 'Diesel', 175000, 140, 'TAK', 93),
(21, 'Ford', 'Focus', 'Hatchback', 2015, 'Diesel', 100000, 730, 'TAK', 45),
(22, 'Chevrolet', 'Camaro', 'Coupe', 2017, 'Benzyna', 35500, 1800, 'TAK', 93),
(23, 'Ferrari', 'Enzo', 'Coupe', 2008, 'Benzyna', 25000, 5979, 'TAK', 51),
(24, 'Lamborghini', 'Hurracan', 'Coupe', 2016, 'Benzyna', 34532, 5979, 'TAK', 51),
(25, 'Lada', 'Samara', 'Hatchback', 1995, 'Benzyna', 350500, 59, 'TAK', 51),
(26, 'Pagani', 'Zonda', 'Coupe', 2008, 'Benzyna', 5000, 9755, 'TAK', 51),
(27, 'Honda', 'CRX', 'Hatchback', 1996, 'Benzyna', 255600, 125, 'TAK', 51),
(28, 'Ferrari', 'Enzo', 'Coupe', 2008, 'Benzyna', 25000, 5979, 'TAK', 51),
(29, 'Lamborghini', 'Hurracan', 'Coupe', 2016, 'Benzyna', 34532, 5979, 'TAK', 51),
(30, 'Lada', 'Samara', 'Hatchback', 1995, 'Benzyna', 350500, 59, 'TAK', 51),
(31, 'Pagani', 'Zonda', 'Coupe', 2008, 'Benzyna', 5000, 9755, 'TAK', 51),
(32, 'Honda', 'CRX', 'Hatchback', 1996, 'Benzyna', 255600, 125, 'TAK', 51),
(33, 'Ferrari', 'Enzo', 'Coupe', 2008, 'Benzyna', 25000, 5979, 'TAK', 51),
(34, 'Lamborghini', 'Hurracan', 'Coupe', 2016, 'Benzyna', 34532, 5979, 'TAK', 51),
(35, 'Lada', 'Samara', 'Hatchback', 1995, 'Benzyna', 350500, 59, 'TAK', 51),
(36, 'Pagani', 'Zonda', 'Coupe', 2008, 'Benzyna', 5000, 9755, 'TAK', 51),
(37, 'Honda', 'Civic', 'Hatchback', 1996, 'Benzyna', 255600, 125, 'TAK', 51);

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
(1, 91, 4, '2019-04-25', '2019-04-29'),
(2, 92, 7, '2019-05-11', '2019-05-14'),
(3, 45, 21, '2019-05-15', '2019-05-18'),
(4, 38, 19, '2019-05-16', '2019-05-17'),
(5, 43, 9, '2019-05-20', '2019-05-23'),
(6, 48, 3, '2019-05-05', '2019-05-07');

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
  `pesel` varchar(11) COLLATE utf32_polish_ci DEFAULT NULL,
  `rodzaj` varchar(13) COLLATE utf32_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_polish_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`user_id`, `login`, `haslo`, `imie`, `nazwisko`, `data_urodzenia`, `miejscowosc`, `tel`, `email`, `pesel`, `rodzaj`) VALUES
(7, 'pracownik', 'pracownik', 'Lukasz', 'Kowalski', '1996-01-02', 'Sanok', 123456789, 'kofcio0@vp.pl', '96012012345', 'worker'),
(38, 'klient1', 'klient1', 'Jan', 'Nowak', '1993-12-12', 'Lancut', 535123535, 'email1@email.pl', '93121212345', 'klient'),
(42, 'klient2', 'klient3', 'Jan', 'Nowak', '1993-12-12', 'Lancut', 535000123, 'email2@email.pl', '93121254321', 'klient'),
(43, 'klient3', 'klient3', 'Jan', 'Nowak', '1993-12-12', 'Łańcut', 535000500, 'email3@email.pl', '93121212543', 'klient'),
(45, 'klient5', 'klient5', 'Jan', 'Nowak', '1993-12-12', 'Łancut', 535890535, 'email12@email.pl', '93121200897', 'klient'),
(46, 'worker1', 'worker1', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 535525525, 'email4@email.pl', '93121215432', 'worker'),
(47, 'worker2', 'worker2', 'Paweł', 'Szybki', '1993-12-12', 'Rzeszów', 525545252, 'email5@email.pl', '93121209812', 'worker'),
(48, 'worker3', 'worker3', 'Paweł', 'Wolny', '1993-12-12', 'Rzeszów', 525444333, 'email6@email.pl', '93121208732', 'worker'),
(49, 'pracownik2', 'pracownik', 'Łukasz', 'Kowalski', '1996-01-02', 'Sanok', 333545321, 'kofcio1234@vp.pl', '96010222112', 'worker'),
(50, 'tommy', 'tommy', 'Tomasz', 'Chudzik', '1996-02-16', 'Radymno', 776343537, 'email67@email.pl', '96021612345', 'admin'),
(51, 'luki', 'luki', 'Łukasz', 'Kowalski', '1993-12-12', 'Sanok', 776343639, 'email68@email.pl', '93121255667', 'admin'),
(52, 'fifi', 'fifi', 'Filip', 'Konior', '1993-12-12', 'Łancut', 776343098, 'email69@email.pl', '93121200098', 'admin'),
(53, 'pati', 'pati', 'Patryk', 'Krawiec', '1993-12-12', 'Rzeszów', 776343232, 'email57@email.pl', '93121207345', 'admin'),
(54, 'adi', 'adi', 'Adrian', 'Czupich', '1993-12-12', 'Łancut', 776343555, 'email58@email.pl', '93121207776', 'admin'),
(55, 'tommy123', 'tommy', 'Tomasz', 'Chudzik', '1996-02-20', 'Radymno', 678000535, 'chudy12@gmail.com', '96022077788', 'klient'),
(56, 'tommy1234', 'tommy', 'Tomek', 'Chudy', '1996-02-20', 'Radymno', 567345890, 'chudy@gmail.com', '96022012333', 'worker'),
(91, 'klient', 'klient', 'Janusz', 'Bach', '1989-07-07', 'Szczecin', 707963123, 'bach@gmail.com', '89070712345', 'klient'),
(92, 'pracownik', 'pracownik', 'Mariusz', 'Strach', '1989-07-07', 'Szczecin', 707963434, 'strach@gmail.com', '89070754321', 'worker'),
(93, 'admin', 'admin', 'Marian', 'Wolan', '1989-07-07', 'Radom', 704213434, 'wolan@gmail.com', '89070754344', 'admin'),
(94, 'pracownik1000', 'pracownik1000', 'Ryszard', 'Nowak', '1991-05-20', 'Warszawa', 773050222, 'pracownik1000@email.com', '91052012345', 'worker'),
(95, 'klient1000', 'klient1000', 'Piotr', 'Pawlikowski', '1992-03-26', 'Warszawa', 773050333, 'klient1000@email.com', '92032612345', 'worker'),
(96, 'admin1000', 'admin1000', 'Piotr', 'Pawlikowski', '1984-08-11', 'Warszawa', 773050444, 'admin1000@email.com', '84081112345', 'worker'),
(97, 'pracownik1000', 'pracownik1000', 'Ryszard', 'Nowak', '1991-05-20', 'Warszawa', 773050222, 'pracownik1000@email.com', '91052012345', 'worker'),
(98, 'klient1000', 'klient1000', 'Piotr', 'Pawlikowski', '1992-03-26', 'Warszawa', 773050333, 'klient1000@email.com', '92032612345', 'worker'),
(99, 'admin1000', 'admin1000', 'Piotr', 'Pawlikowski', '1984-08-11', 'Warszawa', 773050444, 'admin1000@email.com', '84081112345', 'worker'),
(100, 'pracownik1000', 'pracownik1000', 'Ryszard', 'Nowak', '1991-05-20', 'Warszawa', 773050222, 'pracownik1000@email.com', '91052012345', 'worker'),
(101, 'klient1000', 'klient1000', 'Piotr', 'Pawlikowski', '1992-03-26', 'Warszawa', 773050333, 'klient1000@email.com', '92032612345', 'worker'),
(102, 'admin1001', 'admin1000', 'Piotr', 'Pawlikowski', '1984-08-11', 'Warszawa', 773050444, 'admin1000@email.com', '84081112345', 'worker'),
(103, 'admin1002', 'admin1000', 'Piotr', 'Pawlikowski', '1984-08-11', 'Warszawa', 773050494, 'admin1088@email.com', '84081112999', 'worker');

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
(1, 91, 1, '2019-05-06', '2019-05-25'),
(3, 91, 3, '2019-05-06', '2019-05-18'),
(6, 91, 2, '2019-05-06', '2019-05-18'),
(7, 92, 6, '2019-05-01', '2019-05-04'),
(8, 92, 7, '2019-05-20', '2019-05-27'),
(9, 92, 9, '2019-05-23', '2019-05-25'),
(10, 92, 13, '2019-06-01', '2019-06-08'),
(11, 92, 10, '2019-05-30', '2019-06-03'),
(12, 91, 11, '2019-06-05', '2019-06-07'),
(13, 91, 14, '2019-05-30', '2019-05-31');

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
  ADD KEY `user_id_3` (`user_id`),
  ADD KEY `user_id_4` (`user_id`);

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
  ADD KEY `samochod_id_2` (`samochod_id`),
  ADD KEY `user_id_2` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `samochod`
--
ALTER TABLE `samochod`
  MODIFY `samochod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT dla tabeli `udostepnienie`
--
ALTER TABLE `udostepnienie`
  MODIFY `udostepnienie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT dla tabeli `wypozyczenie`
--
ALTER TABLE `wypozyczenie`
  MODIFY `wypozyczenie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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

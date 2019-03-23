# PZ_2019_Lab3_Gr5

# Wypożyczalnia samochodów

# Spis treści:
1. [O naszej aplikacji](#o-naszej-aplikacji)
2. [Diagramy](#diagramy)
     - [Przypadków użycia](#--przypadków-użycia)
     - [Aktywności](#--aktywności)
     - [Sekwencji](#--sekwencji)
     - [Klas](#--klas)
3. [Funkcjonalności naszej aplikacji](#funkcjonalności-naszej-aplikacji)
4. [Zakresy uprawnień](#zakresy-uprawnień)
     - [Administrator](#administrator)
     - [Pracownik](#pracownik)
     - [Klient](#klient)
5. [Baza danych](#baza-danych)
6. [Narzędzia i technologie](#narzędzia-i-technologie)
7. [Twórcy](#twórcy)
8. [Licencja](#licencja)
9. [Widoki](#wyglad)

## O naszej aplikacji:
   
  Aplikacja umożliwia użytkownikom wypożyczenie wybranego samochodu
  dostępnego z naszej floty lub wypożyczenie samochodu od innych użytkowników aplikacji.
  Klient ma możliwość udostępnienia swojego własnego samochodu do wypożyczenia w celach zarobkowych.

## Diagramy:

####   - Przypadków użycia:
   ![diagram_przypadkow_uzycia](https://user-images.githubusercontent.com/47949957/53828833-05126980-3f7f-11e9-96ee-613342b55891.png)
   
####   - Aktywności:
   
   ![diagram_aktywnosci](https://user-images.githubusercontent.com/47949957/53783939-e32fcd00-3f13-11e9-93de-1c82f2b6e33a.jpg)
   
####   - Sekwencji:
   ![diagram_sekwencji](https://user-images.githubusercontent.com/26200573/54179388-f228f900-4498-11e9-8e34-e7d3578c448b.PNG)

   
####   - Klas:
   ![klas](https://user-images.githubusercontent.com/47949957/53831151-65f07080-3f84-11e9-9575-400f4a0aa04f.png)   


## Funkcjonalności naszej aplikacji:
  - wynajem pojazdu,
  - rezerwacja pojazdu,
  - udostępnienie pojazdu,
  - wgląd w historię swoich wypożyczeń samochodu,
  - wgląd w historię swoich udostępnień samochodu,
  - zarządzanie pojazdami,
  - zarządzanie pracownikami,
  - zarządzanie klientami,
  
  
  
  ## Zakresy uprawnień:

#### Administrator:
  1. Chce mieć możliwość do zalogowania się do aplikacji
  2. Chce mieć możliwość do zarządzania pracownikami oraz klientami
  3. Chce mieć możliwość do przenoszenia pojazdów między wypożyczalniami

#### Pracownik:
  1. Chce mieć możliwość do zalogowania się do aplikacji
  2. Chce mieć możliwość dodawania i usuwania pojazdów z listy dostępnych w swojej wypożyczalni
  3. Chce mieć możliwość do zarządzania bazą użytkowników, dodawania ich, usuwania i edycji
  4. Chce mieć możliwość do prowadzenia własnych wypożyczeń oraz możliwość udostępniania samochodu
  5. Chce mieć możliwość podglądu swoich udostępnionych samochodów
  6. Chce mieć wgląd do historii udostępnionych samochodów
  7. Chce mieć wgląd do historii wypożyczonych samochodów
  8. Chce móc zarządzać wypożyczeniami

#### Klient:
  1. Chce mieć możliwość rejestracji oraz logowania
  2. Chce mieć możliwość do udostępnienia własnego pojazdu do wypożyczenia
  3. Chce mieć możliwość podglądu oraz ewentualnego zakończenia udostępniania samochodu
  4. Chce mieć możliwość wyboru pojazdu do wypożyczenia oraz wyboru terminu wypożyczenia: “od kiedy”, “do kiedy”



## Baza danych:
Nasza baza danych będzie zawierać następujące informacje:
   - Spis:
     - klientów,
     - pracowników,
     - administratorów,
     - pojazdów,
     - placówek(wypożyczalni),
   - Informacje o wypożyczeniach

## Narzędzia i technologie:
   - JavaFX 
   - MySQL  
   - Jira
   - IntelliJ
   - GitHub


## Twórcy:
   - Tomasz Chudzik
   - Filip Konior
   - Łukasz Kowalski
   - Patryk Krawiec
   - Adrian Czupich
   
   
## Widoki:
#### Okno startowe:
    ![okno startowe startowe](https://user-images.githubusercontent.com/47949957/54594492-12286180-4a31-11e9-8603-9c5865f75956.png)

#### Okno administratora:
    ![okno_administratora](https://user-images.githubusercontent.com/37296747/54594556-3126f380-4a31-11e9-9194-25bcd0929fe6.PNG)
     
## Licencja:
   MIT License szczegóły w pliku [LICENSE](LICENSE)



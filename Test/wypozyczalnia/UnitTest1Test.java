package wypozyczalnia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest1Test {

    @Test
    public void test(){ //Pierwszy przykładowy test jednostkowy, który sprawdza metodę addNumber w klasie UnitTest1
        UnitTest1 test = new UnitTest1();
        int result = test.addNumber(5, 2); //zmiennym a, b przypisujemy wartości kolejno 5, 2
        assertEquals(7, result); //sprawdzamy czy metoda zwróci 7 (jeżeli tak = test poprawny)
    }

    @Test
    public void testString(){ //Drugi przykładowy test jednostkowy, który sprawdza metodę addString w klasie UnitTest1
        UnitTest1 test2 = new UnitTest1();
        String result2 = test2.addString("Programowanie", "Zespołowe");
        assertEquals("PrgZesp", result2); //Test będzie niepoprawny, metoda zwróci stringa "ProgramowanieZespołowe",a zassertowany, spodziewany string to "PrgZesp"
    }
}
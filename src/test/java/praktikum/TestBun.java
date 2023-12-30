package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBun {

    @Test
    public void runTestGetName(){
        Bun bun = new Bun("Слойка", 75);
        assertEquals ("Неверное определение имени!", "Слойка", bun.getName());

    }

    @Test
    public void runTestGetPrice(){
        Bun bun = new Bun("Слойка", 75);
        assertEquals ("Неверное определение цены!", 75, bun.getPrice(), 0);

    }

}

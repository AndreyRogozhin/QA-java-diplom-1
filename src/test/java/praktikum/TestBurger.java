package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBurger {




    @Test
    public void runTestSetBun(){

        Bun bun = new Bun("Слойка", 75);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals ("Неверное определение объекта!",burger.bun, bun);

    }



}

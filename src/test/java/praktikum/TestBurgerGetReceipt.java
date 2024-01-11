package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class TestBurgerGetReceipt {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    @Before
    //public void setUp() {        MockitoAnnotations.openMocks(this);    }

//    @Test
    public void runTestBurgerGetReceipt() {

     //   Burger burger = new Burger();

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

    }
}

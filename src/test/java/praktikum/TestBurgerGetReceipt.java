package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGetReceipt {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void runTestBurgerGetReceipt() {

        Burger burger = new Burger();
        String bunMockName = "Бутерброд";
        IngredientType ingMockType = IngredientType.SAUCE;
        String ingMockName = "dinosaur";
        float burgerMockPrice = 500;
        String expectedReceipt =
                "(==== Бутерброд ====)\r\n" +
                        "= sauce dinosaur =\r\n" +
                        "(==== Бутерброд ====)\r\n" +
                        "\r\n" +
                        "Price: 500,000000\r\n";

        burger.setBuns(bun);
        burger.addIngredient(ingredient);


        Mockito.when(bun.getName()).thenReturn(bunMockName);
        Mockito.when(ingredient.getType()).thenReturn(ingMockType);
        Mockito.when(ingredient.getName()).thenReturn(ingMockName);
        Mockito.when(burger.getPrice()).thenReturn(burgerMockPrice);
        String actualreceipt = burger.getReceipt();
        assertEquals("Неправильно составлен рецепт!", expectedReceipt, actualreceipt);


    }
}

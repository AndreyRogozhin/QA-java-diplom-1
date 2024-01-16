package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBurgerGetPrice {

    @Parameterized.Parameter
    public float bunPrice;
    @Parameterized.Parameter(1)
    public float[] ingPrices;
    @Parameterized.Parameter(2)
    public float expectedPrice;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Burger burger = new Burger();

    @Parameterized.Parameters(name = "При стоимости булочки {0} и стоимости ингредиентов  стоимость всего бургера должна быть {2}")
    public static Object[][] data() {
        float[] array1 = {15, 15};
        float[] array2 = {3};
        float[] array3 = {};
        return new Object[][]{
                {50, array1, 130},
                {2, array2, 7},
                {2, array3, 4},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void runTestBurgerGetPrice() throws Exception {

        burger = new Burger();
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        for (float ingPrice : ingPrices) {
            Mockito.when(ingredient.getPrice()).thenReturn(ingPrice);
            burger.addIngredient(ingredient);
        }

        float mockResultPrice = burger.getPrice();

        assertEquals("Неправильно рассчитана стоимость!", expectedPrice, mockResultPrice, 0);
    }


}

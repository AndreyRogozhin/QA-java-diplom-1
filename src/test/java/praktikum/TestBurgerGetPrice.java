package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
//@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGetPrice{

    @Mock
    Bun bun;

    @Mock
    Burger burger  = new Burger();;

//    @Mock
//    private Ingredient ingredient;

    @Parameterized.Parameter
    public float bunPrice;
    @Parameterized.Parameter(1)
    public float[] ingPrices;
    @Parameterized.Parameter(2)
    public float expectedPrice;


    @Parameterized.Parameters(name = "При стоимости булочки {0} и стоимости ингредиентов  стоимость всего бургера должна быть {2}")
    public static Object[][] data() {
        float[] array1  = {1,15};
        float[] array2 = {3};
        return new Object[][] {
                { 50, array1, 115 },
                { 2, array2, 7 }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void runTestBurgerGetPrice()  throws Exception{
  //      burger = new Burger();
        bun = new Bun("Test Bun",bunPrice);


    //    Mockito.when(bun.getPrice()).thenReturn( 1000f);
        Mockito.doReturn( bunPrice).when(burger.bun).getPrice();
        float price = burger.bun.getPrice() * 2;

        for (float ingPrice : ingPrices) {
            Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test name", ingPrice);
            Mockito.when(ingredient.getPrice()).thenReturn(ingPrice);
            price += ingredient.getPrice();
        }


        assertEquals("Неправильно рассчитана стоимость!", expectedPrice, price);
    }



}

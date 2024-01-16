package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBurgerIngredients {

    Burger burger;

    @Before
    public void init() {
    }

    @Test
    public void runTestBurgerAddIngredient() throws Exception {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        assertEquals("Неверно записан объект!", ingredient, burger.ingredients.get(0));

    }


    @Test
    public void runTestBurgerRemoveIngredient() throws Exception {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.ingredients.add(ingredient);

        burger.removeIngredient(0);
        assertEquals("Неверно удален объект!", 0, burger.ingredients.size());
    }


    @Test
    public void runTestBurgerMoveIngredient() throws Exception {
        Burger burger = new Burger();
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);

        burger.moveIngredient(0, 1);

        assertEquals("Неверно перемещён объект!", ingredient0, burger.ingredients.get(1));


    }


}

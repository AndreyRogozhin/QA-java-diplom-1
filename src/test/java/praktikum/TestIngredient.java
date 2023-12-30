package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredient {

    @Test
    public void runTestGetName(){
    Ingredient ingredient = new   Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    assertEquals ("Неверное определение имени!", "hot sauce", ingredient.getName());
    }

    @Test
    public void runTestGetPrice(){
        Ingredient ingredient = new   Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals ("Неверное определение цены!", 100, ingredient.getPrice(), 0);

    }

    @Test
    public void runTestGetType(){
        Ingredient ingredient = new   Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals ("Неверное определение типа!", IngredientType.SAUCE, ingredient.getType());

    }



}

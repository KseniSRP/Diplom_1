import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun blackBun; // Мок булочки

    @Mock
    Ingredient hotSauce; // Мок горячего соуса

    @Mock
    Ingredient cutlet; // Мок котлеты

    private Burger burger;

    @Before
    public void setUp() {
        // Инициализация тестового окружения
        burger = new Burger();
        burger.setBuns(blackBun);
        // Настройка поведения моков
        when(blackBun.getName()).thenReturn("black bun");
        when(blackBun.getPrice()).thenReturn(100f);
        when(hotSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(hotSauce.getName()).thenReturn("hot sauce");
        when(hotSauce.getPrice()).thenReturn(100f);
        when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        when(cutlet.getName()).thenReturn("cutlet");
        when(cutlet.getPrice()).thenReturn(100f);
    }

    // Тест на расчет цены бургера
    @Test
    public void testBurgerPriceCalculation() {
        // Дополнительная настройка моков для этого теста
        when(blackBun.getPrice()).thenReturn(50f);
        when(hotSauce.getPrice()).thenReturn(10f);
        when(cutlet.getPrice()).thenReturn(20f);

        // Повторная инициализация объекта Burger для теста
        Burger burger = new Burger();
        burger.setBuns(blackBun);
        burger.addIngredient(hotSauce);
        burger.addIngredient(cutlet);

        // Проверка расчета цены бургера
        assertEquals("Расчет цены бургера сделан неверно", 130f, burger.getPrice(), 0.01);
    }

    // Тест на изменение размера списка ингредиентов при добавлении нового ингредиента
    @Test
    public void testAddIngredientIncreasesSize() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(hotSauce);
        assertEquals("Размер списка ингредиентов должен увеличиться после добавления ингредиента", initialSize + 1, burger.ingredients.size());
    }

    // Тест на уменьшение размера списка ингредиентов при удалении ингредиента
    @Test
    public void testRemoveIngredientDecreasesSize() {
        burger.addIngredient(cutlet);
        int initialSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("Размер списка ингредиентов должен уменьшиться после удаления ингредиента", initialSize - 1, burger.ingredients.size());
    }

    // Тест на изменение позиции ингредиента в списке
    @Test
    public void testMoveIngredientChangesPosition() {
        burger.addIngredient(hotSauce);
        burger.addIngredient(cutlet);
        Ingredient firstIngredient = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        assertNotEquals("Ингредиент должен был быть перемещен на новую позицию", firstIngredient, burger.ingredients.get(0));
    }


    @Test // добавлена проверка на полное соответсвие чека
    public void testReceiptGeneration() {
        // Добавление ингредиентов для теста генерации чека
        burger.addIngredient(hotSauce);
        burger.addIngredient(cutlet);

        // Генерация фактического чека
        String actualReceipt = burger.getReceipt();

        // Формирование ожидаемого текста чека
        String expectedReceipt = "(==== black bun ====)\n"
                + "= sauce hot sauce =\n"
                + "= filling cutlet =\n"
                + "(==== black bun ====)\n"
                +"\n"
                + "Price: 400.000000"
                +"\n";

        // Проверка соответствия фактического чека ожидаемому
        assertEquals("Чек должен полностью соответствовать ожидаемому содержанию", expectedReceipt, actualReceipt);
    }

}

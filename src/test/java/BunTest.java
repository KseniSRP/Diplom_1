import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testBunNameAndPrice() {
        // Создаю объект Bun с названием "black bun" и ценой 100
        Bun blackBun = new Bun("black bun", 100);

        // Проверяю, что название и цена соответствует созданному
        assertEquals("Название булочки должно быть 'black bun'", "black bun", blackBun.getName());
        assertEquals("Цена булочки должна быть 100", 100, blackBun.getPrice(),  0.01);

        // Создаю объект Bun с названием "white bun" и ценой 200
        Bun whiteBun = new Bun("white bun", 200);

        // Проверяю, что название и цена соответствует созданному
        assertEquals("Название булочки должно быть 'white bun'", "white bun", whiteBun.getName());
        assertEquals("Цена булочки должна быть 200", 200, whiteBun.getPrice(),0.01);


    }
}
package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final boolean expectedResult;

    public LionParametrizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Гендер. Тестовые данные: {0}")
    public static Object[][] createParametrsOfLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Львенок", false}
        };
    }
    @Mock
    Feline feline;

    @Test
    public void testCreateLion() throws Exception{
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(expectedResult, lion.doesHaveMane());
        } catch (Exception exception) {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
}
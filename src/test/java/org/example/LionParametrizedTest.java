package org.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

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
                {"Собака", true},
                {"null", false},
                {"Львенок", false},
        };
    }

    @Mock
    Feline feline;

    @Test
    public void testCreateFailLion(){
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(expectedResult, lion.doesHaveMane());
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
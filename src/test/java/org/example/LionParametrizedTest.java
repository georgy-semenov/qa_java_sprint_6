package org.example;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;


    public LionParametrizedTest(String sex) {
        this.sex = sex;

    }

    @Parameterized.Parameters(name = "Гендер. Тестовые данные: {0}")
    public static Object[][] createParametrsOfLion() {
        return new Object[][]{
                {"Собака"},
                {"null"},
                {"Львенок"},
        };
    }

    @Mock
    Feline feline;

    @Test
    public void testCreateFailLion(){
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Test
    public void testGetSound(){
        cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Мяу", actual);
    }

    @Test
    public void testGetFood() throws Exception{
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
}

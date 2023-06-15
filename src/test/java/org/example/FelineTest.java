package org.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;


public class FelineTest {

    @Test
    public void getFamilyShouldReturnCatFamily(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }
    @Test
    public void getKittensShouldReturnOneKitten(){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getKittensWithKittensCountShouldReturnKittensCount(){
        Feline feline = new Feline();
        int actual = feline.getKittens(3);
        assertEquals(3, actual);
    }


    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expected = feline.eatMeat();
        assertEquals(expected, List.of("Животные", "Птицы", "Рыба"));

    }

}
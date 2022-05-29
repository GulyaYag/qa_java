package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;

    private final int expectedKittens;


    public FelineTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;

    }

    @Parameterized.Parameters
    public static Object[][] getKittensNumbers() {
        return new Object[][] {
                { 1, 1},
                { 0, 0},
        };
    }

    @Test
    public void getKittensReturnKittensCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(expectedKittens);
        Assert.assertEquals(kittensCount, actual);

    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        Assert.assertEquals("Кошачьи", actual);
    }

    @Test
    public void getKittensNumber() {
        Feline feline = new Feline();
        int actual = feline.getKittens(1);
        Assert.assertEquals(1, actual );
    }

    @Test
    public void eatMeatListOfFeed() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
}

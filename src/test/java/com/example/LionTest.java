package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)

 public class LionTest {

     @Mock
    Feline feline;

    @Test
    public void getKittensNumber() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }

    @Test
    public void doesHaveManeMaleLionTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(true, actual);
    }

    @Test
    public void doesHaveManeFemaleLionFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(false, actual);
    }

    @Test
    public void getFoodListOfFeedSex() throws Exception {
    Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());

    }

    @Test
    public void lionErrorSexException() {
        Exception e = assertThrows (Exception.class, () -> new Lion ("Что-то среднее", feline));
            Assert.assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самей или самка");
        }
    }




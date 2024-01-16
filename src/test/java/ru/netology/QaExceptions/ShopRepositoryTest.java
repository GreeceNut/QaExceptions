
package ru.netology.QaExceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();
    Product product1 = new Product (1, "Шоколад", 100 );
    Product product2 = new Product (2, "Мармелад", 300 );
    Product product3 = new Product (3, "Сок", 250 );
   @BeforeEach

public void setup(){
    repository.add(product1);
    repository.add(product2);
    repository.add(product3);
   }
    @Test
public void removingIdTest() {
       repository.remove(2);
       Product[] actual = repository.findAll();
       Product [] expected = {product1, product3};

       Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void removingNoExistIdTest() {
        Assertions.assertThrows(NotFoundException.class, () -> {repository.remove(10);
        });

    }

    @Test
    public void addIdTest(){
       repository.add(new Product(4, "Йогурт", 25));
       Product [] actual = repository.findAll();
       Product [] expected = {product1, product2, product3, new Product(4, "Йогурт", 25)};

       Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void alreadyExistsException (){
        Assertions.assertThrows(AlreadyExistsException.class, () ->
                repository.add(new Product(3, "Йогурт", 25)));
   }

}

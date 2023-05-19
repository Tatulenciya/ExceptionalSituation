package ru.netology;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ShopRepositoryTest {

    @Test
    public void removeExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "мороженное", 59);
        Product product2 = new Product(21, "зефир", 135);
        Product product3 = new Product(321, "молоко", 65);
        Product product4 = new Product(4321, "хлеб",50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(321);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeUnExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "мороженное", 59);
        Product product2 = new Product(21, "зефир", 135);
        Product product3 = new Product(321, "молоко", 65);
        Product product4 = new Product(4321, "хлеб",50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(123)
                );
    }


    @Test
    public void addUnExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "мороженное", 59);
        Product product2 = new Product(21, "зефир", 135);
        Product product3 = new Product(321, "молоко", 65);
        Product product4 = new Product(4321, "хлеб",50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSameIdProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "мороженное", 59);
        Product product2 = new Product(21, "зефир", 135);
        Product product3 = new Product(321, "молоко", 65);
        Product product4 = new Product(321, "хлеб", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product4)
        );
    }

    @Test
    public void addExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "мороженное", 59);
        Product product2 = new Product(21, "зефир", 135);
        Product product3 = new Product(321, "молоко", 65);
        Product product4 = new Product(4321, "хлеб", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);


        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product4)
        );
    }

}
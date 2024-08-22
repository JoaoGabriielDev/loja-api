package br.com.store.Config;

import br.com.store.models.*;
import br.com.store.models.enums.OrderStatus;
import br.com.store.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Alimentos");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        Produto p1 = new Produto(null, "MacBook", "1TB - Tela de 16,2 polegadas.", 9000.00);
        Produto p2 = new Produto(null, "Iphone16", "128GB - Tela de 6,07 polegadas.", 3000.00);
        Produto p3 = new Produto(null, "SmartWatch", "é um relógio digital que apresenta diversas outras funcionalidades", 1200.00);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
        p3.getCategories().add(c1);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        User u1 = new User(null, "Tommy", "tommy@gmail.com", "83977778888", "12345678");
        User u2 = new User(null, "Joao", "joao@gmail.com", "83988887777", "12345678");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2014-03-10T08:30:00Z"), OrderStatus.WAITING_PAYMENT , u2);
        Order o3 = new Order(null, Instant.parse("2020-10-05T15:40:10Z"), OrderStatus.WAITING_PAYMENT , u1);

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o3, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o2, p3, 3, p3.getPrice());
        OrderItem oi3 = new OrderItem(o1, p2, 1, p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));


    }
}

package br.com.store.Config;

import br.com.store.models.Category;
import br.com.store.models.Order;
import br.com.store.models.Produto;
import br.com.store.models.User;
import br.com.store.respositories.CategoryRepository;
import br.com.store.respositories.OrderRepository;
import br.com.store.respositories.ProdutoRepository;
import br.com.store.respositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Tommy", "tommy@gmail.com", "83977778888", "12345678");
        User u2 = new User(null, "Joao", "joao@gmail.com", "83988887777", "12345678");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2014-03-10T08:30:00Z"), u2);
        Order o3 = new Order(null, Instant.parse("2020-10-05T15:40:10Z"), u1);

        Category c1 = new Category(null, "Notebooks");
        Category c2 = new Category(null, "Celulares");

        Produto p1 = new Produto(null, "Iphone16", "128GB - Tela de 6,07 polegadas.", 3000.00);
        Produto p2 = new Produto(null, "MacBook", "1TB - Tela de 16,2 polegadas.", 9000.00);

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(c1, c2));

        produtoRepository.saveAll(Arrays.asList(p1, p2));

        produtoRepository.saveAll(Arrays.asList(p1, p2));

    }
}

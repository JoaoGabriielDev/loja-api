package br.com.store.Config;

import br.com.store.models.Produto;
import br.com.store.models.User;
import br.com.store.respositories.ProdutoRepository;
import br.com.store.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Tommy", "tommy@gmail.com", "83977778888", "12345678");
        User u2 = new User(null, "Joao", "joao@gmail.com", "83988887777", "12345678");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Produto p1 = new Produto(null, "Celular", "Iphone 16 - 128GB - Tela de 6,06 polegadas.", 3000.00);
        Produto p2 = new Produto(null, "Notebook", "MacBook - 1TB - Tela de 16,2 polegadas.", 9000.00);

        produtoRepository.saveAll(Arrays.asList(p1, p2));

    }
}

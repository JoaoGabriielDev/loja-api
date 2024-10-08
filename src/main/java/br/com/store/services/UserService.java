package br.com.store.services;

import br.com.store.exceptions.UserNotFoundException;
import br.com.store.models.User;
import br.com.store.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        User obj = repository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User update(Long id, User obj){
        User entity = repository.findById(id).orElseThrow(UserNotFoundException::new);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}

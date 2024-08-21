package br.com.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Data
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Getter
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Produto> produtos = new HashSet<>();

    public Category(){

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}

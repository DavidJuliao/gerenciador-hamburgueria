package com.example.hamburgueria.gerenciadorhamburgueria.model.repository;

import com.example.hamburgueria.gerenciadorhamburgueria.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Long> {
}

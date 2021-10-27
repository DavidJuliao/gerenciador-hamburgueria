package com.example.hamburgueria.gerenciadorhamburgueria.controller;

import com.example.hamburgueria.gerenciadorhamburgueria.exceptions.ProdutoNaoEncontradoException;
import com.example.hamburgueria.gerenciadorhamburgueria.model.domain.Produto;
import com.example.hamburgueria.gerenciadorhamburgueria.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping
    public ResponseEntity salvar(Produto produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    public  ResponseEntity buscarPorId(Long id) throws ProdutoNaoEncontradoException {
        Produto produto = produtoService.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto):ResponseEntity.notFound().build();
    }
}

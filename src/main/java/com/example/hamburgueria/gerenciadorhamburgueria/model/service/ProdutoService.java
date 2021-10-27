package com.example.hamburgueria.gerenciadorhamburgueria.model.service;

import com.example.hamburgueria.gerenciadorhamburgueria.exceptions.ProdutoNaoEncontradoException;
import com.example.hamburgueria.gerenciadorhamburgueria.model.domain.Produto;
import com.example.hamburgueria.gerenciadorhamburgueria.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transient
    public void salvarProduto(Produto produto){

        produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) throws ProdutoNaoEncontradoException {
        return produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }

    @Transient
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    @Transient
    public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
        Produto produtoSalvo = produtoRepository.findById(produto.getId()).orElseThrow(ProdutoNaoEncontradoException::new);
        produtoSalvo.atualizar(produto);
        produtoRepository.save(produtoSalvo);

    }
}

package com.SpringBasic.controller;

import com.SpringBasic.model.Produto;
import com.SpringBasic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Salvo: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        repository.save(produto);
        return produto;
    }
}

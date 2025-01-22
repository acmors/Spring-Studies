package com.SpringBasic.controller;

import com.SpringBasic.model.Produto;
import com.SpringBasic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        Optional<Produto> produto = repository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        repository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return repository.findByNome(nome);
    }

}

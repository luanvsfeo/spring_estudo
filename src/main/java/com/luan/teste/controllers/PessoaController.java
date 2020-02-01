/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luan.teste.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luan.teste.models.Pessoa;
import com.luan.teste.repository.PessoaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Luan
 */
@Controller
@RequestMapping("/people")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        model.addAttribute("texto", "a lista deve estar ai ");
        return "welcome";
    }

    @PostMapping(path = "/", consumes = "application/json")
    public String createNew(@Valid @RequestBody Pessoa pessoa, Model model) {
        pessoaRepository.save(pessoa);
        model.addAttribute("pessoas", pessoaRepository.findAll());
        model.addAttribute("texto", "criou um novo ");
        return "welcome";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pessoas", pessoaRepository.findById(id));
        model.addAttribute("texto", "procurou pelo id: " + id);
        return "welcome";
    }

    @DeleteMapping("/{id}")
    public String deleteOne(@PathVariable("id") Long id, Model model) {
        pessoaRepository.deleteById(id);
        model.addAttribute("pessoas", pessoaRepository.findAll());
        model.addAttribute("texto", "deletou o id: " + id);
        return "welcome";
    }
    
    
    
    
    
    @PutMapping("/")
    public String updateOne(){
        return "welcome";
    }

}

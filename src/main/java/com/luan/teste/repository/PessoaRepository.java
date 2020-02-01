/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luan.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luan.teste.models.Pessoa;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Luan
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
    

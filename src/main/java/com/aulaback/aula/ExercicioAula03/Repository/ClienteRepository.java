package com.aulaback.aula.ExercicioAula03.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aulaback.aula.ExercicioAula03.Model.Cliente;


@RestController
@RequestMapping("/clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //
    public List<Cliente> findByNome (String nome);
    public List<Cliente> findByEmail (String email);
    public List<Cliente> findByTelefone (String telefone);
    public List<Cliente> findByCpf (String cpf);
    public List<Cliente> findByNomeStartingWith(String nome);

}


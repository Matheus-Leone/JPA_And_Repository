package com.aulaback.aula.ExercicioAula03.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.aulaback.aula.ExercicioAula03.Model.Cliente;
import com.aulaback.aula.ExercicioAula03.Repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteRepository clienteRepository;


    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    // CREATE
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){

    if(cliente.getNome() == null || cliente.getNome().isEmpty()){
        throw new RuntimeException("Nome é obrigatório");
    }

    if(cliente.getEmail() == null || cliente.getEmail().isEmpty()){
        throw new RuntimeException("Email é obrigatório");
    }

    if(cliente.getCpf() == null || cliente.getCpf().isEmpty()){
        throw new RuntimeException("CPF é obrigatório");
    }

    return clienteRepository.save(cliente);
}




    // READ (todos)
    @GetMapping
    public List<Cliente> todos(){
        return clienteRepository.findAll();
    }

    // READ (por id)
    @GetMapping("/{id}")
    public Cliente porId(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return "Excluído com sucesso.";
    }

    // UPDATE
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteAtualizar = clienteRepository.findById(id).orElse(null);

        if(clienteAtualizar == null){
            return null;
        }

        clienteAtualizar.setNome(cliente.getNome());
        clienteAtualizar.setEmail(cliente.getEmail());
        clienteAtualizar.setTelefone(cliente.getTelefone());

        return clienteRepository.save(clienteAtualizar);
    }

    // BUSCA POR NOME
    @GetMapping("/buscarporNome")
    public List<Cliente> porNome(@RequestParam String nome){
        return clienteRepository.findByNome(nome);
    }

    // BUSCA POR EMAIL
    @GetMapping("/buscarporEmail")
    public List<Cliente> porEmail(@RequestParam String email){
        return clienteRepository.findByEmail(email);
    }

    // BUSCA POR TELEFONE
    @GetMapping("/buscarporTelefone")
    public List<Cliente> porTelefone(@RequestParam String telefone){
        return clienteRepository.findByTelefone(telefone);
    }

    // BUSCA POR CPF
    @GetMapping("/buscarporCpf")
    public List<Cliente> porCpf(@RequestParam String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    // BUSCA POR NOME INICIO
    @GetMapping("/buscarPorNomeInicio")
    public List<Cliente> buscarPorNomeInicio(@RequestParam String nome){
        return clienteRepository.findByNomeStartingWith(nome);
}
}
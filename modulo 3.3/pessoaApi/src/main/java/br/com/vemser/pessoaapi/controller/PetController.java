package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.dto.PetGetDTO;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<PetGetDTO> getAll() {
        return petService.list();
    }

    @PostMapping
    public PetDTO post(PetCreateDTO pet) throws RegraDeNegocioException {
        return petService.create(pet);
    }

    @PutMapping("/{idPet}")
    public PetDTO put(@PathVariable("idPet") Integer id,
                      @RequestBody PetCreateDTO pet) throws RegraDeNegocioException {
        return petService.update(id, pet);
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
    }
}

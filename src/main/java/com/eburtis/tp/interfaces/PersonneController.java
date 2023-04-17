package com.eburtis.tp.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eburtis.tp.application.personne.PersonneService;
import com.eburtis.tp.application.personne.PersonneVO;

@RestController
@RequestMapping("api/v1/personne")
public class PersonneController {
    
    @Autowired
    private PersonneService personneService;

    @PostMapping
    public String savePersonne(@RequestBody PersonneVO pVo) {
        return personneService.savePersonne(pVo);
    }

    @PutMapping("/{id}")
    public String updatePersonne(@PathVariable("id") Long pVoId, PersonneVO pVo) {
        return personneService.updatePersonne(pVoId, pVo);
    }

    @GetMapping()
    public String fetchAllPersonne() {
        return personneService.fetchAllPersonne();
    }

    @GetMapping("/{id}")
    public String fetchPersonne(@PathVariable("id") Long pVoId) {
        return personneService.fetchPersonne(pVoId);
    }
}

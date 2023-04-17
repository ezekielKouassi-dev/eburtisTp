package com.eburtis.tp.infrastructure;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eburtis.tp.application.personne.PersonneService;
import com.eburtis.tp.application.personne.PersonneVO;
import com.eburtis.tp.domains.personne.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public String savePersonne(PersonneVO personneVo) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toString();

    }

    @Override
    public String updatePersonne(Long id, PersonneVO personneVo) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonne'");
    }

    @Override
    public String fetchAllPersonne() {
        
        throw new UnsupportedOperationException("Unimplemented method 'fetchAllPersonne'");
    }

    @Override
    public String fetchPersonne(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'fetchPersonne'");
    }

    @Override
    public String deletePersonne(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletePersonne'");
    }
    
}

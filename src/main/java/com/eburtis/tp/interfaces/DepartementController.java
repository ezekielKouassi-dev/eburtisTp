package com.eburtis.tp.interfaces;

import com.eburtis.tp.application.departement.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departement")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public String fetchAllDepartement() {
        return departementService.fetchAllDepartement();
    }
}

package com.logistica.integracoes.domain.turno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "turno")
public class TurnoController {

    @Autowired
    private TurnoRepository repository;

    @GetMapping
    public List<Turno> getAll() {
        return repository.findAll();
    }
}

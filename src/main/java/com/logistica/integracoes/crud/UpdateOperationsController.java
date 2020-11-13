package com.logistica.integracoes.crud;

import com.logistica.integracoes.crud.dto.UpdateOperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "update")
public class UpdateOperationsController {

    @Autowired
    private CrudOperationsService service;

    @PostMapping
    public ResponseEntity update(@RequestBody UpdateOperationDTO updateOperationDTO) {
        return ResponseEntity.ok(service.performTransacationOperation(updateOperationDTO.getRawQuery()));
    }
}

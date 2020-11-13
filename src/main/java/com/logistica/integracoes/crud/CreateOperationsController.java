package com.logistica.integracoes.crud;

import com.logistica.integracoes.crud.dto.CreateOperationDTO;
import com.logistica.integracoes.exceptions.DetailErrorException;
import com.logistica.integracoes.sql.dialect.ProgressSQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping(path = "create")
@ControllerAdvice
public class CreateOperationsController extends ResponseEntityExceptionHandler {

    @Autowired
    private CrudOperationsService service;

    @PostMapping
    @ExceptionHandler(DetailErrorException.class)
    public ResponseEntity create(@RequestBody CreateOperationDTO createOperationDTO) {
        String rawQuery = ProgressSQLInsert.create()
                .addTable(createOperationDTO.getTabela())
                .addCampos(createOperationDTO.getCampos())
                .addValues(createOperationDTO.getValores())
                .build();

        return ResponseEntity.ok(service.performTransacationOperation(rawQuery));
    }

    @PostMapping(path = "raw")
    public ResponseEntity createByRawQuery(@RequestBody CreateOperationDTO createOperationDTO) {
        return ResponseEntity.ok(service.performTransacationOperation(createOperationDTO.getRawQuery()));
    }
}

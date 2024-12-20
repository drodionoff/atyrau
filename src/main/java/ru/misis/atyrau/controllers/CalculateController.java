package ru.misis.atyrau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.misis.atyrau.models.CalculateRequest;
import ru.misis.atyrau.models.CalculateResponse;
import ru.misis.atyrau.models.ErrorResponse;
import ru.misis.atyrau.service.Calculable;
import ru.misis.atyrau.service.CalculatorFactory;
import ru.misis.atyrau.service.TextCalculator;

@RestController
@RequestMapping("/api/v1")
public class CalculateController {

    @Autowired
    CalculatorFactory calculatorFactory;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestBody CalculateRequest request
            ) {
        Calculable calc = calculatorFactory.createCalculator(request);

        if(request.getText() != null && !request.getText().trim().isEmpty()) {
            CalculateResponse response = (CalculateResponse) calc.calculate();

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()), HttpStatus.BAD_REQUEST);
        }
    }

}
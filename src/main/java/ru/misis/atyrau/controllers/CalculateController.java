package ru.misis.atyrau.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.misis.atyrau.models.CalculateRequest;
import ru.misis.atyrau.models.CalculateResponse;
import ru.misis.atyrau.models.ErrorResponse;

@RestController
@RequestMapping("/api/v1")
public class CalculateController {
    @GetMapping("/hi")
    public String hi() {
        return "Hiii";
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestBody CalculateRequest request
            ) {

        System.out.println("in" + request.getText());
        if(request.getText() != null && !request.getText().trim().isEmpty()) {

            return new ResponseEntity<>(new CalculateResponse(120, 120*6, 1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()), HttpStatus.BAD_REQUEST);
        }

    }

}
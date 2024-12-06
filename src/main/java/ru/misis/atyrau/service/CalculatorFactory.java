package ru.misis.atyrau.service;

import org.springframework.stereotype.Service;
import ru.misis.atyrau.models.AbstractRequestModel;
import ru.misis.atyrau.models.CalculateRequest;

@Service
public class CalculatorFactory {
    public Calculable createCalculator(AbstractRequestModel request) {
        if (request instanceof CalculateRequest) {
            return new TextCalculator((CalculateRequest)request);
        } else {
            return new StubCalculator();
        }
    }
}

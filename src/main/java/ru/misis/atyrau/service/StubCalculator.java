package ru.misis.atyrau.service;

import ru.misis.atyrau.models.AbstractResponseModel;
import ru.misis.atyrau.models.CalculateResponse;
import ru.misis.atyrau.models.TechAudit;

public class StubCalculator implements Calculable{
    @Override
    public AbstractResponseModel calculate() {
        CalculateResponse response = new CalculateResponse();
        TechAudit techAudit = response.getTechAudit();
        techAudit.setCode(-10);
        techAudit.setMessage("Not Implemented");
        response.setTechAudit(techAudit);
        return  response;
    }
}

package ru.misis.atyrau.service;

import org.springframework.stereotype.Service;
import ru.misis.atyrau.models.AbstractResponseModel;
import ru.misis.atyrau.models.CalculateRequest;
import ru.misis.atyrau.models.CalculateResponse;

public class TextCalculator extends CalculateRequest implements Calculable {
    private static final int LOW = 80;
    private static final int MEDIUM = 100;
    private static final int FAST = 120;
    private final CalculateResponse response;


    public TextCalculator(CalculateRequest data) {
        this.isNeedSymbols = (data.getIsNeedSymbols() !=null && data.getIsNeedSymbols());
        this.isNeedWords = (data.getIsNeedWords() !=null && data.getIsNeedWords());
        this.isNeedReadingTime = (data.getIsNeedReadingTime() !=null && data.getIsNeedReadingTime());
        this.readingSpeed = data.getReadingSpeed();
        this.text = data.getText().trim();
        this.response = new CalculateResponse();
    }

    public void calculate(String text) {
        String[] wordsArray = text.split(" ");
        response.setSymbols(isNeedSymbols ? text.length() : 0);
        calculate(wordsArray);
    }

    public void calculate(String[] words) {
        int wordsCount = words.length;
        response.setWords(isNeedWords ? wordsCount: 0);
        if (isNeedReadingTime) {
            switch (this.readingSpeed) {
                case 1 -> response.setReadingTime(wordsCount * 60 / LOW);
                case 3 -> response.setReadingTime(wordsCount * 60 / FAST);
                default -> response.setReadingTime(wordsCount * 60 / MEDIUM);
            }
        } else {
            response.setReadingTime(0);
        }


    }

    @Override
    public AbstractResponseModel calculate() {
        System.out.println(readingSpeed);
        calculate(this.text);
        return response;
    }
}

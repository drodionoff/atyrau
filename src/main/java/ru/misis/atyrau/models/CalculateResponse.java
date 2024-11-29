package ru.misis.atyrau.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "words",
        "symbols",
        "reading_time",
        "security_audit",
        "tech_audit"
})
public class CalculateResponse extends AbstractResponseModel{

    @JsonProperty("words")
    private Integer words = 0;
    @JsonProperty("symbols")
    private Integer symbols = 0;
    @JsonProperty("reading_time")
    private Integer readingTime = 0;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("words")
    public Integer getWords() {
        return words;
    }

    @JsonProperty("words")
    public void setWords(Integer words) {
        this.words = words;
    }

    @JsonProperty("symbols")
    public Integer getSymbols() {
        return symbols;
    }

    @JsonProperty("symbols")
    public void setSymbols(Integer symbols) {
        this.symbols = symbols;
    }

    @JsonProperty("reading_time")
    public Integer getReadingTime() {
        return readingTime;
    }

    @JsonProperty("reading_time")
    public void setReadingTime(Integer readingTime) {
        this.readingTime = readingTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public TechAudit getTechAudit() {
        return new TechAudit();
    }

    public CalculateResponse() {

    }

    public CalculateResponse(int words, int symbols, int readingTime) {
        this.words = words;
        this.symbols = symbols;
        this.readingTime = readingTime;
    }
}

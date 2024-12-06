package ru.misis.atyrau.models;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_need_words",
        "is_need_symbols",
        "is_need_reading_time",
        "reading_speed",
        "text"
})

public class CalculateRequest extends AbstractRequestModel {

    @JsonProperty("is_need_words")
    protected Boolean isNeedWords;
    @JsonProperty("is_need_symbols")
    protected Boolean isNeedSymbols;
    @JsonProperty("is_need_reading_time")
    protected Boolean isNeedReadingTime;
    @JsonProperty("reading_speed")
    protected Integer readingSpeed;
    @JsonProperty("text")
    protected String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("is_need_words")
    public Boolean getIsNeedWords() {
        return isNeedWords;
    }

    @JsonProperty("is_need_words")
    public void setIsNeedWords(Boolean isNeedWords) {
        this.isNeedWords = isNeedWords;
    }

    @JsonProperty("is_need_symbols")
    public Boolean getIsNeedSymbols() {
        return isNeedSymbols;
    }

    @JsonProperty("is_need_symbols")
    public void setIsNeedSymbols(Boolean isNeedSymbols) {
        this.isNeedSymbols = isNeedSymbols;
    }

    @JsonProperty("is_need_reading_time")
    public Boolean getIsNeedReadingTime() {
        return isNeedReadingTime;
    }

    @JsonProperty("is_need_reading_time")
    public void setIsNeedReadingTime(Boolean isNeedReadingTime) {
        this.isNeedReadingTime = isNeedReadingTime;
    }

    @JsonProperty("reading_speed")
    public Integer getReadingSpeed() {
        return readingSpeed;
    }

    @JsonProperty("reading_speed")
    public void setReadingSpeed(Integer readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


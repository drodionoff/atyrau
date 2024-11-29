package ru.misis.atyrau.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public abstract class AbstractResponseModel {
    @JsonProperty("security_audit")
    private SecurityAudit securityAudit = new SecurityAudit();
    @JsonProperty("tech_audit")
    private TechAudit techAudit;
    @JsonProperty("security_audit")
    public SecurityAudit getSecurityAudit() {
        return securityAudit;
    }

    @JsonProperty("security_audit")
    public void setSecurityAudit(SecurityAudit securityAudit) {
        this.securityAudit = securityAudit;
    }

    @JsonProperty("tech_audit")
    public TechAudit getTechAudit() {
        return techAudit;
    }

    @JsonProperty("tech_audit")
    public void setTechAudit(TechAudit techAudit) {
        this.techAudit = techAudit;
    }
}

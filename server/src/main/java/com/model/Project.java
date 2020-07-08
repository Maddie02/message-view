package com.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "projects")
public class Project {
    @Id
    private ObjectId Id;
    private String consistentProjectID;
    private String consistentProductID;
    private String projectID;
    private String projectName;
    private List<String> locales;
    private String regexValidator;
    private String description;
    private String primaryLocale;
    private String version;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public Project(String consistentProjectID, String consistentProductID, String projectID, String projectName, List<String> locales, String regexValidator, String description, String primaryLocale, String version, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        this.consistentProjectID = consistentProjectID;
        this.consistentProductID = consistentProductID;
        this.projectID = projectID;
        this.projectName = projectName;
        this.locales = locales;
        this.regexValidator = regexValidator;
        this.description = description;
        this.primaryLocale = primaryLocale;
        this.version = version;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public ObjectId getId() {
        return Id;
    }

    public String getConsistentProjectID() {
        return consistentProjectID;
    }

    public String getConsistentProductID() {
        return consistentProductID;
    }

    public String getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<String> getLocales() {
        return locales;
    }

    public String getRegexValidator() {
        return regexValidator;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public String getVersion() {
        return version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
}

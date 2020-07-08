package com.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "components_ALF")
public class Component {
    @Id
    private ObjectId id;

    private String componentID;
    private String consistentComponentID;
    private String consistentProjectID;
    private String regexValidator;
    private String componentName;
    private String description;
    private List<String> messageTypes;
    private String version;
    private String primaryLocale;
    private boolean exportAbouts;
    private String path;
    private String fileName;
    private String fileType;
    private String encoding;
    private String templateID;
    private String resourcePath;
    private boolean forDocumentation;
    private boolean forTranslation;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public Component(ObjectId id, String componentID, String consistentComponentID, String consistentProjectID, String regexValidator, String componentName, String description, List<String> messageTypes, String version, String primaryLocale, boolean exportAbouts, String path, String fileName, String fileType, String encoding, String templateID, String resourcePath, boolean forDocumentation, boolean forTranslation, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.componentID = componentID;
        this.consistentComponentID = consistentComponentID;
        this.consistentProjectID = consistentProjectID;
        this.regexValidator = regexValidator;
        this.componentName = componentName;
        this.description = description;
        this.messageTypes = messageTypes;
        this.version = version;
        this.primaryLocale = primaryLocale;
        this.exportAbouts = exportAbouts;
        this.path = path;
        this.fileName = fileName;
        this.fileType = fileType;
        this.encoding = encoding;
        this.templateID = templateID;
        this.resourcePath = resourcePath;
        this.forDocumentation = forDocumentation;
        this.forTranslation = forTranslation;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

    public String getConsistentComponentID() {
        return consistentComponentID;
    }

    public void setConsistentComponentID(String consistentComponentID) {
        this.consistentComponentID = consistentComponentID;
    }

    public String getConsistentProjectID() {
        return consistentProjectID;
    }

    public void setConsistentProjectID(String consistentProjectID) {
        this.consistentProjectID = consistentProjectID;
    }

    public String getRegexValidator() {
        return regexValidator;
    }

    public void setRegexValidator(String regexValidator) {
        this.regexValidator = regexValidator;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMessageTypes() {
        return messageTypes;
    }

    public void setMessageTypes(List<String> messageTypes) {
        this.messageTypes = messageTypes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public void setPrimaryLocale(String primaryLocale) {
        this.primaryLocale = primaryLocale;
    }

    public boolean isExportAbouts() {
        return exportAbouts;
    }

    public void setExportAbouts(boolean exportAbouts) {
        this.exportAbouts = exportAbouts;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public boolean isForDocumentation() {
        return forDocumentation;
    }

    public void setForDocumentation(boolean forDocumentation) {
        this.forDocumentation = forDocumentation;
    }

    public boolean isForTranslation() {
        return forTranslation;
    }

    public void setForTranslation(boolean forTranslation) {
        this.forTranslation = forTranslation;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

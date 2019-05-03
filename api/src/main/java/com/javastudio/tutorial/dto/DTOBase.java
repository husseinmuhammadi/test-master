package com.javastudio.tutorial.dto;

import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object
 */
public abstract class DTOBase {

    protected static final String NEW_LINE = System.getProperty("line.separator");

    public DTOBase() {
    }

    public DTOBase(Long id) {
        this.id = id;
    }

    private Long id;

    private Date createOn;

    private Date updateOn;

    private Long version;

    private Boolean deleted;

    private String description;

    private String status;

    private String createBy;

    private String updateBy;

    public Date getCreateOn() {
        return createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getVersion() {
        return version;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * https://stackoverflow.com/questions/9069379/validation-error-value-is-not-valid
     * Error on faces convert while saving organization chart
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DTOBase))
            return false;

        DTOBase dtoBase = (DTOBase) o;

        return Objects.equals(getId(), dtoBase.getId()) &&
                Objects.equals(getVersion(), dtoBase.getVersion());
    }
}

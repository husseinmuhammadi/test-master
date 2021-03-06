package com.javastudio.tutorial.model.base;


import com.javastudio.tutorial.model.to.History;
import com.javastudio.tutorial.model.to.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class AuditedObject
        implements Comparable<AuditedObject>, Serializable {

    private Integer majorVersion = 0;
    private Integer midVersion = 0;
    private Integer minorVersion = 1;
    private String reason;
    private User modifierId;
    private Date modificationTime;

    public Integer getMajorVersion() {
        return this.majorVersion;
    }

    public void setMajorVersion(Integer majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Integer getMidVersion() {
        return this.midVersion;
    }

    public void setMidVersion(Integer midVersion) {
        this.midVersion = midVersion;
    }

    public Integer getMinorVersion() {
        return this.minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }

    public User getModifierId() {
        return modifierId;
    }

    public void setModifierId(User modifierId) {
        this.modifierId = modifierId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getModificationTime() {
        return this.modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    /**
     * Get history for this entity.
     *
     * @return history
     */
    public abstract List<History> getHistoryList();

    /**
     * Set history for this entity
     *
     * @param historyList
     */
    public abstract void setHistoryList(List<History> historyList);

    /**
     * Update the fields.
     *
     * @param target target object
     * @param source source object
     */
    public void update(AuditedObject target,
                       AuditedObject source) {
        target.setReason(source.getReason());
        target.setModificationTime(source.getModificationTime());
        target.setModifierId(source.getModifierId());
        target.setMajorVersion(source.getMajorVersion());
        target.setMidVersion(source.getMidVersion());
        target.setMinorVersion(source.getMinorVersion());
        target.setModifierId(source.getModifierId());
        target.setReason(source.getReason());
        target.setHistoryList(source.getHistoryList());
    }

    @Override
    public int compareTo(AuditedObject o) {
        if (!Objects.equals(getMajorVersion(),
                o.getMajorVersion())) {
            return getMajorVersion() - o.getMajorVersion();
        }//Same major version
        else if (!Objects.equals(getMidVersion(),
                o.getMidVersion())) {
            return getMidVersion() - o.getMidVersion();
        } //Same mid version
        else if (!Objects.equals(getMinorVersion(),
                o.getMinorVersion())) {
            return getMinorVersion() - o.getMinorVersion();
        }
        //Everything the same
        return 0;
    }

    /**
     * Add history to this entity.
     *
     * @param history History to add.
     */
    public void addHistory(History history) {
        if (getHistoryList() == null) {
            setHistoryList(new ArrayList<>());
        }
        getHistoryList().add(history);
    }

    /**
     * Increase major version.
     */
    public void increaseMajorVersion() {
        setMajorVersion(getMajorVersion() + 1);
        setMidVersion(0);
        setMinorVersion(0);
    }

    /**
     * Increase major version.
     */
    public void increaseMidVersion() {
        setMidVersion(getMidVersion() + 1);
        setMinorVersion(0);
    }

    /**
     * Increase minor is done by default when updating a record.
     */
}
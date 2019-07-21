package com.javastudio.tutorial.model.base;

import com.javastudio.tutorial.model.embeddable.Audit;
import com.javastudio.tutorial.model.listener.EntityLogger;

import javax.persistence.*;

/**
 * EntityBase is the base class for all entities and all entities should inherit this class.
 * This class is responsible to provide the primary field to which the <code>Id</code> annotation is applied and version for optimistic lock.
 * This class also is responsible for audit properties which is represented by Embedded Audit class.
 * The audit properties will not populate unless the entity implement the auditable and apply the EntityListeners annotation.
 */
@MappedSuperclass
@EntityListeners(EntityLogger.class)
public abstract class EntityBase {

    protected static final String NEW_LINE = System.getProperty("line.separator");
    public static final String STATE = "STATE";

    public EntityBase() {

    }

    public EntityBase(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long id;

    @Embedded
    private Audit audit;

    /*
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_ON", nullable = false, updatable = false, columnDefinition = "Date default sysdate")
    private Date createOn;

    @NotNull
    @Column(name = "CREATE_BY", nullable = false, updatable = false, length = 100)
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_ON", columnDefinition = "Date default sysdate", nullable = false)
    private Date updateOn;

    @NotNull
    @Column(name = "UPDATE_BY", nullable = false, updatable = false, length = 100)
    private String updateBy;
    */

    @Version
    @Column(nullable = false, columnDefinition = "NUMBER(19,0) default 0")
    private Long version;

    @Column(name = "IS_DELETED", nullable = false, columnDefinition = "NUMBER(1,0) default 0")
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @Column(name = STATE, length = 100)
    private String state;

    /*
    @PrePersist
    private void prePersist() {
        createOn = new Date();
        updateOn = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        updateOn = new Date();
    }
    */

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

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

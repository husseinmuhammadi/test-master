package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.Auditable;
import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.base.StateTracker;
import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PRODUCT_SEQ")
@EntityListeners(AuditListener.class)
public class Product extends EntityBase implements Auditable, StateTracker {

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

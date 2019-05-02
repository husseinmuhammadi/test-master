package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.Audit;
import com.javastudio.tutorial.model.base.Auditable;
import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "TAG")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TAG_SEQ")
public class Tag extends EntityBase implements Auditable {

    @Embedded
    Audit audit;

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}

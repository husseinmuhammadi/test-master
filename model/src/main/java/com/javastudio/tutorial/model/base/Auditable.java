package com.javastudio.tutorial.model.base;

import com.javastudio.tutorial.model.embeddable.Audit;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}

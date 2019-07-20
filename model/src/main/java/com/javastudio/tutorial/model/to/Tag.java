package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.Auditable;
import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAG")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TAG_SEQ")
public class Tag extends EntityBase implements Auditable {

}

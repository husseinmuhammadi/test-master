package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_RELEASE")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PRODUCT_RELEASE_SEQ")
public class ProductRelease extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RELEASE_DATE", nullable = false, columnDefinition = "Date default sysdate")
    Date releaseDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

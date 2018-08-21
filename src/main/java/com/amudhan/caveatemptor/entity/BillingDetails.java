package com.amudhan.caveatemptor.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * By default the properties of a superclass are ignored unless annotated as MappedSuperclass.
 * For the entities that extend this class, the mapping meta data present here will be applied.
 **/
@MappedSuperclass
public abstract class BillingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_detail_sequence")
//    @SequenceGenerator(initialValue = 1, name = "billing_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "userid")
    @NotNull
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

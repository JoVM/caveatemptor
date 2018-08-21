package com.amudhan.caveatemptor.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class CategorizedItem {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "institute_id")
    private Item item;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "headstructure_id")
    private Category category;

    private LocalDate date;
    private String userName;
}

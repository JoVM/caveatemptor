package com.amudhan.caveatemptor.entity;

import com.amudhan.caveatemptor.constant.CategoryQueries;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = CategoryQueries.GETALLCATEGORIES, query = CategoryQueries.GETALLCATEGORIES_Q)
})
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(initialValue = 1, name = "category_sequence", allocationSize = 1)
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "parentid")
    private Category parent;
    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }
}

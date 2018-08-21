package com.amudhan.caveatemptor.entity;

import com.amudhan.caveatemptor.constant.ImageQueries;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = ImageQueries.GETALLIMAGES, query = ImageQueries.GETALLIMAGES_Q)
})
@Entity
@Table(name = "image")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
//    @SequenceGenerator(initialValue = 1, name = "image_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "imageurl", nullable = false)
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "itemid")
    @NotNull
    private Item item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

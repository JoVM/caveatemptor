package com.amudhan.caveatemptor.entity;

import com.amudhan.caveatemptor.constant.BidQueries;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = BidQueries.GETALLBIDS, query = BidQueries.GETALLBIDS_Q)
})
@Entity
@Table(name = "bid")
public class Bid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bid_sequence")
//	@SequenceGenerator(initialValue= 1, name="bid_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "createdon", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "issuccess", columnDefinition = "default 0")
    private boolean isSuccess;
    @ManyToOne
    @JoinColumn(name = "itemid")
    @NotNull
    private Item item;
    @ManyToOne
    @JoinColumn(name = "bidderid")
    @NotNull
    private User bidder;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }
}

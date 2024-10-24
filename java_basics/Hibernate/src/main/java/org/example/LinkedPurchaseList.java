package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;
    @Column(name = "subscription_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;

    public LinkedPurchaseList() {
    }
}
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
@Table(name = "subscriptions")
public class Subscriptions {
    @EmbeddedId
    private SubscriptionsKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;
    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;

    public Subscriptions() {
    }
}
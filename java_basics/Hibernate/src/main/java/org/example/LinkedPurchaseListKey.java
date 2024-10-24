package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class LinkedPurchaseListKey implements Serializable {
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;

    public LinkedPurchaseListKey() {}

    public LinkedPurchaseListKey(Integer courseId, Integer studentId, Date subscriptionDate) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
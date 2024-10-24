package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private Integer duration;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CoursesType type;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teachers teacher;
    @Column(name = "students_count")
    private Integer studentsCount;
    @Column(name = "price")
    private Integer price;
    @Column(name = "price_per_hour")
    private Float pricePerHour;

    public Courses() {}
}
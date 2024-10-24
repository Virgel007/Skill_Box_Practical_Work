package org.example;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hibernate {
    private static final SessionFactory SESSION_FACTORY = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    private static CriteriaBuilder BUILDER;

    public static Session session() {
        return SESSION_FACTORY.getCurrentSession();
    }

    public static void getCriteriaBuilder() {
        BUILDER = session().getCriteriaBuilder();
    }

    public static CriteriaQuery criteriaQuery(Class name) {
        return BUILDER.createQuery(name);
    }

    public static void main(String[] args) {
        try {
            session().getTransaction().begin();
            getCriteriaBuilder();

            convertNameInId();

            Date date = new Date();
            addPurchase(1, 37, date);
            addPurchase(4, 35, date);
            addPurchase(25, 1, date);

            session().getTransaction().commit();
        } catch (NonUniqueObjectException e) {
            System.out.println("Найдена ошибка - \"NonUniqueObjectException\"");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session().close();
        }
    }

    public static void convertNameInId() {
        getCriteriaBuilder();
        Map<String, Integer> coursesMap = coursesList().stream()
                .collect(Collectors.toMap(x -> x.getName(), x -> x.getId()));
        Map<String, Integer> studentMap = studentsList().stream()
                .collect(Collectors.toMap(x -> x.getName(), x -> x.getId()));
        for (PurchaseList table1 : purchaseList()) {
            LinkedPurchaseListKey linkedPurchaseListKeyTable = new LinkedPurchaseListKey();
            linkedPurchaseListKeyTable.setCourseId(coursesMap.get(table1.getCourseName()));
            linkedPurchaseListKeyTable.setStudentId(studentMap.get(table1.getStudentName()));
            linkedPurchaseListKeyTable.setSubscriptionDate(table1.getSubscriptionDate());
            LinkedPurchaseList linkedPurchaseListTable = new LinkedPurchaseList();
            linkedPurchaseListTable.setId(linkedPurchaseListKeyTable);
            linkedPurchaseListTable.setCourseId(linkedPurchaseListKeyTable.getCourseId());
            linkedPurchaseListTable.setStudentId(linkedPurchaseListKeyTable.getStudentId());
            linkedPurchaseListTable.setSubscriptionDate(linkedPurchaseListKeyTable.getSubscriptionDate());
            session().save(linkedPurchaseListTable);
        }
    }

    public static void addPurchase(int courseId, int studentId, Date date) {
        Map<LinkedPurchaseListKey, LinkedPurchaseList> linkedPurchaseListMap = linkedPurchaseList().stream()
                .collect(Collectors.toMap(x -> new LinkedPurchaseListKey(x.getCourseId(), x.getStudentId(), x.getSubscriptionDate()), x -> x));
        LinkedPurchaseListKey purchaseListKey = new LinkedPurchaseListKey(courseId, studentId, date);
        if (linkedPurchaseListMap.containsKey(purchaseListKey)) {
            System.out.println("Такая запись есть " + purchaseListKey);
        } else {
            LinkedPurchaseList linkedPurchaseListTable = new LinkedPurchaseList();
            linkedPurchaseListTable.setId(purchaseListKey);
            linkedPurchaseListTable.setCourseId(purchaseListKey.getCourseId());
            linkedPurchaseListTable.setStudentId(purchaseListKey.getStudentId());
            linkedPurchaseListTable.setSubscriptionDate(date);
            session().save(linkedPurchaseListTable);
        }
    }

    public static List<LinkedPurchaseList> linkedPurchaseList() {
        CriteriaQuery<LinkedPurchaseList> LinkedPurchaseListQuery = criteriaQuery(LinkedPurchaseList.class);
        LinkedPurchaseListQuery.from(LinkedPurchaseList.class);
        return session().createQuery(LinkedPurchaseListQuery).getResultList();
    }

    public static List<PurchaseList> purchaseList() {
        CriteriaQuery<PurchaseList> PurchaseListQuery = criteriaQuery(PurchaseList.class);
        PurchaseListQuery.from(PurchaseList.class);
        return session().createQuery(PurchaseListQuery).getResultList();
    }

    public static List<Courses> coursesList() {
        CriteriaQuery<Courses> CoursesQuery = criteriaQuery(Courses.class);
        CoursesQuery.from(Courses.class);
        return session().createQuery(CoursesQuery).getResultList();
    }

    public static List<Students> studentsList() {
        CriteriaQuery<Students> StudentsQuery = criteriaQuery(Students.class);
        StudentsQuery.from(Students.class);
        return session().createQuery(StudentsQuery).getResultList();
    }
}
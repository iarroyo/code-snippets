package es.daivan.springtransactions.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Transient
    private List<Class> invokedClasses = new ArrayList<>();

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void addClass(Class cls) {
        this.invokedClasses.add(cls);
    }

    public List<Class> getInvokedClasses() {
        return this.invokedClasses;
    }
}

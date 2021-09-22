package com.worker.workerdepartment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String departmentname;
    @Column(name = "block")
    private String block;
    @Column(name = "salary")
    private String salary;
    @Column(name = "section")
    private String section;


    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Worker> work;


    @ManyToOne(targetEntity = Projects.class)
    @JoinColumn(name = "proje_id")
    private Projects projects;


    //@ManyToMany
    //@JoinTable(name = "departmant",joinColumns =@JoinColumn(name = "Proje_id"),inverseJoinColumns = @JoinColumn(name = "Project_id"))
    //private List<Projects> projec;
}
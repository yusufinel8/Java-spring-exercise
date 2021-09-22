package com.worker.workerdepartment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Projects implements Serializable {


    @javax.persistence.Id
    @Id
    @Column(name = "project_id")
    private Long id;

    @Column(name = "proje_name")
    private String projename;

    @Column(name = "proje_date")
    private Date date;

    @OneToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Department> depart;


    //@ManyToMany(mappedBy = "projec")
    //private List<department> departmant;
}

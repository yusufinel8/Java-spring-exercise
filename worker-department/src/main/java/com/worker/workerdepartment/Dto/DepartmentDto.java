package com.worker.workerdepartment.Dto;

import com.worker.workerdepartment.Entity.Department;
import com.worker.workerdepartment.Entity.Projects;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Setter
@Getter
public class DepartmentDto implements Serializable {

    private Long id;
    private String departmentname;
    private String block;
    private String salary;
    private String section;
    private Projects project;

    public DepartmentDto(Builder builder) {
        this.id = id;
        this.departmentname = departmentname;
        this.block = block;
        this.salary = salary;
        this.section = section;
        this.project = project;
    }

    public DepartmentDto() {
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder {

        private Long id;
        private String departmentname;
        private String block;
        private String salary;
        private String section;
        private Projects project;

        public Builder() {

        }

        public static Builder departmentWith() {
            return new Builder();
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder departmentname(final String departmentname) {
            this.departmentname = departmentname;
            return this;
        }
        public Builder block(final String block){
            this.block=block;
            return this;
        }
        public Builder salary(final String salary){
            this.salary=salary;
            return this;
        }
        public Builder section(final String section){
            this.section=section;
            return this;
        }
        public Builder department(final Projects projects){
            this.project=projects;
            return this;
        }
        public DepartmentDto build(){
            return new DepartmentDto(this);
        }
        public Department convertToEntity(DepartmentDto departmentDto){
            Department department=new Department();
            department.setId(departmentDto.getId());
            department.setDepartmentname(departmentDto.getDepartmentname());
            department.setBlock(departmentDto.getBlock());
            department.setSalary(departmentDto.getSalary());
            department.setSection(departmentDto.getSection());
            department.setProjects(departmentDto.getProject());
            return department;
        }

    }
}

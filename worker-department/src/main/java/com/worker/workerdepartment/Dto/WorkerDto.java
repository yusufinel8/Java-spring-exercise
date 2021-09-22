package com.worker.workerdepartment.Dto;

import com.worker.workerdepartment.Entity.Department;
import com.worker.workerdepartment.Entity.Worker;
import org.apache.commons.lang3.builder.EqualsBuilder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Setter
@Getter
public class WorkerDto implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private Long age;
    private Department department;

    public WorkerDto() {
    }
    public WorkerDto(Builder builder){
        this.id= builder.id;
        this.firstname=builder.firstname;
        this.lastname=builder.lastname;
        this.age=builder.age;
        this.department=builder.department;
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this,obj);
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder{
        private Long id;
        private String firstname;
        private String lastname;
        private Long age;
        private Department department;

        public Builder() {
        }
        public static Builder workerWith(){
            return new Builder();
        }
        public Builder id(final Long id){
            this.id=id;
            return this;
        }
        public Builder firstname(final String firstname){
            this.firstname=firstname;
            return this;
        }
        public Builder lastname(final String lastname){
            this.lastname=lastname;
            return this;
        }
        public Builder age(final Long age){
            this.age=age;
            return this;
        }
        public Builder department(final Department department){
            this.department=department;
            return this;
        }
        public WorkerDto build(){
            return new WorkerDto(this);
        }


        public Worker converToEntity(WorkerDto workerDto){
            Worker worker=new Worker();
            worker.setId(workerDto.getId());
            worker.setFirstname(workerDto.getFirstname());
            worker.setLastname(workerDto.getLastname());
            worker.setAge(workerDto.getAge());
            worker.setDepartment(workerDto.getDepartment());

            return worker;
        }

    }
}

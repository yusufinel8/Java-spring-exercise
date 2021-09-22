package com.worker.workerdepartment.Dto;

import com.worker.workerdepartment.Entity.Worker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Setter
@Getter
public class WorkerNameSurnameDto implements Serializable {
    private String firstname;
    private String lastname;

    public WorkerNameSurnameDto() {
    }

    public WorkerNameSurnameDto(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
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
        private String firstname;
        private String lastname;

        public Builder(){}


    public static Builder workerWith() {
        return new Builder();
    }

    public Builder firstname(final String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Builder lastname(final String lastname) {
        this.lastname = lastname;
        return this;
    }

    public WorkerNameSurnameDto build() {
        return new WorkerNameSurnameDto(this);
    }

    public Worker converToEntity(WorkerNameSurnameDto workerNameSurnameDto) {
        Worker worker = new Worker();
        worker.setFirstname(workerNameSurnameDto.getFirstname());
        worker.setLastname(workerNameSurnameDto.getLastname());
        return worker;
    }
}
}

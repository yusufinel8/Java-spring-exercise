package com.worker.workerdepartment.Dto;

import com.worker.workerdepartment.Entity.Projects;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class ProjectsDto implements Serializable {

    private Long id;
    private String projename;
    private Date date;

    public ProjectsDto(Builder builder) {
        this.id = builder.id;
        this.projename = builder.projename;
        this.date = builder.date;
    }

    public ProjectsDto() {
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
        private String projename;
        private Date date;


        public static Builder ProjectsWith() {
            return new Builder();
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder projename(final String projename) {
            this.projename = projename;
            return this;
        }

        public Builder date(final Date date) {
            this.date = date;
            return this;
        }

        public ProjectsDto build() {
            return new ProjectsDto(this);
        }

        public Projects converToEntity(ProjectsDto projectsDto) {
            Projects projects = new Projects();
            projects.setId(projectsDto.getId());
            projects.setProjename(projectsDto.getProjename());
            projects.setDate(projectsDto.getDate());

            return projects;
        }
    }

}

package com.worker.workerdepartment.Repository;

import com.worker.workerdepartment.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Projects,Long> {
    @Query(value = "insert into  projects (project_id,proje_name,proje_date) values(id,name,date)",nativeQuery = true)
    List<Projects> registerProject(int id, String name, Date date);

}

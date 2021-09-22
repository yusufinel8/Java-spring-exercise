package com.worker.workerdepartment.Repository;

import com.worker.workerdepartment.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeparmentRepo extends JpaRepository<Department,Long> , CrudRepository<Department,Long>{

    @Query(value = "insert into department(id,name,block,salary,section,proje_id) value(id,name,block,section, proje_id)",nativeQuery = true)
    List<Department> registerDepartment(int id, String name, String block, String section, int proje_id);

}

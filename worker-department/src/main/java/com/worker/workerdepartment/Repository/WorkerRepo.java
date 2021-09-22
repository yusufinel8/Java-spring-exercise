package com.worker.workerdepartment.Repository;

import com.worker.workerdepartment.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long>, CrudRepository<Worker, Long>, PagingAndSortingRepository<Worker,Long>, JpaSpecificationExecutor<Worker> {

    @Query(value = "Select * from worker w where w.worker_id=id ", nativeQuery = true)
    List<Worker> getUsers(@Param("id") Long id);

    @Query(value = "select * from worker w where w.first_name =?1 ", nativeQuery = true)
    List<Worker> getFirstname(String name);

    @Query(value = "select * from worker  where (first_name='' or first_name=?1) and (last_name='' or last_name=?2)",nativeQuery = true)
    List<Worker> findRepo(@Param("1") String firstname,@Param("2") String lastname);

    void deleteById(Long id);


}

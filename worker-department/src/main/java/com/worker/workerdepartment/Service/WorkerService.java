package com.worker.workerdepartment.Service;

import com.worker.workerdepartment.Dto.WorkerDto;
import com.worker.workerdepartment.Dto.WorkerNameSurnameDto;
import com.worker.workerdepartment.Entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

    List<Worker> getFirstname(String name);

    void deleteById(Long id);

    List<Worker> getWorker(Long id);

    Optional<Worker> getAlluser(Long age);

    List<Worker> findByAgeService(int age);

    WorkerDto save(WorkerDto workerDto);

    List<Worker> findService(String firstname,String lastnames);

    Page<WorkerDto> filterService(WorkerDto worker, Pageable pageable);

}

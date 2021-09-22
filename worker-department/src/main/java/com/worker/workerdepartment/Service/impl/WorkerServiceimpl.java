package com.worker.workerdepartment.Service.impl;

import com.worker.workerdepartment.Dto.WorkerDto;
import com.worker.workerdepartment.Entity.Worker;
import com.worker.workerdepartment.Repository.DeparmentRepo;
import com.worker.workerdepartment.Repository.ProjectRepo;
import com.worker.workerdepartment.Repository.WorkerRepo;
import com.worker.workerdepartment.Service.WorkerService;
import com.worker.workerdepartment.mapper.WorkerDtoMapper;
import com.worker.workerdepartment.spec.WorkerSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceimpl implements WorkerService {
    private final WorkerRepo workerrepository;
    private final DeparmentRepo deparmentRepo;
    private final ProjectRepo projectRepo;
    private final WorkerDtoMapper mapper;

    @Autowired
    public WorkerServiceimpl(WorkerRepo workerrepository, DeparmentRepo deparmentRepo, ProjectRepo projectRepo, WorkerDtoMapper map) {
        this.workerrepository = workerrepository;
        this.deparmentRepo = deparmentRepo;
        this.projectRepo = projectRepo;
        this.mapper = map;
    }

    @Override
    public List<Worker> getWorker(Long id) {
        List<Worker> mylist = workerrepository.getUsers(id);
        return mylist;
    }

    @Override
    public Optional<Worker> getAlluser(Long age) {
        Optional<Worker> mylist = workerrepository.findById(age);
        return mylist;
    }

    @Override
    public List<Worker> findByAgeService(int age) {

        //List<Worker> mylist=workerrepository.findByAge(age);
        return null; //mylist;
    }

    @Override
    public WorkerDto save(WorkerDto workerDto) {

        Worker worker = WorkerDto.Builder.workerWith().converToEntity(workerDto);
        Worker work = workerrepository.save(worker);
        WorkerDto saved = mapper.map(work);
        return saved;

    }

    @Override
    public List<Worker> getFirstname(String name) {
        List<Worker> work = workerrepository.getFirstname(name);
        return work;

    }

    @Override
    public void deleteById(Long id) {
        workerrepository.deleteById(id);
    }

    @Override
    public List<Worker> findService(String firstname, String lastname) {
        List<Worker> work = workerrepository.findRepo(firstname, lastname);
        return work;
    }

    @Override
    public Page<WorkerDto> filterService(WorkerDto workerDto, Pageable pageable) {
        Worker worker = mapper.convertToEntity(workerDto);
        return mapper.mapPage(workerrepository.findAll(WorkerSpec.findByFilter(worker),pageable));

    }


}

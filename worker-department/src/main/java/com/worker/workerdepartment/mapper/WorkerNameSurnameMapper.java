package com.worker.workerdepartment.mapper;

import com.worker.workerdepartment.Dto.WorkerNameSurnameDto;
import com.worker.workerdepartment.Entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/*
 * Bu dtonun maperi yazılıp service kısmında filtreleme yapılacak
 * */
public class WorkerNameSurnameMapper {

    public Worker converToEntity(WorkerNameSurnameDto workerNameSurnameDto) {
        return WorkerNameSurnameDto.Builder.workerWith().converToEntity(workerNameSurnameDto);
    }

    public WorkerNameSurnameDto map(Worker worker){
        return WorkerNameSurnameDto.Builder.workerWith().firstname(worker.getFirstname()).lastname(worker.getLastname()).build();
    }



}

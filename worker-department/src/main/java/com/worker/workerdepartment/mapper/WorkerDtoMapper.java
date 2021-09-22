package com.worker.workerdepartment.mapper;

import com.worker.workerdepartment.Dto.WorkerDto;
import com.worker.workerdepartment.Entity.Worker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
* Mapperlar Bizim convert işlemlerini yaptıgımız katmandır bu katmanı Bean (yada Service katmanında) yaptıgımız işlemlerde kullanılırız.
* mapper kullanmamızın nedeni convert işlemlerinde Dto yada entity classlarımızdan instance oluşturmadan kullanmaktır.
* */
@Component
public class WorkerDtoMapper {

    /*
    * Bu fonksiyon Worker entity içindeki fieldlarımızı Dto classımızdaki fieldlara eşleştirir.
    * */
    public WorkerDto map(Worker worker){
        return WorkerDto.Builder.workerWith().id(worker.getId()).firstname(worker.getFirstname())
                .lastname(worker.getLastname()).age(worker.getAge()).department(worker.getDepartment()).build();
    }

    /*
    * Bu fonkisyon Dto'yu Entity ye çevir
    * */
    public Worker convertToEntity(WorkerDto workerDto){

        return WorkerDto.Builder.workerWith().converToEntity(workerDto);

    }
    /*
    * Bu fonksiyon liste halinde entityi Dto halindeki bir listeye çevirir.
    * */
    public List<WorkerDto>  mapList(List<Worker> worker){
        List<WorkerDto> maplist=new ArrayList<>();
        for(Worker work : worker){
            maplist.add(this.map(work));
        }
        return maplist;
    }
    public Page<WorkerDto> mapPage(Page<Worker> worker){
        return new PageImpl<>(mapList(worker.getContent()),worker.getPageable(),worker.getTotalElements());
    }

}

package com.worker.workerdepartment.Controller;


import com.worker.workerdepartment.Dto.WorkerDto;
import com.worker.workerdepartment.Entity.Worker;
import com.worker.workerdepartment.Repository.WorkerRepo;
import com.worker.workerdepartment.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @PostMapping("/getir")
    public String getir(){
        String message="istek başarılı";
        return message;
    }





    private final WorkerService workerservice;
    private final WorkerRepo workerRepo;

    @Autowired
    public WorkerController(WorkerService workerService, WorkerRepo workerRepo) {

        this.workerservice = workerService;
        this.workerRepo = workerRepo;
    }

    //Tüm Veri tabanının çeker
    @PostMapping("/getworker")
    public List<Worker> get() {
       // workerRepo.deleteById(id);// aldığı id parametresine göre silme yapar
       // workerRepo.getFirstname(name); // aldığı isim parametresine göre arama yapar.
       // workerRepo.count();//veri tabanındaki kayıtlı kişi sayısını getirir.
       // workerRepo.findById(id);// id ye göre seaech işlemi yapar
        return workerRepo.findAll();
    }

    //yaşa göre getirme
    //@GetMapping("/get/{age}")
    //public Optional<Worker> getAlluser(@PathVariable(required = false) Long age) {
      //  Optional<Worker> myList = workerservice.getAlluser(age);
        //if(myList.isPresent()){
         // return myList;
        //}



      //  return myList;
    //}

    //Firstname göre getirme işlemi
    @GetMapping("/get")
    public List<Worker> getFirstname(@RequestParam(name = "name") String name) {
        return workerservice.getFirstname(name);
    }

    //Update Insert save işlemleri
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WorkerDto save(@RequestBody WorkerDto workerdto) {
        return workerservice.save(workerdto);
    }

    //Ad ve soyada göre search
    @GetMapping("/find/{ad}/{soyad}")
    @ResponseBody
    public List<Worker> findController(@PathVariable String ad, @PathVariable String soyad) {

        return workerservice.findService(ad, soyad);
    }

    @PostMapping(value = "filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<WorkerDto> filtreController(@RequestBody WorkerDto workerDto, Pageable pageable) {
        return workerservice.filterService(workerDto, pageable);
    }


    // İd ye göre veri çekme
    // @GetMapping("/get/{age}")
    // public Optional<com.worker.workerdepartment.Entity.Worker> getAlluser(@PathVariable("age") Long age){
    //  Optional<com.worker.workerdepartment.Entity.Worker> myList=Worker.getAlluser( age);
    //  return myList;
    // }
}

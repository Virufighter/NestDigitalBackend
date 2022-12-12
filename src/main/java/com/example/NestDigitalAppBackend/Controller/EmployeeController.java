package com.example.NestDigitalAppBackend.Controller;

import com.example.NestDigitalAppBackend.Doa.EmployeeDoa;
import com.example.NestDigitalAppBackend.Doa.EmpoyeeLCountDoa;
import com.example.NestDigitalAppBackend.Model.EmployeeLCountModel;
import com.example.NestDigitalAppBackend.Model.EmployeeRegModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDoa edoa;

    @Autowired
    private EmpoyeeLCountDoa empcountdoa;




    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> AddEmployee(@RequestBody EmployeeRegModel e){
        edoa.save(e);
        EmployeeLCountModel model=new EmployeeLCountModel();
        model.setEmpid(e.getId());
        model.setName(e.getName());
        model.setCasualleave(20);
        model.setSickleave(7);
        model.setSpecialleave(3);
        empcountdoa.save(model);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;


    }
}

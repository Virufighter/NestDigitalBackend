package com.example.NestDigitalAppBackend.Doa;

import com.example.NestDigitalAppBackend.Model.EmployeeRegModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDoa extends CrudRepository<EmployeeRegModel,Integer> {
}

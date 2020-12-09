package com.demo.app.dto;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "represnt Employee Details")
public class Employee extends  RepresentationModel<Employee> {
	
	private String name;

}

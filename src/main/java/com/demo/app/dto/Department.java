package com.demo.app.dto;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Mapping table BETWEEN Employee and Department")
public class Department extends RepresentationModel<Department>{

	@ApiModelProperty(notes = "Primary key in Employee Table")
	private String employeeId;
	@ApiModelProperty(notes = "Primary key in Department Table")
	private Integer depId;
}

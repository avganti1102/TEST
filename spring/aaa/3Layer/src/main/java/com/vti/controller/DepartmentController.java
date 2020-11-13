package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public List<Department> getAllDepartments(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int size, 
			@RequestParam(defaultValue = "ASC") String sortType,
			@RequestParam(defaultValue = "id") String sortField,
			@RequestParam(defaultValue = "") String searchField,
			@RequestParam(required = false) String value,
			@RequestParam(defaultValue = "0")int from,
			@RequestParam(defaultValue = "20")int to) {
		return service.getAllDepartments(page, size, sortType, sortField, searchField, value, from, to);
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") short id) {
		return service.getDepartmentByID(id);
	}

	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") short id, @RequestBody Department department) {
		department.setId(id);
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
	}
}

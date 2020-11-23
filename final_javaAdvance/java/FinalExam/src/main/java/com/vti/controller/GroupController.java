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
import org.springframework.web.bind.annotation.RestController;
import com.vti.entity.Group;
import com.vti.repository.IUserRepository;
import com.vti.service.IGroupService;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GroupController {

	@Autowired
	private IGroupService service;
	@Autowired
	private IUserRepository user;

	@GetMapping()
	public List<Group> getAllGroups() {
		return service.getAllGroups();
	}

	@GetMapping(value = "/{id}")
	public Group getGroupByID(@PathVariable(name = "id") Short id) {
		return service.getGroupById(id);
	}

	@PostMapping()
	public void createGroup(@RequestBody Group Group) {
		service.createGroup(Group);
	}

	@PutMapping(value = "/{id}")
	public void updateGroup(@PathVariable(name = "id") Short id, @RequestBody Group group) {
		group.setCreator(user.getOne(id));
		service.updateGroup(group);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteGroup(@PathVariable(name = "id") Short id) {
		service.deleteGroup(id);
	}
}

package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Group;
import com.vti.repository.IGroupRepository;
@Service
public class GroupService implements IGroupService{
	
	@Autowired
	private IGroupRepository repository;
	
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups() {
		return repository.findAll();
	}
	
	public void createGroup(Group group) {
		repository.save(group);
	}
	
	public void deleteGroup(Short id) {
		repository.deleteById(id);
	}

	@Override
	public void updateGroup(Group group) {
		repository.save(group);
	}

	@Override
	public Group getGroupById(Short id) {
		return repository.getGroupById(id);
	}

}

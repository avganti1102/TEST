package com.vti.service;

import java.util.List;

import com.vti.entity.Group;

public interface IGroupService {
	public List<Group> getAllGroups();
	
	public Group getGroupById(Short id);
	
	public void createGroup(Group group);

	public void updateGroup(Group group);

	public void deleteGroup(Short id);

}

package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Group;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Short>{

	public Group getGroupById(Short id);

}

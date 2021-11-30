package io.itschool.courses.service.impl;

import io.itschool.courses.model.entity.Group;
import io.itschool.courses.repository.GroupRepository;
import io.itschool.courses.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }
}

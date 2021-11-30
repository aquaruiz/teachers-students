package io.itschool.courses.controller;


import io.itschool.courses.model.dto.GroupDTO;
import io.itschool.courses.model.entity.Group;
import io.itschool.courses.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {

    private final GroupService groupService;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupsController(GroupService groupService, ModelMapper modelMapper) {
        this.groupService = groupService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAll() {
        List<Group> allGroups = groupService.getAll();

        List<GroupDTO> groupDtos = allGroups.stream()
                .map(s -> modelMapper.map(s, GroupDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(groupDtos);
    }
}

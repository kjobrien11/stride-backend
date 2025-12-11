package com.stride.stride.controller;


import com.stride.stride.dto.TaskCreationDTO;
import com.stride.stride.dto.TaskDTO;
import com.stride.stride.service.TaskService;
import com.stride.stride.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return ResponseEntity.ok(taskService.getTasksByUserId(1));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskCreationDTO taskCreationDTO){
        return ResponseEntity.ok(taskService.createTask(taskCreationDTO));
    }


}

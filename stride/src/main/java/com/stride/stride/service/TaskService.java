package com.stride.stride.service;

import com.stride.stride.dto.TaskCreationDTO;
import com.stride.stride.dto.TaskDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TaskService {
    public TaskDTO createTask(TaskCreationDTO taskToCreate);
    public List<TaskDTO> getTasksByUserId(Integer id);
}

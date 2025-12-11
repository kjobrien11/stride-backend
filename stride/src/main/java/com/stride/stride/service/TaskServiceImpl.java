package com.stride.stride.service;

import com.stride.stride.dto.TaskCreationDTO;
import com.stride.stride.dto.TaskDTO;
import com.stride.stride.entity.Task;
import com.stride.stride.entity.User;
import com.stride.stride.repository.TaskRepository;
import com.stride.stride.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl{

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public List<TaskDTO> getTasksByUserId(Integer id){
        List<Task> userTasks =  taskRepository.findByUserId(1);
        return userTasks.stream()
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getName(),
                        task.getActive(),
                        task.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO createTask(TaskCreationDTO taskToCreate){

        User user = userRepository.findById(taskToCreate.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setName(taskToCreate.name());
        task.setUser(user);

        Task saved = taskRepository.save(task);

        return new TaskDTO(saved.getId(), saved.getName(), saved.getActive(), saved.getCreatedAt());

    }
}

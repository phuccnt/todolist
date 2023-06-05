package phuc.todolist.mappers;

import org.springframework.stereotype.Component;
import phuc.todolist.dtos.TodoTaskDTO;
import phuc.todolist.dtos.TodolistDTO;
import phuc.todolist.entities.TodoList;
import phuc.todolist.entities.TodoTask;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class TodolistMapper {

    public TodoTask todoTaskDtoToEntity(TodoTaskDTO todoTaskDTO){
        return TodoTask.builder()
                .name(todoTaskDTO.getName())
                .id(todoTaskDTO.getId())
                .createdDate(todoTaskDTO.getCreatedDate())
                .isCompleted(todoTaskDTO.getIsCompleted())
                .build();
    }

    public TodoTaskDTO todoTaskToDto(TodoTask todoTask){
        return TodoTaskDTO.builder()
                .id(todoTask.getId())
                .name(todoTask.getName())
                .createdDate(todoTask.getCreatedDate())
                .isCompleted(todoTask.getIsCompleted())
                .build();
    }

    public TodolistDTO todolistToDto(TodoList todoList){
        return TodolistDTO.builder()
                .id(todoList.getId())
                .description(todoList.getDescription())
                .name(todoList.getName())
                .todoTasks(todoList
                        .getTodoTasks()
                        .stream()
                        .map(todoTask -> todoTaskToDto(todoTask))
                        .collect(Collectors.toList())
                )
                .createdDate(todoList.getCreatedDate())
                .build();
    }
    public TodoList todolistDtoToEntity(TodolistDTO todolistDTO) {
        return TodoList.builder()
                .id(todolistDTO.getId())
                .description(todolistDTO.getDescription())
                .name(todolistDTO.getName())
                .todoTasks(todolistDTO
                        .getTodoTasks()
                        .stream()
                        .map(todoTaskDTO -> todoTaskDtoToEntity(todoTaskDTO))
                        .collect(Collectors.toList())
                )
                .createdDate(todolistDTO.getCreatedDate())
                .build();
    }

}

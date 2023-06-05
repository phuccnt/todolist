package phuc.todolist.services.impl;

import org.springframework.stereotype.Service;
import phuc.todolist.dtos.TodolistDTO;
import phuc.todolist.entities.TodoList;
import phuc.todolist.mappers.TodolistMapper;
import phuc.todolist.repositories.TodolistRepository;
import phuc.todolist.services.TodolistService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodolistServiceImpl implements TodolistService {

    private TodolistMapper todolistMapper;
    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistMapper todolistMapper, TodolistRepository todolistRepository) {
        this.todolistMapper = todolistMapper;
        this.todolistRepository = todolistRepository;
    }

    @Override
    public List<TodolistDTO> getTodolist() {
        List<TodoList> todoList = todolistRepository.findAll();
        return todoList.stream()
                .map(tdlist -> todolistMapper.todolistToDto(tdlist))
                .collect(Collectors.toList());

    }
}

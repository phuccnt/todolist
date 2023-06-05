package phuc.todolist.services.impl;

import org.springframework.stereotype.Service;
import phuc.todolist.controllers.predicate.TodolistPredicate;
import phuc.todolist.dtos.TodolistDTO;
import phuc.todolist.entities.TodoList;
import phuc.todolist.entities.TodoTask;
import phuc.todolist.mappers.TodolistMapper;
import phuc.todolist.repositories.TodolistRepository;
import phuc.todolist.services.TodolistService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodolistServiceImpl implements TodolistService {

    private final TodolistMapper todolistMapper;
    private final TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistMapper todolistMapper, TodolistRepository todolistRepository) {
        this.todolistMapper = todolistMapper;
        this.todolistRepository = todolistRepository;
    }

    @Override
    public List<TodolistDTO> getTodolist(TodolistPredicate todolistPredicate) {
        List<TodoList> todoList = todolistRepository.findAll();

        if (todolistPredicate != null) {
            LocalDateTime startFilter = todolistPredicate.getStart().atStartOfDay();
            LocalDateTime endFilter = todolistPredicate.getEnd().atStartOfDay();
            LocalDateTime taskStartFilter = todolistPredicate.getTaskStart().atStartOfDay();
            LocalDateTime taskEndFilter = todolistPredicate.getTaskEnd().atStartOfDay();
            todoList = todoList.stream()
                    .filter(tdlist -> isInRangeDate(startFilter, endFilter, tdlist.getCreatedDate()))
                    .peek(tdlist ->{
                        List<TodoTask> filteredTasks = tdlist.getTodoTasks().stream()
                                .filter(task -> task.getIsCompleted().equals(todolistPredicate.getIsCompleted()))
                                .filter(task -> isInRangeDate(taskStartFilter, taskEndFilter, task.getCreatedDate()))
                                .collect(Collectors.toList());
                        tdlist.setTodoTasks(filteredTasks);
                    })
                    .collect(Collectors.toList());
        }
        return todoList.stream()
                .map(tdlist -> todolistMapper.todolistToDto(tdlist))
                .collect(Collectors.toList());

    }

    private boolean isInRangeDate(LocalDateTime taskStartFilter, LocalDateTime taskEndFilter, LocalDateTime createdDate) {
        return createdDate.isAfter(taskStartFilter) && createdDate.isBefore(taskEndFilter);
    }

}

package phuc.todolist.services;

import phuc.todolist.dtos.TodolistDTO;

import java.util.List;

public interface TodolistService {

    List<TodolistDTO> getTodolist();
}

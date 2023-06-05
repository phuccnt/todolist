package phuc.todolist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phuc.todolist.dtos.TodolistDTO;
import phuc.todolist.services.TodolistService;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class TodolistController {

    private TodolistService todolistService;

    public TodolistController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping
    public ResponseEntity<List<TodolistDTO>> getTodolist(){
        List<TodolistDTO> todolistDTO = todolistService.getTodolist();
        return  ResponseEntity.ok(todolistDTO);
    }
}

package phuc.todolist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phuc.todolist.controllers.predicate.TodolistPredicate;
import phuc.todolist.dtos.TodolistDTO;
import phuc.todolist.services.TodolistService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todolist")
public class TodolistController {

    private TodolistService todolistService;

    public TodolistController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping
    public ResponseEntity<List<TodolistDTO>> getTodolist(@RequestBody(required=false) TodolistPredicate todolistPredicate){
        //TODO : prevent start day passes end day, wrong date format
        List<TodolistDTO> todolistDTO = todolistService.getTodolist(todolistPredicate);

        return ResponseEntity.ok(todolistDTO);
    }
}

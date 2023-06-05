package phuc.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.todolist.entities.TodoList;

@Repository
public interface TodolistRepository extends JpaRepository<TodoList, Long> {
}

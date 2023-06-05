package phuc.todolist.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_list")
@Data
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todoList")
    @Column(name = "todo_tasks")
    private List<TodoTask> todoTasks;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}

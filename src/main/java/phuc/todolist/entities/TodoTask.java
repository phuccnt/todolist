package phuc.todolist.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "todo_task")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}

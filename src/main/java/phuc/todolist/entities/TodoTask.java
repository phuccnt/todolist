package phuc.todolist.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_task")
@Getter
@Setter
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

    @Override
    public String toString() {
        return "TodoTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoTask)) return false;
        TodoTask todoTask = (TodoTask) o;
        return Objects.equals(id, todoTask.id) && Objects.equals(name, todoTask.name) && Objects.equals(isCompleted, todoTask.isCompleted) && Objects.equals(todoList, todoTask.todoList) && Objects.equals(createdDate, todoTask.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted, todoList, createdDate);
    }


}

package phuc.todolist.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "todo_list")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todoList", fetch = FetchType.LAZY)
    @Column(name = "todo_tasks")
    private List<TodoTask> todoTasks;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoList)) return false;
        TodoList todoList = (TodoList) o;
        return Objects.equals(id, todoList.id) && Objects.equals(name, todoList.name) && Objects.equals(description, todoList.description) && Objects.equals(todoTasks, todoList.todoTasks) && Objects.equals(createdDate, todoList.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, todoTasks, createdDate);
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", todoTasks=" + todoTasks +
                ", createdDate=" + createdDate +
                '}';
    }
}

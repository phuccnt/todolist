package phuc.todolist.controllers.predicate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TodolistPredicate {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    @JsonProperty("is_completed")
    private Boolean isCompleted;

    @JsonProperty("task_start")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskStart;

    @JsonProperty("task_end")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskEnd;

    public LocalDate getStart() {
        return start != null ? start : LocalDate.MIN;
    }

    public LocalDate getEnd() {
        return end != null ? end : LocalDate.MAX;
    }

    public LocalDate getTaskStart() {
        return taskStart != null ? taskStart : LocalDate.MIN;
    }

    public LocalDate getTaskEnd() {
        return taskEnd != null ? taskEnd : LocalDate.MAX;
    }
}

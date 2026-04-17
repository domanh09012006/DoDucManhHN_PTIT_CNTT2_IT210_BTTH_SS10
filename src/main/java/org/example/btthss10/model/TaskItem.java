package org.example.btthss10.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItem {

    private String id;

    @NotBlank(message = "Tên công việc không được để trống")
    @Size(min = 5, message = "Tên công việc phải có ít nhất 5 ký tự")
    private String title;

    @NotNull(message = "Deadline không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @Pattern(regexp = "HIGH|MEDIUM|LOW", message = "Priority phải là HIGH, MEDIUM hoặc LOW")
    private String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}

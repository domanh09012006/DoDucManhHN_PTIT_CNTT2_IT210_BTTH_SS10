package org.example.btthss10.controller;

import jakarta.validation.Valid;
import org.example.btthss10.model.TaskItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private List<TaskItem> taskList = new ArrayList<>();

    public TaskController() {
        TaskItem t1 = new TaskItem();
        t1.setId("1");
        t1.setTitle("Học Spring MVC");
        t1.setDeadline(LocalDate.now().plusDays(3));
        t1.setPriority("HIGH");

        TaskItem t2 = new TaskItem();
        t2.setId("2");
        t2.setTitle("Làm bài tập Java");
        t2.setDeadline(LocalDate.now().plusDays(5));
        t2.setPriority("MEDIUM");

        taskList.add(t1);
        taskList.add(t2);
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskList);
        return "task-list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        return "task-form";
    }

    @PostMapping("/add")
    public String saveTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "task-form";
        }
        taskItem.setId(String.valueOf(taskList.size() + 1));
        taskList.add(taskItem);
        model.addAttribute("tasks", taskList);
        return "task-list";
    }
}









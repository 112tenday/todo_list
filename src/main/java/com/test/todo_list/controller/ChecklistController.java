package com.test.todo_list.controller;

import com.test.todo_list.model.Checklist;
import com.test.todo_list.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping
    public List<Checklist> getAllChecklists(@RequestHeader("Authorization") String token) {
        return checklistService.getAllChecklists();
    }

    @PostMapping
    public String createChecklist(@RequestHeader("Authorization") String token, @RequestBody Checklist checklist) {
        checklistService.createChecklist(checklist);
        return "Checklist created successfully!";
    }

    @DeleteMapping("/{checklistId}")
    public String deleteChecklist(@RequestHeader("Authorization") String token, @PathVariable Long checklistId) {
        checklistService.deleteChecklist(checklistId);
        return "Checklist deleted successfully!";
    }
}

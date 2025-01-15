package com.test.todo_list.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {

    @GetMapping
    public ResponseEntity<List<String>> getAllChecklists() {
        // Logika untuk mendapatkan semua checklist
        return ResponseEntity.ok(List.of("Checklist 1", "Checklist 2"));
    }

    @PostMapping
    public ResponseEntity<String> createNewChecklist(@RequestBody ChecklistRequest checklistRequest) {
        // Logika untuk membuat checklist baru
        return ResponseEntity.ok("Checklist created");
    }

    @DeleteMapping("/{checklistId}")
    public ResponseEntity<String> deleteChecklistById(@PathVariable int checklistId) {
        // Logika untuk menghapus checklist berdasarkan ID
        return ResponseEntity.ok("Checklist deleted");
    }
}

class ChecklistRequest {
    private String name;

    // Getters and Setters
}


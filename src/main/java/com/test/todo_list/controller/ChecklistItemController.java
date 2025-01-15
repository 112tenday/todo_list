package com.test.todo_list.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/checklist/{checklistId}/item")
public class ChecklistItemController {

    @GetMapping
    public ResponseEntity<List<String>> getAllItems(@PathVariable int checklistId) {
        // Logika untuk mendapatkan semua item dari checklist berdasarkan checklistId
        return ResponseEntity.ok(List.of("Item 1", "Item 2"));
    }

    @PostMapping
    public ResponseEntity<String> createNewItem(@PathVariable int checklistId, @RequestBody ChecklistItemRequest checklistItemRequest) {
        // Logika untuk membuat item baru di checklist
        return ResponseEntity.ok("Item created");
    }

    @GetMapping("/{checklistItemId}")
    public ResponseEntity<String> getItemById(@PathVariable int checklistId, @PathVariable int checklistItemId) {
        // Logika untuk mendapatkan item berdasarkan checklistId dan checklistItemId
        return ResponseEntity.ok("Item details");
    }

    @PutMapping("/{checklistItemId}")
    public ResponseEntity<String> updateItemStatus(@PathVariable int checklistId, @PathVariable int checklistItemId) {
        // Logika untuk memperbarui status item
        return ResponseEntity.ok("Item status updated");
    }

    @DeleteMapping("/{checklistItemId}")
    public ResponseEntity<String> deleteItem(@PathVariable int checklistId, @PathVariable int checklistItemId) {
        // Logika untuk menghapus item berdasarkan ID
        return ResponseEntity.ok("Item deleted");
    }

    @PutMapping("/rename/{checklistItemId}")
    public ResponseEntity<String> renameItem(@PathVariable int checklistId, @PathVariable int checklistItemId, @RequestBody RenameItemRequest renameItemRequest) {
        // Logika untuk mengganti nama item
        return ResponseEntity.ok("Item renamed");
    }
}

class ChecklistItemRequest {
    private String itemName;

    // Getters and Setters
}

class RenameItemRequest {
    private String itemName;

    // Getters and Setters
}


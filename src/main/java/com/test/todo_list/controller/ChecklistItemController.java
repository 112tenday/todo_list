package com.test.todo_list.controller;

import com.test.todo_list.model.Checklist;
import com.test.todo_list.model.ChecklistItem;
import com.test.todo_list.service.ChecklistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistItemController {

    @Autowired
    private ChecklistItemService checklistItemService;

    // 1. Get all checklist items by checklist ID
    @GetMapping("/{checklistId}/item")
    public List<ChecklistItem> getAllChecklistItems(@RequestHeader("Authorization") String token,
                                                    @PathVariable Long checklistId) {
        // Token validation can be handled here
        return checklistItemService.getAllChecklistItems(checklistId);
    }

    // 2. Create new checklist item in a checklist
    @PostMapping("/{checklistId}/item")
    public String createChecklistItem(@RequestHeader("Authorization") String token,
                                      @PathVariable Long checklistId,
                                      @RequestBody ChecklistItem checklistItem) {
        // Token validation can be handled here
        checklistItemService.createChecklistItem(checklistId, checklistItem);
        return "Checklist item created successfully!";
    }

    // 3. Get checklist item by checklist ID and item ID
    @GetMapping("/{checklistId}/item/{checklistItemId}")
    public ChecklistItem getChecklistItem(@RequestHeader("Authorization") String token,
                                          @PathVariable Long checklistId,
                                          @PathVariable Long checklistItemId) {
        // Token validation can be handled here
        return checklistItemService.getChecklistItem(checklistId, checklistItemId);
    }

    // 4. Update status of checklist item by item ID
    @PutMapping("/{checklistId}/item/{checklistItemId}")
    public String updateChecklistItemStatus(@RequestHeader("Authorization") String token,
                                            @PathVariable Long checklistId,
                                            @PathVariable Long checklistItemId,
                                            @RequestBody ChecklistItem checklistItem) {
        // Token validation can be handled here
        checklistItemService.updateChecklistItemStatus(checklistId, checklistItemId, checklistItem);
        return "Checklist item status updated successfully!";
    }

    // 5. Delete checklist item by item ID
    @DeleteMapping("/{checklistId}/item/{checklistItemId}")
    public String deleteChecklistItem(@RequestHeader("Authorization") String token,
                                      @PathVariable Long checklistId,
                                      @PathVariable Long checklistItemId) {
        // Token validation can be handled here
        checklistItemService.deleteChecklistItem(checklistId, checklistItemId);
        return "Checklist item deleted successfully!";
    }

    // 6. Rename checklist item by item ID
    @PutMapping("/{checklistId}/item/rename/{checklistItemId}")
    public String renameChecklistItem(@RequestHeader("Authorization") String token,
                                      @PathVariable Long checklistId,
                                      @PathVariable Long checklistItemId,
                                      @RequestBody ChecklistItem checklistItem) {
        // Token validation can be handled here
        checklistItemService.renameChecklistItem(checklistId, checklistItemId, checklistItem);
        return "Checklist item renamed successfully!";
    }
}

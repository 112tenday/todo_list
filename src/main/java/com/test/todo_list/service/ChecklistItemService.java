package com.test.todo_list.service;

import com.test.todo_list.model.Checklist;
import com.test.todo_list.model.ChecklistItem;
import com.test.todo_list.repository.ChecklistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistItemService {

    @Autowired
    private ChecklistItemRepository checklistItemRepository;

    @Autowired
    private ChecklistService checklistService;

    public List<ChecklistItem> getAllChecklistItems(Long checklistId) {
        return checklistItemRepository.findByChecklistId(checklistId);
    }

    // 2. Membuat checklist item baru dalam checklist
    public void createChecklistItem(Long checklistId, ChecklistItem checklistItem) {
        Checklist checklist = checklistService.getChecklistById(checklistId);
        checklistItem.setChecklist(checklist);
        checklistItemRepository.save(checklistItem);
    }

    public ChecklistItem getChecklistItem(Long checklistId, Long checklistItemId) {
        return checklistItemRepository.findByIdAndChecklistId(checklistItemId, checklistId);
    }

    public void updateChecklistItemStatus(Long checklistId, Long checklistItemId, ChecklistItem checklistItem) {
        ChecklistItem existingItem = getChecklistItem(checklistId, checklistItemId);
        existingItem.setStatus(checklistItem.getStatus());
        checklistItemRepository.save(existingItem);
    }


    public void deleteChecklistItem(Long checklistId, Long checklistItemId) {
        checklistItemRepository.deleteById(checklistItemId);
    }

    // 6. Mengganti nama checklist item
    public void renameChecklistItem(Long checklistId, Long checklistItemId, ChecklistItem checklistItem) {
        ChecklistItem existingItem = getChecklistItem(checklistId, checklistItemId);
        existingItem.setName(checklistItem.getName());
        checklistItemRepository.save(existingItem);
    }
}

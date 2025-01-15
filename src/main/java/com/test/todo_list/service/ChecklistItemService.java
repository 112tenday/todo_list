package com.test.todo_list.service;


import com.test.todo_list.model.ChecklistItem;
import com.test.todo_list.repository.ChecklistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistItemService {

    @Autowired
    private ChecklistItemRepository checklistItemRepository;

    public List<ChecklistItem> getItemsByChecklistId(Long checklistId) {
        return checklistItemRepository.findAll();
    }

    public ChecklistItem createItem(Long checklistId, ChecklistItem item) {

        return checklistItemRepository.save(item);
    }

    public void deleteItem(Long checklistId, Long itemId) {
        checklistItemRepository.deleteById(itemId);
    }
}

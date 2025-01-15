package com.test.todo_list.repository;

import com.test.todo_list.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, Long> {
    List<ChecklistItem> findByChecklistId(Long checklistId);

    ChecklistItem findByIdAndChecklistId(Long checklistItemId, Long checklistId);
}

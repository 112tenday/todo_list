package com.test.todo_list.service;

import com.test.todo_list.model.Checklist;
import com.test.todo_list.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;


    public Checklist getChecklistById(Long id) {
        return checklistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Checklist not found"));
    }

    public Checklist createChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.deleteById(id);
    }
}

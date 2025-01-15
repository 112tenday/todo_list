package com.test.todo_list.service;

import com.test.todo_list.model.Checklist;
import com.test.todo_list.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public Checklist createChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public void deleteChecklist(Long checklistId) {
        checklistRepository.deleteById(checklistId);
    }
}


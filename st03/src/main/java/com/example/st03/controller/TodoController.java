package com.example.st03.controller;

import com.example.st03.domain.Todo;
import com.example.st03.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {
    private final TodoService todoService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getTodos() {
        List<Todo> todoLists = todoService.getTodos();

        return ResponseEntity.ok(todoLists);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getTodo(@PathVariable(name = "id") Long id) {
        Todo todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertTodo(@RequestBody Todo todo) {
        todoService.insertTodo(todo.getId(), todo.getTitle(), todo.getContent());
        return ResponseEntity.ok(null);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable(name = "id") Long id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo.getTitle(), todo.getContent());
        return ResponseEntity.ok(null);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(null);
    }
}

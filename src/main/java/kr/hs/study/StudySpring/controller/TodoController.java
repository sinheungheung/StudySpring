package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.domain.Todo;
import kr.hs.study.StudySpring.order.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todolist")
public class TodoController {
    private final TodoService todoService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getTodo() {
        List<Todo> todoList = todoService.getTodo();

        Todo todoList1 = new Todo();
        Todo todoList2 = new Todo();

        return ResponseEntity.ok(todoList);
    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getTodo(@PathVariable(name = "id") Long id) {
        Todo todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertTodo(@RequestBody Todo params) {
        todoService.insertTodo(params.getId(), params.getName(), params.getTitle(), params.getContents());
        return ResponseEntity.ok(null);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable(name = "id") Long id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo.getName(), todo.getTitle(), todo.getContents());
        return ResponseEntity.ok(null);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(null);
    }
}

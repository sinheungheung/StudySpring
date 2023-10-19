package com.example.st03.service;

import com.example.st03.domain.Todo;

import java.util.List;

public interface TodoService {

    // 목록
    List<Todo> getTodos();

    // 상세
    Todo getTodo(Long id);

    // 추가
    void insertTodo(Long id, String title, String content);

    // 수정
    void updateTodo(Long id, String title, String content);

    // 삭제
    void deleteTodo(Long id);
}

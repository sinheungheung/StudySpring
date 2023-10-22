package com.example.st03.service;

import com.example.st03.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> getTodos() {
        List<Todo> list = todos;
        return list;
    }

    @Override
    public Todo getTodo(Long id) {
        Todo todo = new Todo();

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todo = todos.get(i);
            }
        }
        return todo;
    }

    @Override
    public void insertTodo(Long id, String title, String content) {
        Todo newTodo = new Todo(id, title, content);
        todos.add(newTodo);
    }

    @Override
    public void updateTodo(Long id, String title, String content) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todos.get(i).setTitle(title);
                todos.get(i).setContent(content);
            }
        }
    }

    @Override
    public void deleteTodo(Long id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todos.remove(todos.get(i));
            }
        }
    }
}


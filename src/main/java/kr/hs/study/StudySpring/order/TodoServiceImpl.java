package kr.hs.study.StudySpring.order;

import kr.hs.study.StudySpring.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final List<Todo> todoList = new ArrayList<>();

    // 목록
    @Override
    public List<Todo> getTodo() {
        List<Todo> listTodo = todoList;
        return listTodo;
    }

    // 상세
    @Override
    public Todo getTodo(Long id) {
        Todo todo = new Todo();

        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todo = todoList.get(i);
            }
        }
        return todo;
    }

    // 추가
    public void insertTodo(Long id, String name, String title, String contents) {
        Todo todo = new Todo(id, name, title, contents);

        todoList.add(todo);
    }

    // 수정
    public void updateTodo(Long id, String name, String title, String contents) {
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todoList.get(i).setName(name);
                todoList.get(i).setTitle(title);
                todoList.get(i).setContents(contents);
            }
        }
    }

    // 삭제
    @Override
    public void deleteTodo(Long id) {
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todoList.remove(todoList.get(i));
            }

        }
    }

    public List<Todo> todoDb() {
        List<Todo> todo = new ArrayList<>();

        Todo todoList1 = new Todo(1L, "김신흥", "스프링", "목록, 상세, 추가, 수정, 삭제");
        todo.add(todoList1);
        return todo;
    }
}


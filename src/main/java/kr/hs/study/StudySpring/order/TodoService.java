package kr.hs.study.StudySpring.order;

import kr.hs.study.StudySpring.domain.Todo;

import java.util.List;

public interface TodoService {

    // 목록
    List<Todo> getTodo();

    // 상세
    Todo getTodo(Long id);

    // 추가
    void insertTodo(Long id, String name, String title, String contents);

    // 수정
    void updateTodo(Long id, String name, String title, String contents);

    // 삭제
    void deleteTodo(Long id);
}

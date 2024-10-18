package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testShowTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Belajar java");
        todoListRepository.data[1] = new Todolist("Belajar java 1");
        todoListRepository.data[2] = new Todolist("Belajar java 2");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();

    }
}

package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar java 1");
        todoListService.addTodoList("Belajar java 2");
        todoListService.addTodoList("Belajar java 3");

        todoListView.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListService.showTodoList();
    }
    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar java 1");
        todoListService.addTodoList("Belajar java 2");
        todoListService.addTodoList("Belajar java 3");

        todoListView.showTodoList();

        todoListView.removeTodoList();

        todoListView.removeTodoList();
    }
}

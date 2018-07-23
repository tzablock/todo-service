package com.todoservice.rest.controller;

import com.todoservice.bean.ToDoBean;
import com.todoservice.rest.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@Slf4j
public class TodoController {
    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<ToDoBean> getTodos(){
        log.info("Take all Todos");
        //TODO take all todos from db
        return Arrays.asList(ToDoBean.builder().taskOrder(1).taskName("ddd").taskDescription("desc").build());
    }

    @PostMapping("/file/asignTodo")
    public void assignTodoIntoFile(@RequestParam("filename") String fileName, @RequestParam("todoId") String todoId){
        log.info("Assign todo with id %s into file %s", todoId, fileName);
        //TODO add assign todo into file in db
    }

    @GetMapping("/file/todos")
    public ByteArrayResource getTodosFile(@RequestParam("filename") String fileName) {
        //TODO create file with such name if have records in db, and remove old if more than x if not return that file is empty .createFile()
        return service.getToDosFile(fileName);
    }
    @PostMapping("/add/todo")
    public void addTodo(@RequestBody ToDoBean bean){
        log.info(String.format("Bean %s %s %s",bean.getTaskOrder(),bean.getTaskName(),bean.getTaskDescription()));
        //TODO add noSQL db
    }
    @PostMapping("/file/createDodoFile")
    public void createToDoFile(@RequestBody List<ToDoBean> beans, @RequestBody String fileName){
        Stream<ToDoBean> sortBeans = beans.stream().sorted(Comparator.comparing(ToDoBean::getTaskOrder));
        log.info(String.format("Create file %s from todos %s", fileName, sortBeans.map(
                                                                                      b -> b.getTaskOrder()+" "+b.getTaskName()+" "+b.getTaskDescription()
                                                                              ).reduce(
                                                                                      (acc,t) -> acc+t
                                                                              )));
        //TODO add todo beans with filename to db
    }
}

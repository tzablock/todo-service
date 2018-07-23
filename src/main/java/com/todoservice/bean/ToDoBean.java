package com.todoservice.bean;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ToDoBean {
    private int taskOrder;
    private long taskId;
    private String taskName;
    private String taskDescription;
}

package com.todoservice.properties;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TodoServicePropertiesTest {

    @Test
    public void todoFilesPathShouldReturnDirectoryOfKeptFileWithTODOs() {
        TodoServiceProperties out = new TodoServiceProperties();
        String p = out.todoFilesPath();

        assertThat(p).isNotNull();
        assertThat(p).isNotEmpty();
    }
}
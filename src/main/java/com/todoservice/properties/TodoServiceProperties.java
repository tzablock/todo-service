package com.todoservice.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Slf4j
public class TodoServiceProperties {
    private Properties p;

    public TodoServiceProperties() {
        try {
            this.p = new Properties();
            p.load(Files.newInputStream(Paths.get(TodoServiceProperties.class.getResource("/todoservice.properties").toURI())));
        } catch (IOException | URISyntaxException e) {
            log.error(e.getMessage(),e);
        }
    }

    public String todoFilesPath(){
        return p.getProperty("todo.files.path");
    }
}

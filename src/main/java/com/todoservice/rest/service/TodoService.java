package com.todoservice.rest.service;

import com.todoservice.properties.TodoServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class TodoService {
    public ByteArrayResource getToDosFile(String fileName){
        TodoServiceProperties p =  new TodoServiceProperties();
        String sfp = p.todoFilesPath() + fileName;
        log.info("Get file from %s",sfp);
        Path fp = Paths.get(sfp);
        try {
            return new ByteArrayResource(Files.readAllBytes(fp));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}

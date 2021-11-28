package com.example.project_timetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class TaskListTest {

    @Test
    void setNum() throws Exception{
        assertTimeout(ofSeconds(5000), () -> {
            TaskList.setNum("1");
        });
    }

    @Test
    void addTask() throws Exception {
        assertTimeout(ofSeconds(5000), () -> {
            TaskList.addTask();
        });
    }
}
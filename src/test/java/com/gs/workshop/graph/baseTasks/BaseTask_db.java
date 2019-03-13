package com.gs.workshop.graph.baseTasks;

import org.junit.Ignore;
import org.junit.Test;
import com.gs.workshop.graph.BaseTest;

public class BaseTask_db extends BaseTest {

    /**
     * Starts an in-memory instance of Neo4j
     */
    @Test
    @Ignore
    public void runDatabase() {
        testNeo(session -> System.out.println("Instance started"));

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

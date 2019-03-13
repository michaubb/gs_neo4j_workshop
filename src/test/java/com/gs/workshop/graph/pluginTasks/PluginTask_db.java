package com.gs.workshop.graph.pluginTasks;

import org.junit.Ignore;
import org.junit.Test;
import com.gs.workshop.graph.PluginTest;

public class PluginTask_db extends PluginTest {

    /**
     * Starts an in-memory instance of Neo4j
     */
    @Test
    @Ignore
    public void test() {
        testNeo(session -> System.out.println("Instance started"));

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.gs.workshop.graph.pluginTasks;

import org.junit.Assert;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;
import com.gs.workshop.graph.PluginTest;

public class PluginTask_exercises extends PluginTest {
    @Test
    public void testSimpleReadProcedure() {
        testNeo(session -> {
            // TODO
            String selectQuery = null;

            StatementResult result = session.run(selectQuery);

            Assert.assertEquals(1956l, result.single().get(0).asLong());
            // Assert.assertEquals(1956l, result.single().get("born").asLong());

        });
    }

    @Test
    public void testSimpleWriteProcedure() {
        testNeo(session -> {
            String updateQuery = null;

            StatementResult result = session.run(updateQuery);

            String selectQuery = null;
            result = session.run(selectQuery);

            Assert.assertEquals(2008l, result.single().get(0).asLong());
            // Assert.assertEquals(2008l, result.single().get("born").asLong());

        });
    }

}

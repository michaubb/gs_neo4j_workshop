package com.gs.workshop.graph.baseTasks;

import com.gs.workshop.graph.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;

import java.util.HashMap;
import java.util.Map;

public class BaseTask_exercises extends BaseTest {

    /**
     * Query for Tom Hanks birth year
     */
    @Test
    public void testWithoutParameters() {
        testNeo(session -> {
            // TODO
            String query = null;

            StatementResult result = session.run(query);

            Assert.assertEquals(1956, result.single().get(0).asInt());
            // Assert.assertEquals(1956, result.single().get("born").asInt());

        });
    }

    /**
     * Query for Tom Hanks birth year using parameters
     */
    @Test
    public void testWithParameters() {
        testNeo(session -> {
            // TODO
            String query = null;


            Map<String, Object> parameters = new HashMap();
            parameters.put("name", "Tom Hanks");

            StatementResult result = session.run(query, parameters);

            Assert.assertEquals(1956, result.single().get(0).asInt());
            // Assert.assertEquals(1956, result.single().get("born").asInt());

        });
    }

}

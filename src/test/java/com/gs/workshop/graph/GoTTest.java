package com.gs.workshop.graph;

import com.gs.workshop.graph.commons.CypherResourceLoader;
import com.gs.workshop.graph.plugins.SimplePlugin;
import org.junit.Rule;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.util.Consumer;
import org.neo4j.harness.junit.Neo4jRule;

public class GoTTest {

    @Rule
    public Neo4jRule neo4jRule = new Neo4jRule()
            .withProcedure(SimplePlugin.class)
            .withProcedure(apoc.load.LoadJson.class)
            .withProcedure(apoc.convert.Convert.class)
            .withProcedure(apoc.map.Maps.class)
            .withFunction(apoc.load.LoadJson.class)
            .withFunction(apoc.convert.Convert.class)
            .withFunction(apoc.map.Maps.class);

    public void testNeo(Consumer<Session> consumer) {
        System.out.println(neo4jRule.httpURI().toString());

        Session session = new CypherExecutor(neo4jRule.boltURI().toString()).obtainSession();


        long currentMillis = System.currentTimeMillis();
        consumer.accept(session);

        System.out.println(
                "Operation took " + (System.currentTimeMillis() - currentMillis) / 1000.0 + " s");
    }
}

package com.gs.workshop.graph;

import com.gs.workshop.graph.commons.CypherResourceLoader;
import org.junit.Rule;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.util.Consumer;
import org.neo4j.harness.junit.Neo4jRule;

public class BaseTest {

    @Rule
    public Neo4jRule neo4jRule = new Neo4jRule();

    public void testNeo(Consumer<Session> consumer) {
        System.out.println(neo4jRule.httpURI().toString());

        Session session = new CypherExecutor(neo4jRule.boltURI().toString()).obtainSession();

        session.run(
                CypherResourceLoader.loadResourceAsString(BaseTest.class, "init")
        );

        long currentMillis = System.currentTimeMillis();
        consumer.accept(session);

        System.out.println(
                "Operation took " + (System.currentTimeMillis() - currentMillis) / 1000.0 + " s");
    }
}

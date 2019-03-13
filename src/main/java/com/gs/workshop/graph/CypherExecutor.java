package com.gs.workshop.graph;

import org.neo4j.driver.v1.*;

import java.util.Map;

public class CypherExecutor {

    private Driver driver;

    public CypherExecutor(String boltUri) {
        driver = GraphDatabase.driver( boltUri, AuthTokens.none());
    }

    public Session obtainSession() {
        return driver.session();
    }

    public StatementResult execute(String query) {
        return execute(query, null);
    }

    public StatementResult execute(String query, Map<String, Object> params) {
        return obtainSession().run(query, params);
    }
}

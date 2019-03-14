package com.gs.workshop.graph.got;

import com.gs.workshop.graph.GoTTest;
import com.gs.workshop.graph.PluginTest;
import com.gs.workshop.graph.commons.CypherResourceLoader;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.driver.v1.Session;

/**
 * Created by milenaluszczyk on 14/03/2019.
 */
public class GoT_db extends GoTTest {

    @Test
    @Ignore
    public void runDb() {
        testNeo(session -> {
            run(session,
                    "got/1",
                    "got/2",
                    "got/3",
                    "got/4",
                    "got/5",
                    "got/6",
                    "got/7",
                    "got/8"

            );
        });

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void run(Session session,
                     String... files
                     ) {
        for (String file : files) {
            System.out.println("running file " + file);
            session.run(CypherResourceLoader.loadResourceAsString(PluginTest.class, file));
        }
    }
}

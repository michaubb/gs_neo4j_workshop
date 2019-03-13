package com.gs.workshop.graph.commons;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class CypherResourceLoader {
    public static String loadResourceAsString(Class clazz, String name) {
        try {
            return IOUtils.toString(
                    clazz.getResourceAsStream(name + ".cql"),
                    "UTF-8"
            );

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

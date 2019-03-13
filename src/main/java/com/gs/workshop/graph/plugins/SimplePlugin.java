package com.gs.workshop.graph.plugins;

import com.gs.workshop.graph.plugins.containers.BirthYearContainer;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.logging.Log;
import org.neo4j.procedure.Context;
import org.neo4j.procedure.Mode;
import org.neo4j.procedure.Name;
import org.neo4j.procedure.Procedure;

import java.util.stream.Stream;

public class SimplePlugin {
    @Context
    public GraphDatabaseService db;

    @Context
    public Log log;


    @Procedure(name = "workshop.getPersonBirthYear", mode = Mode.READ)
    public Stream<BirthYearContainer> getBirthYear(
            @Name("name") String name) {

        return Stream.empty();
    }


    @Procedure(name = "workshop.updatePersonBirthYear", mode = Mode.WRITE)
    public Stream<BirthYearContainer> updateBirthYear(
            @Name("name") String name,
            @Name("year") Long year) {

        return Stream.empty();
    }

}

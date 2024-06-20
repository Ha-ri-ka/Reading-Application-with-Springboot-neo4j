package reading.readingtracker.author;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends Neo4jRepository <Author,Long>
{
    //return all authors
    @Query("MATCH (n:AUTHOR) RETURN n")
    List<Author> findAll();

    // find author by name
    @Query("MATCH (auth:AUTHOR) WHERE auth.name = $name RETURN auth")
    Optional<Author> findByName(String name);

    //create author
    @Query("CREATE (a:AUTHOR {id: $id,name: $name})")
    void save(Integer id,String name);

    //update author details
    @Query("MATCH (a:AUTHOR {name: $name}) SET a.name = $newName")
    void update(String name,String newName);

    //delete author by name
    @Query("MATCH (n:AUTHOR {name: $name}) DETACH DELETE n")
    void deleteByName(String name);

    //delete all relationships of author
    @Query("MATCH (n:AUTHOR)-[rel]->() DELETE rel")
    void deleteRelationships(String name);
}

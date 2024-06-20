package reading.readingtracker.person;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import reading.readingtracker.book.Book;

import java.util.Set;

@Node("PERSON")
public record Person(
        @Id Long id,
        String name,
        @Relationship(type = "READ",direction = Relationship.Direction.OUTGOING)Set <Book> books
        ) {
}

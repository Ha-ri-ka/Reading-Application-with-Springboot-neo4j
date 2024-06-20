package reading.readingtracker.book;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import reading.readingtracker.author.Author;
import reading.readingtracker.person.Person;

import java.util.Set;

@Node("BOOK")
public record Book(
        @Id Long id,
        String title,
        @Relationship(type = "WRITTEN_BY",direction = Relationship.Direction.OUTGOING)Set <Author> authors,
        @Relationship(type = "READ_BY",direction = Relationship.Direction.OUTGOING)Set <Person> readers
        ) {

}

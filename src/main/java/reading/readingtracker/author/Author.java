package reading.readingtracker.author;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import reading.readingtracker.book.Book;

import java.util.Set;

@Node("AUTHOR")
public record Author(
        @Id Long id,
        String name,
//        @Relationship(type="WRITTEN_BY",direction = Relationship.Direction.INCOMING)Set<Book> booksWitten,
        @Relationship(type="WROTE",direction = Relationship.Direction.OUTGOING)Set<Book> booksWrote
    )
{ }

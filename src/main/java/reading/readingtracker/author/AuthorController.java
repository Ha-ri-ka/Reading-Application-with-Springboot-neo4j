package reading.readingtracker.author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reading.readingtracker.relationships.WroteRelationship;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //find all
    @GetMapping("")
    public List<Author> findAll()
    {
        return authorService.findAll();
    }

    //find by name
    @GetMapping("/find")
    public Author findByName(@RequestParam String name) {
        return authorService.findByName(name);
    }

    //create author
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }

    //create relationship
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-relationship")
    public void createRelationship(@RequestBody WroteRelationship relationship)
    {
        authorService.createRelationship(relationship.authorName(),relationship.bookName());
    }


    //update author name
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{name}")
    public void update(@PathVariable String name, @RequestBody Map<String, String> updateRequest)
    {
        String newName = updateRequest.get("newName");
        authorService.update(name, newName);
    }

    //delete by name
    @DeleteMapping("/deleteAuthor")
    public void deleteByName(@RequestParam String name)
    {
        authorService.deleteByName(name);
    }

    //delete all relationships of an author
    @DeleteMapping("/deleteRelations")
    public void deleteRelationships(@RequestParam String name)
    {
        authorService.deleteRelationships(name);
    }
}

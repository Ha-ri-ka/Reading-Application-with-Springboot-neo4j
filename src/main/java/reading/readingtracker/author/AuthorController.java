package reading.readingtracker.author;

import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    //update author details

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

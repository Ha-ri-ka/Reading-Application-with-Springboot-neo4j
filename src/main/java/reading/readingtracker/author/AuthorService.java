package reading.readingtracker.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    //find all
    public List<Author> findAll()
    {
        return authorRepo.findAll();
    }

    //find by name
    public Author findByName(String name)
    {
        Optional<Author> auth = authorRepo.findByName(name);
        return auth.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }

    //create author
    public void create(Author author)
    {
        authorRepo.save(author);
    }

    //update author details
    public void update(String name,String newName)
    {
        authorRepo.update(name,newName);
    }

    //delete by name
    public void deleteByName(String name)
    {
        authorRepo.deleteByName(name);
    }

    public void deleteRelationships(String name)
    {
        authorRepo.deleteRelationships(name);
    }

}

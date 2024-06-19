package reading.readingtracker.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reading.readingtracker.book.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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


    //update author details

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

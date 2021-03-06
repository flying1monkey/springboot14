package com.example.springboot14.controllers;

import com.example.springboot14.models.Director;
import com.example.springboot14.models.Movie;
import com.example.springboot14.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController
{
    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model)
    {
        //Create a director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        //create a movie
        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars...");

        //add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie=new Movie();
        movie.setTitle("DeathStar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on the DeathStar...");
        movies.add(movie);

        //Add the list of movies to the director's movie list
        director.setMovies(movies);

        //Save the director to the database
        directorRepository.save(director);

        //Grab all the directors from the database and send them to the template
        model.addAttribute("directors", directorRepository.findAll());
        return "index";

    }
    @GetMapping("/addmovie")
    public String addMovie(Model model)
    {
        model.addAttribute("newmovie", new Movie());
        return "addmovie";
    }

    @PostMapping("/addmovie")
    public String submitMovie()
    {
        return "index";
    }
}

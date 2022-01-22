package com.example.bootcampspringsecondproject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Getter
@Setter
@NoArgsConstructor
public class MovieController {
    private List<Movie> movieList = new ArrayList<>();

    @ApiOperation(value = "Add a movie", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Movie is successfully created")
    })
    @PostMapping(value = "/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMovie(@RequestBody Movie movie) { //Adds given movie object to movieList.
        movieList.add(Movie.builder()
                .movieName(movie.getMovieName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .actorList(movie.getActorList())
                .build());
        return "Movie " + movie.getMovieName() + " is added.";
    }

    @ApiOperation(value = "Get a movie", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie is successfully retrieved")
    })
    @GetMapping(value = "/movies/{movieName}")
    public Movie getMovie(@PathVariable String movieName) { //Gets movie object according to given movie name.
        Movie movieObject = movieList.stream()
                .filter(o -> o.getMovieName().equals(movieName))
                .findFirst().get();
        return movieObject;
    }

    @ApiOperation(value = "Delete a movie", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Movie is successfully deleted")
    })
    @DeleteMapping(value = "/movies/{movieName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable String movieName) { //Deletes movie according to given movie name.
        movieList.removeIf(o -> o.equals(movieName));
    }

}

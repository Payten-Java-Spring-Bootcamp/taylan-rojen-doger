package com.example.bootcampweekthree.controller.movie;

import com.example.bootcampweekthree.controller.movie.request.MovieRequest;
import com.example.bootcampweekthree.controller.movie.response.MovieCreateResponse;
import com.example.bootcampweekthree.controller.movie.response.MovieResponse;
import com.example.bootcampweekthree.service.movie.Movie;
import com.example.bootcampweekthree.service.movie.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @ApiOperation(value = "Add a movie", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Movie is successfully created")
    })
    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreateResponse createMovie(@RequestBody @Valid MovieRequest movieRequest) {
        Movie movie = movieRequest.convertMovie();
        Integer id = movieService.create(movie);
        return MovieCreateResponse.convertToMovieResponse(id);
    }

    @ApiOperation(value = "Get movie", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie is successfully retrieved")
    })
    @GetMapping("/movies/{id}")
    public MovieResponse retrieve(@PathVariable Integer id) {
        Movie movie = movieService.retrieve(id);
        return MovieResponse.convertFrom(movie);
    }

}

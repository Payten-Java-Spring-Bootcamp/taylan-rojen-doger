package com.example.bootcampspringsecondproject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MemberController {
    private List<Member> memberList = new ArrayList<>();
    private Map<String, Integer> rateMoviesList = new HashMap<>();
    private Map<Member, List<String>> watchList = new HashMap<>();
    private List<String> movieNames = new ArrayList<>();
    private final MovieController movieController;

    public MemberController(MovieController movieController) {
        this.movieController = movieController;
    }

    @ApiOperation(value = "Add a member", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Member is successfully created")
    })
    @PostMapping(value = "/members/{memberId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMember(Member member,
                               @PathVariable Integer memberId) { //Adds member according to given ID.
        memberList.add(Member.builder()
                .memberId(member.getMemberId())
                .build());
        return "Member with ID number " + member.getMemberId() + " is added.";
    }

    @ApiOperation(value = "Give a point to a movie.", response = Iterable.class)
    @PostMapping(value = "/members/{memberId}/{movieName}/{point}")
    public String rateMovies(@PathVariable Integer memberId,
                             @PathVariable String movieName,
                             @PathVariable Integer point) { //Rates movies according to given ID, point and movie name.
        Member member = getMemberId(memberId);
        Movie movie = getMovie(movieName);
        rateMoviesList.put(movie.getMovieName(), point);
        return "Member ID with " + member.getMemberId()
                + " gives " + rateMoviesList.get(movie.getMovieName())
                + " points to " + movie.getMovieName() + " movie.";
    }

    @ApiOperation(value = "Create watch list", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Watch list is successfully created")
    })
    @PostMapping(value = "/members/{memberId}/{movieName}")
    public String createWatchList(@PathVariable Integer memberId,
                                @PathVariable String movieName) {//Adds movie to given watch list.
        Member member = getMemberId(memberId);
        Movie movie = getMovie(movieName);
        List<String> movieNameList = new ArrayList<>();
        movieNameList.add(movie.getMovieName());
        watchList.put(member, movieNameList);
        String memberMovieName = String.valueOf(watchList.get(member));
        addMovieToWatchList(memberMovieName);
        return "Movie " + movieName + " is added to watch list.";
    }

    public void addMovieToWatchList(String movieName) {
        movieNames.add(movieName);
    }

    @ApiOperation(value = "Get watch list", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Watch list is successfully retrieved")
    })
    @GetMapping(value = "/members/{memberId}/{myWatchList}")
    public List<String> getWatchList(@PathVariable Integer memberId,
                                     @PathVariable String myWatchList) {
        return movieNames;
    }

    public Member getMemberId(Integer memberId) {
        return memberList.stream()
                .filter(o -> o.getMemberId() == memberId)
                .findFirst().get();
    }

    public Movie getMovie(String movieName) {
        List<Movie> fetchedMovieList = movieController.getMovieList();
        return fetchedMovieList.stream()
                .filter(o -> o.getMovieName().equals(movieName))
                .findFirst().get();
    }
}

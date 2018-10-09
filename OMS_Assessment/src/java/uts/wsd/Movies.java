/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zexin Zhong
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movies")
public class Movies implements Serializable {

    @XmlElement(name = "movie")
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    /**
     * This is the getter of the movies field
     * @return movies
     */
    public ArrayList<Movie> getMovies() {

        return movies;
    }

    /**
     * This method will return movie that match the given movies title 
     * @param title the query movie title 
     * @return return the match movie otherwise return null
     */
    public Movie getMovie(String title) {
        for (Movie movie : movies) {
            if (movie.matchTitle(title)) {
                return movie;
            }
        }
        return null;
    }
    
    /**
     * This method will add the specified movie to the movies list.
     * @param movie the given movie 
     */
    public void addMovie(Movie movie) {

        movies.add(movie);
    }

    /**
     * This method will remove the specified movie from the movies list.
     * @param movie the given movie 
     */
    public void removeMovie(Movie movie) {

        movies.remove(movie);
    }

    /**
     * This method will query the movie according to the movie title.
     * @param title the query movies title 
     * @return all match movies 
     */
    public ArrayList<Movie> getMoviesByTitile(String title) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the movie genre.
     * @param genre the query movie genre
     * @return all match movies 
     */
    public ArrayList<Movie> getMoviesByGenre(String genre) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_genre().equals(genre)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the release date range.
     * @param startYear the searching start year 
     * @param endYear the query end year 
     * @return all matches movies
     * @throws ParseException 
     */
    public ArrayList<Movie> getMoviesByYears(String startYear, String endYear) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date sYear = formatter.parse(startYear);
        Date eYear = formatter.parse(endYear);
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            Date movieRYear = formatter.parse(movie.getMovie_release_date());
            if ((movieRYear.after(sYear) || movieRYear.equals(sYear))
                    && (movieRYear.before(eYear) || movieRYear.equals(eYear))) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the movie title and genre.
     * @param title the query movie title 
     * @param genre the query movie genre
     * @return all match movies 
     */
    public ArrayList<Movie> getMoviesByTG(String title, String genre) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title) && movie.getMovie_genre().equals(genre)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the movie title and date range.
     * @param title the query movie title 
     * @param startYear the start searching year 
     * @param endYear the end searching year
     * @return all match movies 
     * @throws ParseException 
     */
    public ArrayList<Movie> getMoviesByTD(String title, String startYear, String endYear) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date sYear = formatter.parse(startYear);
        Date eYear = formatter.parse(endYear);
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            Date movieRYear = formatter.parse(movie.getMovie_release_date());
            if ((movieRYear.after(sYear) || movieRYear.equals(sYear))
                    && (movieRYear.before(eYear) || movieRYear.equals(eYear))
                    && movie.getMovie_title().equals(title)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the movie genre and date range.
     * @param genre the query movie genre
     * @param startYear the start searching year 
     * @param endYear the end searching year
     * @return all match movies 
     * @throws ParseException 
     */
    public ArrayList<Movie> getMoviesByGD(String genre, String startYear, String endYear) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date sYear = formatter.parse(startYear);
        Date eYear = formatter.parse(endYear);
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            Date movieRYear = formatter.parse(movie.getMovie_release_date());
            if ((movieRYear.after(sYear) || movieRYear.equals(sYear))
                    && (movieRYear.before(eYear) || movieRYear.equals(eYear))
                    && movie.getMovie_genre().equals(genre)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will query the movie according to the movie title, movie genre and date range.
     * @param title the query movie tile 
     * @param genre the query movie genre 
     * @param startYear the query start searching year
     * @param endYear the query end searching year
     * @return all match movies
     * @throws ParseException 
     */
    public ArrayList<Movie> getMoviesByTGD(String title, String genre, String startYear, String endYear) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date sYear = formatter.parse(startYear);
        Date eYear = formatter.parse(endYear);
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            Date movieRYear = formatter.parse(movie.getMovie_release_date());
            if ((movieRYear.after(sYear) || movieRYear.equals(sYear))
                    && (movieRYear.before(eYear) || movieRYear.equals(eYear))
                    && movie.getMovie_genre().equals(genre)
                    && movie.getMovie_title().equals(title)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    /**
     * This method will search and return all match movie according to the query information
     * @param title the query movie title 
     * @param genre the query movie genre
     * @param startYear the query start year 
     * @param endYear the query end year
     * @return all match movies
     * @throws ParseException 
     */
    public ArrayList<Movie> searchMovies(String title, String genre, String startYear, String endYear) throws ParseException {
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        if (title.equals("") && genre.equals("") && startYear.equals("") && endYear.equals("")) {
            matchesMovies = getMovies();
        } else if (!title.equals("") && genre.equals("") && startYear.equals("") && endYear.equals("")) {
            matchesMovies = getMoviesByTitile(title);
        } else if (title.equals("") && !genre.equals("") && startYear.equals("") && endYear.equals("")) {
            matchesMovies = getMoviesByGenre(genre);
        } else if (title.equals("") && genre.equals("") && !startYear.equals("") && !endYear.equals("")) {
            matchesMovies = getMoviesByYears(startYear, endYear);
        } else if (!title.equals("") && !genre.equals("") && startYear.equals("") && endYear.equals("")) {
            matchesMovies = getMoviesByTG(title, genre);
        } else if (!title.equals("") && genre.equals("") && !startYear.equals("") && !endYear.equals("")) {
            matchesMovies = getMoviesByTD(title, startYear, endYear);
        } else if (title.equals("") && !genre.equals("") && !startYear.equals("") && !endYear.equals("")) {
            matchesMovies = getMoviesByGD(genre, startYear, endYear);
        } else if (!title.equals("") && !genre.equals("") && !startYear.equals("") && !endYear.equals("")) {
            matchesMovies = getMoviesByTGD(title, genre, startYear, endYear);
        }
        return matchesMovies;
    }

    /**
     * This method will add the given copies to the available copies
     *
     * @param title the given movie title
     * @param copies the number of copies that wish to add to the current
     * available copies
     */
    public void addCopies(String title, int copies) {
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                movie.addCopies(copies);
            }
        }
    }

    /**
     * This method will remove minus the given copies form available copies.
     *
     * @param title the given movie title
     * @param copies the number of copies that wish to remove from the current
     * available copies
     */
    public void minusCopies(String title, int copies) {
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                movie.minusCopies(copies);
            }
        }
    }

    /**
     * This method will return movie match with the given movie title.
     *
     * @param title query movie title
     * @return movie that match with the given title, otherwise, return null
     */
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                return movie;
            }
        }
        return null;
    }

//    public void print(ArrayList<Movie> list, Writer sout) {
//        PrintWriter out = new PrintWriter(sout);
//        out.print("<table align=\"center\">");
//        out.print("\n<thead><th>Movie Titlre</th><th>Genre</th><th>Release Date</th><th>Price</th><th>Available Copies</th></thead>");
//        list.stream().map((movie) -> {
//            out.println("<tr > ");
//            out.println("<td>" + movie.getMovie_title() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_genre() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_release_date() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_price() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getAvailable_copies() + "</td>");
//            return movie;
//        }).forEach((_item) -> {
//            out.println("</tr>");
//        });
//        out.print("</table>");
//    }
//
//    public void printMovies(ArrayList<Movie> list, Writer sout) {
//
//        PrintWriter out = new PrintWriter(sout);
//
//        out.print("<table align=\"center\">");
//        out.print("\n<thead><th>Movie Title</th><th>Genre</th><th>Release Date</th><th>Price</th><th>Available Copies</th></thead>");
//
//        list.stream().map((movie) -> {
//            String href = movie.checkAvailable() ? "<a class=\"link\" href=\"checkOut.jsp?movieSelect=" + movie.getMovie_title() + "\" >" + movie.getMovie_title() + "</a>" : movie.getMovie_title();
//            out.println("<tr > ");
//            out.println("<td>" + href + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_genre() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_release_date() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getMovie_price() + "</td>");
//            return movie;
//        }).map((movie) -> {
//            out.println("<td >" + movie.getAvailable_copies() + "</td>");
//            return movie;
//        }).forEach((_item) -> {
//            out.println("</tr>");
//        });
//        out.print("</table>");
//    }
}

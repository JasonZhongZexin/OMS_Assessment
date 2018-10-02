/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

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
public class Movies {

    @XmlElement(name = "movie")
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public ArrayList<Movie> getMovies() {

        return movies;
    }

    public Movie getMovie(String title) {
        for (Movie movie : movies) {
            if (movie.matchTitle(title)) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(Movie movie) {

        movies.add(movie);
    }

    public void removeMovie(Movie movie) {

        movies.remove(movie);
    }

    public ArrayList<Movie> getMoviesByTitile(String title) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

    public ArrayList<Movie> getMoviesByGenre(String genre) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_genre().equals(genre)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

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

    public ArrayList<Movie> getMoviesByTG(String title, String genre) {

        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title) && movie.getMovie_genre().equals(genre)) {
                matchesMovies.add(movie);
            }
        }
        return matchesMovies;
    }

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

    public void addCopies(String title, int copies) {
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                movie.addCopies(copies);
            }
        }
    }

    public void minusCopies(String title, int copies) {
        for (Movie movie : movies) {
            if (movie.getMovie_title().equals(title)) {
                movie.minusCopies(copies);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zexin Zhong
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="movies")
public class Movies {
    
    @XmlElement(name="movie")
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    
    public ArrayList<Movie> getMovies(){
        
        return this.movies;
    }
    
    public void addMovie(Movie movie){
        
        movies.add(movie);
    }
    
    public void removeMovie(Movie movie){
        
        movies.remove(movie);
    }
    
    public ArrayList<Movie> getMoviesByTitile(String title){
        
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for(Movie movie:movies){
            if(movie.getMovie_title().equals(title))
                matchesMovies.add(movie);
        }
        return matchesMovies;
    }
    
       public ArrayList<Movie> searchTG(String title, String genre){
        
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for(Movie movie:movies){
            if(movie.getMovie_title().equals(title) && )
                matchesMovies.add(movie);
        }
        return matchesMovies;
    }
    public ArrayList<Movie> getMoviesByGenre(String genre){
    
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for(Movie movie:movies){
            if(movie.getMovie_genre().equals(genre))
                matchesMovies.add(movie);
        }
        return matchesMovies;
    }
    
    public ArrayList<Movie> getMoviesByGenre(){
        
        ArrayList<Movie> matchesMovies = new ArrayList<Movie>();
        for(Movie movie:movies){
            
        }
        return matchesMovies;
    }
}

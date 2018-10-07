/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import uts.wsd.Movie;
import uts.wsd.Movies;

/**
 *
 * @author User
 */
public interface MoviesApplicationDAO {
     public void updateXML(String filePath, Movies movies) throws JAXBException, FileNotFoundException, IOException;
     public void saveMovies() throws JAXBException, FileNotFoundException, IOException;
      public ArrayList<Movie> searchMovie(String title, String genre, String startYear, String endYear) throws ParseException;
      public void addCopies(String title,int copies);
      public void minusCopies(String title,int copies);
      public Movie getMovieByTitle(String title);
}

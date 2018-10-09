/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Zexin Zhong
 */
public class MoviesApplication implements Serializable {

    private String filePath;
    private Movies movies;

    public MoviesApplication() {
    }

    public MoviesApplication(String filePath, Movies movies) {
        super();
        this.filePath = filePath;
        this.movies = movies;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws JAXBException, FileNotFoundException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Unmarshaller u = jc.createUnmarshaller();
        this.filePath = filePath;
        FileInputStream fin = new FileInputStream(filePath);
        movies = (Movies) u.unmarshal(fin);
        fin.close();
    }

    /**
     * This method will update the movie XML
     * @param filePath
     * @param movies
     * @throws JAXBException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void updateXML(String filePath, Movies movies) throws JAXBException, FileNotFoundException, IOException {
        this.movies = movies;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(movies, fout);
        fout.close();
    }

    /**
     * This method will save the movies field and update the movies XML
     * @throws JAXBException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveMovies() throws JAXBException, FileNotFoundException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(movies, fout);
        fout.close();
    }

    /**
     * This is the getter of the movies field
     * @return 
     */
    public Movies getMovies() {
        return this.movies;
    }

    /**
     * This is the setter of the movies field 
     * @param movies 
     */
    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    /**
     * This method will search and return the all match movies according to the query parameter.
     * @param title the query movie title 
     * @param genre the query movie genre
     * @param startYear the query Start year range
     * @param endYear the query end year range 
     * @return
     * @throws ParseException 
     */
    public ArrayList<Movie> searchMovie(String title, String genre, String startYear, String endYear) throws ParseException {
        return movies.searchMovies(title, genre, startYear, endYear);
    }
    
    /**
     * This method will add the given copies to the available copies
     * @param title the given movie title 
     * @param copies the number of copies that wish to add to the current available copies
     */
    public void addCopies(String title,int copies){
        movies.addCopies(title, copies);
    }
    
    /**
     * This method will remove minus the given copies form available copies
     * @param title the given movie title 
     * @param copies the number of copies that wish to remove from the current available copies 
     */
    public void minusCopies(String title,int copies){
        movies.minusCopies(title, copies);
    }
    
    /**
     * This will return movie that match the given movie title
     * @param title
     * @return 
     */
    public Movie getMovieByTitle(String title){
        return movies.getMovieByTitle(title);
    }
}

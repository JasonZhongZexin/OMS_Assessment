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

    public void saveMovies() throws JAXBException, FileNotFoundException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(movies, fout);
        fout.close();
    }

    public Movies getMovies() {
        return this.movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> searchMovie(String title, String genre, String startYear, String endYear) throws ParseException {
        return movies.searchMovies(title, genre, startYear, endYear);
    }

    public Movie checkMovie() {
        Movie movie = movies.getMovie(filePath);
        return movie;
    }
    
    public void addCopies(String title,int copies){
        movies.addCopies(title, copies);
    }
    
    public void minusCopies(String title,int copies){
        movies.minusCopies(title, copies);
    }
}

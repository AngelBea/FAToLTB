package main.java.services;


import main.java.beans.MovieBean;
import main.java.beans.WriterBean;

public interface ILbxFileSrv {

    public void printHeader(IMovieBeanSrv service, WriterBean wb);

    public void printLnMovie(IMovieBeanSrv service, WriterBean wb, MovieBean mb);

    public void closePw(WriterBean mb);
}

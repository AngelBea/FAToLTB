package main.java.services;


import main.java.beans.MovieBean;
import main.java.beans.WriterBean;

public class LbxFileSrv implements ILbxFileSrv {

    @Override
    public void printHeader(IMovieBeanSrv service, WriterBean wb) {
        wb.getPw().println(service.movieBeanHeader());
    }

    @Override
    public void printLnMovie(IMovieBeanSrv service, WriterBean wb, MovieBean mb) {
        wb.getPw().println(service.movieBeanToCsv(mb));
    }

    @Override
    public void closePw(WriterBean mb) {
        mb.getPw().close();
    }
}

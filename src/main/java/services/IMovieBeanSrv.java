package main.java.services;


import main.java.beans.MovieBean;

public interface IMovieBeanSrv {
    public String movieBeanHeader();

    public String movieBeanToCsv(MovieBean mb);

    public String formatDate(String year, String month, String day);

    public String formatDateMonth(MovieBean mb);

    public String formatDateDay(MovieBean mb);

    public String formatDateYear(MovieBean mb);

    public String formatYearMovie(MovieBean mb);
}

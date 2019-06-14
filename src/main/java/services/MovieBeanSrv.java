package main.java.services;


import main.java.beans.MovieBean;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class MovieBeanSrv implements IMovieBeanSrv {

    @Override
    public String movieBeanHeader() {
        return "Title, Year, Rating10, WatchedDate";
    }

    @Override
    public String movieBeanToCsv(MovieBean mb) {
        return "\"" + mb.getName() + "\"" + ", " + mb.getYear() + ", " + mb.getRate() + ", " + mb.getWatched();
    }

    @Override
    public String formatDate(String year, String month, String day) {
        GregorianCalendar date = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1,
                Integer.parseInt(day));
        return new SimpleDateFormat("YYYY-MM-dd").format(date.getTime());
    }

    @Override
    public String formatDateMonth(MovieBean mb) {
        StringTokenizer st = new StringTokenizer(mb.getWatched().replaceAll(",", ""));

        while (st.hasMoreTokens()) {
            String lowerCase = st.nextToken().toLowerCase();
            if (lowerCase.equals("january")) {
                return "1";
            } else if (lowerCase.equals("february")) {
                return "2";
            } else if (lowerCase.equals("march")) {
                return "3";
            } else if (lowerCase.equals("april")) {
                return "4";
            } else if (lowerCase.equals("may")) {
                return "5";
            } else if (lowerCase.equals("june")) {
                return "6";
            } else if (lowerCase.equals("july")) {
                return "7";
            } else if (lowerCase.equals("august")) {
                return "8";
            } else if (lowerCase.equals("september")) {
                return "9";
            } else if (lowerCase.equals("october")) {
                return "10";
            } else if (lowerCase.equals("november")) {
                return "11";
            } else if (lowerCase.equals("december")) {
                return "12";
            }

        }
        return "";

    }

    @Override
    public String formatDateDay(MovieBean mb) {
        StringTokenizer st = new StringTokenizer(mb.getWatched().replaceAll(",", ""));
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            try {
                int num = Integer.parseInt(nextToken);
                if (num > 0 && num <= 31) {
                    return nextToken;
                }

            } catch (NumberFormatException e) {
                //System.out.println("No se ha convertido porque valor = " + nextToken);
            }
        }
        return "";
    }

    @Override
    public String formatDateYear(MovieBean mb) {
        StringTokenizer st = new StringTokenizer(mb.getWatched().replaceAll(",", ""));
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            try {
                int num = Integer.parseInt(nextToken);
                if (num >= 1850 && num <= 2100) {
                    return nextToken;
                }

            } catch (NumberFormatException e) {
                //System.out.println("No se ha convertido porque valor = " + nextToken);
            }
        }
        return "";
    }

    @Override
    public String formatYearMovie(MovieBean mb) {
        String year = mb.getYear();
        year = year.replaceFirst("[(]", "").replaceAll("[)]", "");

        return year;
    }

}

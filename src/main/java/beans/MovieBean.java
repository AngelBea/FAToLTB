package main.java.beans;

public class MovieBean {

    private String name;
    private String rate;
    private String year;
    private String watched;

    public MovieBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        return "MovieBean [name=" + name + ", rate=" + rate + ", year=" + year + ", watched=" + watched + "]";
    }


}

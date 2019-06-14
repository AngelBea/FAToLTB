package main.java.services;


import main.java.beans.BrowserBean;
import org.jsoup.nodes.Element;

public interface IFilmAffinitySrv {

    public String getUrlVotes(String usercode);

    public void votesMoveToPage(String usercode, BrowserBean b, int page);

    public void votesMoveNext(IBrowserSrv service, BrowserBean b);

    public void removeCookieWindow(IBrowserSrv service, BrowserBean b);

    public int votesGetMaxPages(BrowserBean b);

    public String votesGetYear(Element e);

    public String votesGetName(Element e);

    public String votesGetRate(Element e);

    public String votesGetWatched(Element e);


}

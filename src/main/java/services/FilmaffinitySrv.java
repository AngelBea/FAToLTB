package main.java.services;


import main.java.beans.BrowserBean;
import org.jsoup.nodes.Element;

public class FilmaffinitySrv implements IFilmAffinitySrv {

    @Override
    public String getUrlVotes(String usercode) {
        return "https://www.filmaffinity.com/en/userratings.php?user_id=" + usercode + "&p=1&orderby=4";
    }

    @Override
    public void votesMoveToPage(String usercode, BrowserBean b, int page) {
        b.getWb().get("https://www.filmaffinity.com/en/userratings.php?user_id=" + usercode + "&p="
                + String.valueOf(page) + "&orderby=4");
    }

    @Override
    public void votesMoveNext(IBrowserSrv service, BrowserBean b) {
        service = new BrowserSrv();
        service.clickOnCss(b, "div.pager a:last-child");
    }

    @Override
    public String votesGetYear(Element e) {
        e.selectFirst(".mc-title a").remove();
        return e.selectFirst(".mc-title").text();
    }

    @Override
    public String votesGetName(Element e) {
        return e.select(".mc-title a").text();
    }

    @Override
    public String votesGetRate(Element e) {
        return e.selectFirst(".user-ratings-movie-rating .ur-mr-rat").text();
    }

    @Override
    public String votesGetWatched(Element e) {
        return e.selectFirst(".user-ratings-header").text();
    }

    @Override
    public int votesGetMaxPages(BrowserBean b) {
        b.getDoc().selectFirst("div.pager a:last-child").remove();
        return Integer.parseInt(b.getDoc().selectFirst("div.pager a:last-child").text());
    }

    @Override
    public void removeCookieWindow(IBrowserSrv service, BrowserBean b) {
        service.clickOnCss(b, ".qc-cmp-button");
    }


}

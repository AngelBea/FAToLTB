package main.java.controller;


import main.java.beans.BrowserBean;
import main.java.beans.MovieBean;
import main.java.beans.WriterBean;
import main.java.services.*;
import org.jsoup.nodes.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/Convert/*")
public class IndexController extends HttpServlet {

    private IMovieBeanSrv movieService = new MovieBeanSrv();
    private IBrowserSrv browserService = new BrowserSrv();
    private IFilmAffinitySrv faService = new FilmaffinitySrv();

    public IndexController() {
        //Put here your custom path to geckodriver
        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\FAToLTB\\src\\driver\\geckodriver.exe");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/email")) {
            faToLetterBoxEmail(request, response);
        } else if (request.getRequestURI().endsWith("/noemail")) {
            faToLetterBoxNoEmail(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void faToLetterBoxEmail(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            ArrayList<MovieBean> movies = new ArrayList<MovieBean>();

            String usercode = request.getParameter("usercode");
            String email = request.getParameter("email");

            System.out.println("Usercode " + usercode + " Email " + email);

            BrowserBean b = new BrowserBean(true);

            browserService.openBrowser(b, "https://www.filmaffinity.com/en/userratings.php?user_id=" + usercode);
            browserService.setSoupDocument(b);

            int pages = faService.votesGetMaxPages(b);

            for (int i = 1; i <= pages; i++) {

                faService.votesMoveToPage(usercode, b, i);

                browserService.setSoupDocument(b);

                browserService.getElements(b, "user-ratings-wrapper").forEach(e -> {
                    String watched = faService.votesGetWatched((Element) e);
                    System.out.println(watched);
                    browserService.getElementsByElement((Element) e, "user-ratings-movie").forEach(el -> {

                        if (!faService.votesGetName((Element) el).endsWith("(TV Series)") &&
                                !faService.votesGetName((Element) el).endsWith("(TV)")
                                && !faService.votesGetName((Element) el).endsWith("(TV Miniseries)")) {

                            MovieBean mb = new MovieBean();

                            mb.setName(faService.votesGetName((Element) el));
                            mb.setRate(faService.votesGetRate((Element) el));
                            mb.setWatched(watched);
                            mb.setWatched(movieService.formatDate(movieService.formatDateYear(mb)
                                    , movieService.formatDateMonth(mb)
                                    , movieService.formatDateDay(mb)));
                            mb.setYear(faService.votesGetYear((Element) el));
                            mb.setYear(movieService.formatYearMovie(mb));

                            movies.add(mb);
                        }
                    });
                });
            }

            WriterBean wb = new WriterBean(usercode);
            ILbxFileSrv lbxService = new LbxFileSrv();

            lbxService.printHeader(movieService, wb);

            movies.forEach(mb -> lbxService.printLnMovie(movieService, wb, mb));

            System.out.println("Saved on: " + wb.getSave());

            lbxService.closePw(wb);

            browserService.closeBrowser(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void faToLetterBoxNoEmail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usercode = request.getParameter("usercode");
        System.out.println(usercode);
    }
}

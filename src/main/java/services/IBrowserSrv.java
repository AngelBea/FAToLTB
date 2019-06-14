package main.java.services;


import main.java.beans.BrowserBean;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface IBrowserSrv {

    public void openBrowser(BrowserBean b, String url);

    public void setSoupDocument(BrowserBean b);

    public void wait(BrowserBean b, int wait, TimeUnit unit);

    public void clickOnCss(BrowserBean b, String cssSelector);

    public List<Object> getElements(BrowserBean b, String cssClass);

    public List<Object> getElementsByElement(Element e, String cssClass);

    public void closeBrowser(BrowserBean b);

    public Element getFirstElement(BrowserBean b, String cssSelector);
}

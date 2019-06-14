package main.java.services;


import main.java.beans.BrowserBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserSrv implements IBrowserSrv {

    @Override
    public void openBrowser(BrowserBean b, String url) {
        b.getWb().get(url);
    }

    @Override
    public void setSoupDocument(BrowserBean b) {
        Document doc = Jsoup.parse(b.getWb().getPageSource());
        b.setDoc(doc);
    }

    @Override
    public void clickOnCss(BrowserBean b, String cssSelector) {
        WebDriver wb = b.getWb();
        wb.findElement(By.cssSelector(cssSelector)).click();
    }

    @Override
    public List<Object> getElements(BrowserBean b, String cssClass) {
        setSoupDocument(b);
        Object[] elements = b.getDoc().getElementsByClass(cssClass).toArray();
        return Arrays.asList(elements);
    }


    @Override
    public List<Object> getElementsByElement(Element e, String cssClass) {
        Object[] elements = e.getElementsByClass(cssClass).toArray();
        return Arrays.asList(elements);
    }

    @Override
    public void closeBrowser(BrowserBean b) {
        b.getWb().close();
    }

    @Override
    public Element getFirstElement(BrowserBean b, String cssSelector) {
        return b.getDoc().selectFirst(cssSelector);
    }

    @Override
    public void wait(BrowserBean b, int wait, TimeUnit unit) {
        b.getWb().manage().timeouts().pageLoadTimeout(wait, unit);
    }


}

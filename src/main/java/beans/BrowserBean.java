package main.java.beans;

import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserBean {
    private String url;
    private WebDriver wb;
    private Document doc;

    public BrowserBean() {
        FirefoxOptions fo = new FirefoxOptions();
        this.wb = new FirefoxDriver(fo);
    }

    public BrowserBean(boolean headless) {
        FirefoxOptions fo = new FirefoxOptions();
        if (headless) {
            fo.setHeadless(headless);
            this.wb = new FirefoxDriver(fo);
        } else {
            this.wb = new FirefoxDriver(fo);
        }
    }

    public WebDriver getWb() {
        return wb;
    }

    public void setWb(WebDriver wb) {
        this.wb = wb;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

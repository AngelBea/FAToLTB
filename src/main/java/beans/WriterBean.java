package main.java.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriterBean {

    private PrintWriter pw;
    private File file;
    private String save;


    public WriterBean(String usercode) throws FileNotFoundException, UnsupportedEncodingException {
        this.save = System.getProperty("user.dir") + "\\" + usercode + ".csv";
        this.file = new File(this.save);
        this.pw = new PrintWriter(this.file, "UTF-8");
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }


}

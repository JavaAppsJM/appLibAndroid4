package be.hvwebsites.libraryandroid4.repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CookieRepository {
    private List<Cookie> cookieList = new ArrayList<>();
    File cookieFile;
    private FlexiRepository flexiRepository;
    public static final String COOKIE_FILE = "cookie.txt";
    public static final int COOKIE_NOT_FOUND = 99999;

    public CookieRepository(String basedir) {
        cookieList.addAll(readCookies(basedir));
    }

    public String getCookieValueFromLabel(String label){
        if (bestaatCookie(label) != COOKIE_NOT_FOUND){
            return cookieList.get(bestaatCookie(label)).getCookieValue();
        }
        return String.valueOf(COOKIE_NOT_FOUND);
    }

    public void addCookie(Cookie cookie){
        // opgegeven cookie wordt toegevoegd in de cookieList en bewaard
        int cookieIndex = bestaatCookie(cookie.getCookieLabel());
        if (cookieIndex != COOKIE_NOT_FOUND){
            cookieList.remove(cookieIndex);
        }
        cookieList.add(cookie);
        // Wegschrijven nr file
        writeCookies();
    }

    public void deleteCookie(String label){
        // cookie met opgegeven label wordt gedelete uit de cookieList en bewaard
        cookieList.remove(bestaatCookie(label));
        // Wegschrijven nr file
        writeCookies();
    }

    public int bestaatCookie(String label){
        if (cookieList != null){
            for (int i = 0; i < cookieList.size(); i++) {
                if (cookieList.get(i).getCookieLabel().equals(label)){
                    return i;
                }
            }
        }
        return COOKIE_NOT_FOUND;
    }

    public List<Cookie> readCookies(String basedir){
        // File definitie
        cookieFile = new File(basedir, COOKIE_FILE);
        flexiRepository = new FlexiRepository(cookieFile);
        // Cookies ophalen
        return getCookiesFromDataList(flexiRepository.getDataList());
    }

    private List<Cookie> getCookiesFromDataList(List<String> dataList){
        // Layout String in dataList: <label1><valuename><label2><value>
        // bvb: <label><typemeasurement><value><belly>
        List<Cookie> cookies = new ArrayList<>();
        for (int j = 0; j < dataList.size(); j++) {
            cookies.add(convertFileLineInCookie(dataList.get(j)));
        }
        return cookies;
    }

    private Cookie convertFileLineInCookie(String fileLine){
        Cookie cookie = new Cookie();
        // fileLine splitsen in argumenten
        String[] fileLineContent = fileLine.split("<");
        for (int i = 0; i < fileLineContent.length; i++) {
            // TODO: label.* in een static zetten
            if (fileLineContent[i].matches("label.*")){
                cookie.setCookieLabel(fileLineContent[i+1].replace(">",""));
            }
            // TODO: value.* in een static zetten
            if (fileLineContent[i].matches("value.*")){
                cookie.setCookieValue((fileLineContent[i+1].replace(">","")));
            }
        }
        return cookie;
    }

    public void writeCookies(){
        List<String> lineList = new ArrayList<>();
        for (int i = 0; i < cookieList.size(); i++) {
            lineList.add(makeFileLine(cookieList.get(i)));
        }
        flexiRepository.setDataList(lineList);
        flexiRepository.writeDatafromList();
    }

    private String makeFileLine(Cookie cookie){
        // TODO: label.* en value.* in een static zetten
        return "<label><" + cookie.getCookieLabel()
                + "><value><" + cookie.getCookieValue() + ">";
    }

    public List<Cookie> getCookieList() {
        return cookieList;
    }

    public void setCookieList(List<Cookie> cookieList) {
        this.cookieList = cookieList;
    }
}

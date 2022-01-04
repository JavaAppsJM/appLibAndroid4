package be.hvwebsites.libraryandroid4.helpers;

import be.hvwebsites.libraryandroid4.repositories.Cookie;
import be.hvwebsites.libraryandroid4.repositories.CookieRepository;

public class IDNumber {
    private int id;

    public IDNumber(int id){
        this.id = id;
    }

    public IDNumber(String stringId){
        this.id = Integer.parseInt(stringId);
    }

    public IDNumber(String basedir, String entity) {
        // Bepaal latest id voor opgegeven entity
        CookieRepository cookieRepository = new CookieRepository(basedir);
        if (cookieRepository.bestaatCookie(entity) != CookieRepository.COOKIE_NOT_FOUND){
            this.id = Integer.parseInt(cookieRepository.getCookieValueFromLabel(entity)) + 1;
            // Cookie vervangen met nieuwe hoogste id
            Cookie cookie = new Cookie(entity, String.valueOf(this.id));
            cookieRepository.deleteCookie(entity);
            cookieRepository.addCookie(cookie);
        }else {
            // Cookie not found (er is nog geen latest ID voor opgegeven entity
            this.id = 1;
            // Cookie met hoogste id bewaren
            Cookie cookie = new Cookie(entity, String.valueOf(this.id));
            cookieRepository.addCookie(cookie);
        }
    }

    public int getId() {
        return id;
    }

    public String getIdString(){
        return String.valueOf(this.id);
    }

    public void setId(int id) {
        this.id = id;
    }
}

package be.hvwebsites.libraryandroid4.helpers;

import java.util.Calendar;

public class DateString {
    // format: ddmmyyyy
    private String dateString;

    public DateString(String dateString) {
        // Zit er een / in de string
        if (dateString.contains("/")){
            this.dateString = trimDate(dateString);
        }else {
            this.dateString = dateString;
        }
    }

    public String getDateString() {
        return dateString;
    }

    // Datum methodes
    private String trimDate(String inputDate){
        // Haal de / uit de datum
        String[] dateStringParts = inputDate.split("/");
        String day = leadingZero(dateStringParts[0]);
        String month = leadingZero(dateStringParts[1]);
        String year = dateStringParts[2];
        return day + month + year;
    }

    private String leadingZero(String string){
        // Zet een leading zero indien die ontbreekt
        if (Integer.parseInt(string) < 10 && string.length() < 2){
            return  "0" + string;
        }else {
            return string;
        }
    }

    public String getFormatDate() {
        // Zet / in de datum
        String day = dateString.substring(0,2);
        String month = dateString.substring(2,4);
        String year = dateString.substring(4);
        return day + "/" + month + "/" + year;
    }

    public Calendar getCalendarDate(){
        Calendar calendarDate = Calendar.getInstance();
        int day = Integer.parseInt(dateString.substring(0,2));
        int month = Integer.parseInt(dateString.substring(2,4));
        int year = Integer.parseInt(dateString.substring(4));
        calendarDate.set(year, month, day);
        return calendarDate;
    }

    public int calculateDateDifference(DateString inDate){
        Calendar currentdate;
        Calendar previousdate;

        currentdate = this.getCalendarDate();
        previousdate = inDate.getCalendarDate();

        return  (int)((currentdate.getTimeInMillis() - previousdate.getTimeInMillis())
                /(1000*60*60*24));
    }

    public boolean isEmpty() {
        return false;
    }
}

package be.hvwebsites.libraryandroid4.helpers;

import java.util.Calendar;

public class DateString {
    // format: ddmmyyyy
    private String dateString;
    public static final String EMPTY_DATESTRING = " ";
    private static final long MILLIS_IN_DAY = (1000*60*60*24);

    public DateString(String dateString) {
        // Zit er een / in de string
        if (dateString.contains("/")){
            this.dateString = trimDate(dateString);
        }else {
            this.dateString = dateString;
        }
    }

    public DateString(long dateInMillis){
        this.dateString = getDateFromMillis(dateInMillis);
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
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

    private String getDateFromMillis(long inMillis){
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(inMillis);

        String day = String.valueOf(calendarDate.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(calendarDate.get(Calendar.MONTH));
        String year = String.valueOf(calendarDate.get(Calendar.YEAR));
        return day + month + year;
    }

    public long getDateInMillis(){
        return getCalendarDate().getTimeInMillis();
    }

    public int calculateDateDifference(DateString inDate){
        Calendar currentdate;
        Calendar previousdate;

        currentdate = this.getCalendarDate();
        previousdate = inDate.getCalendarDate();

        return  (int)((currentdate.getTimeInMillis() - previousdate.getTimeInMillis())
                /MILLIS_IN_DAY);
    }

    public void addNbrOfYears(int freqNumber){
        String stringDay = dateString.substring(0,2);
        String stringMonth = dateString.substring(2,4);
        int year = Integer.parseInt(dateString.substring(4));
        String stringYear = String.valueOf(year + freqNumber);

        this.dateString = stringDay + stringMonth + stringYear;
    }

    public void addNbrOfMonths(int freqNumber){
        int day = Integer.parseInt(dateString.substring(0,2));
        int month = Integer.parseInt(dateString.substring(2,4));
        int year = Integer.parseInt(dateString.substring(4));
        String stringDay = dateString.substring(0,2);
        String stringMonth = dateString.substring(2,4);
        String stringYear = dateString.substring(4);

        // Bepaal nieuwe maand en jaar
        double nbrOfYears = Math.floor(freqNumber / 12);
        int restOfMonths = (int) (freqNumber - (nbrOfYears * 12));
        int nMonth = restOfMonths + month;
        int nYear = (int) (year + nbrOfYears);

        if (nMonth > 12){
            // we zitten nog 1 jaar verder
            nYear++;
            nMonth = nMonth - 12;
        }
        stringMonth = String.valueOf(nMonth);
        stringYear = String.valueOf(nYear);
        this.dateString = stringDay + stringMonth + stringYear;

        // Corrigeer dag en maand via Calendar bvb 31/2 moet 3/3 zijn indien geen schrikkeljaar
        this.dateString = getDateFromMillis(getDateInMillis());
    }

    public void addNbrOfWeeks(int freqNumber){
        this.dateString = getDateFromMillis(getDateInMillis() + ((long) freqNumber * 7 * MILLIS_IN_DAY));
    }

    public void addNbrOfDays(int freqNumber){
        this.dateString = getDateFromMillis(getDateInMillis() + ((long) freqNumber * MILLIS_IN_DAY));
    }

    public boolean isEmpty() {
        return false;
    }
}

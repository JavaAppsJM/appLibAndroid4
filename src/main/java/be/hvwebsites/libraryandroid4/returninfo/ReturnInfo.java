package be.hvwebsites.libraryandroid4.returninfo;

public class ReturnInfo {
    private int returnCode;
    private String returnMessage;

    public ReturnInfo(int returnCode, String returnmsg) {
        this.returnCode = returnCode;
        this.returnMessage = returnmsg;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}

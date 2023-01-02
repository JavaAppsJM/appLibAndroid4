package be.hvwebsites.libraryandroid4.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.hvwebsites.libraryandroid4.returninfo.ReturnInfo;

public class FlexiRepository {
    private List<String> dataList = new ArrayList<>();
    public File flexiFile;

    public FlexiRepository() {
    }

    public FlexiRepository(File flexiFile) {
        this.flexiFile = flexiFile;
        // Data ophalen
        readDataToList();
    }

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
    }

    public File getFlexiFile() {
        return flexiFile;
    }

    public void setFlexiFile(File flexiFile) {
        this.flexiFile = flexiFile;
    }

    public ReturnInfo readDataToList(){
        ReturnInfo returnInfo = new ReturnInfo(0, "");
        this.dataList.clear();
        // File lezen
        if (flexiFile.exists()){
            try {
                Scanner inFile = new Scanner(flexiFile);
                int i = 0;
                while (inFile.hasNext()){
                    dataList.add(inFile.nextLine());
                    i++;
                }
                inFile.close();
                return returnInfo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // Returninfo invullen
                returnInfo.setReturnCode(101);
                returnInfo.setReturnMessage("File niet gevonden !");
                return returnInfo;
            }
        }else {
            // Returninfo invullen
            returnInfo.setReturnCode(100);
            returnInfo.setReturnMessage("Er is nog geen data !");
            return returnInfo;
        }
    }

    public boolean writeDatafromList(){
        try {
            PrintWriter outFile = new PrintWriter(flexiFile);
            for (int i = 0; i < dataList.size(); i++) {
                outFile.println(dataList.get(i));
            }
            outFile.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void storeData(File inFile, List<String> dataList){
        setFlexiFile(inFile);
        setDataList(dataList);
        writeDatafromList();
    }
}

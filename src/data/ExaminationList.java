/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools , Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class ExaminationList extends ArrayList<Examination> {

    public ExaminationList() {
        super();
    }

    public void loadFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String examinationID = stk.nextToken().toUpperCase();
                String doctorID = stk.nextToken().toUpperCase();
                String patientID = stk.nextToken().toUpperCase();
                String result = stk.nextToken();
                String dateStr = stk.nextToken().trim();
                Date date = null;

                SimpleDateFormat fomater = new SimpleDateFormat("dd-MM-yyyy");
                if (!dateStr.equalsIgnoreCase("null")) {
                    date = fomater.parse(dateStr);
                }

                Examination newExamination = new Examination(examinationID, doctorID, patientID, result, date);
                this.add(newExamination);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void writeToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Examination x : this) {
                pw.println(x.getExaminationID() + "," + x.getDoctorID() + "," + x.getPatientID() + "," + x.getResult() + "," + MyTool.convertDateFormat(x.getDate()));
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

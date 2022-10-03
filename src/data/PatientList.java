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
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author NhiLamHet
 */
public class PatientList extends ArrayList<Patient>{


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
                String patientID = stk.nextToken().toUpperCase();
                String patientName = stk.nextToken();
                int age = Integer.parseInt(stk.nextToken());
                String address = stk.nextToken();

                
                Patient newPatient = new Patient(patientID, patientName, age, address);
                this.add(newPatient);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void writeToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Patient x : this) {
                pw.println(x.getPatientID() + "," + x.getPatientName() + "," + x.getAge() + "," + x.getAddress());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

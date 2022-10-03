/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import sun.net.www.content.audio.x_aiff;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class Examination implements Comparable<Examination> {

    private String examinationID;
    private String doctorID;
    private String patientID;
    private String result;
    private Date date;

    public Examination() {
    }

    public Examination(String examinationID, String doctorID, String patientID, String result, Date date) {
        this.examinationID = examinationID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.result = result;
        this.date = date;
    }

    Examination(String examinationID) {
        this.examinationID = examinationID; //To change body of generated methods, choose Tools | Templates.
    }

    public String getExaminationID() {
        return examinationID;
    }

    public void setExaminationID(String examinationID) {
        this.examinationID = examinationID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        return this.examinationID.equalsIgnoreCase(((Examination) obj).getExaminationID());
    }

    @Override
    public String toString() {
        return "EXAM {"+examinationID + "," + doctorID + "," + patientID + "," + result + "," + MyTool.convertDateFormat(date)+"}";
    }

    @Override
    public int compareTo(Examination o) {
        return this.getExaminationID().compareToIgnoreCase(o.getExaminationID()); //To change body of generated methods, choose Tools | Templates.
    }
}

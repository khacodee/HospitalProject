/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools , Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author NhiLamHet
 */
public class Patient implements Comparable<Patient>{

    private String patientID;
    private String patientName;
    private int age;
    private String address;

    public Patient() {
    }

    public Patient(String patientID, String patientName, int age, String address) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.address = address;
    }

    Patient(String patientID) {
        this.patientID = patientID; //To change body of generated methods, choose Tools , Templates.
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    @Override
    public boolean equals(Object obj) {
        return this.patientID.equalsIgnoreCase(((Patient) obj).getPatientID());
    }

    @Override
    public String toString() {
        return "PAT{"+patientID + "," + patientName + "," + age + "," + address+"}";
    }

    @Override
    public int compareTo(Patient o) {
        return this.getPatientID().compareToIgnoreCase(o.getPatientID()); //To change body of generated methods, choose Tools , Templates.
    }

}

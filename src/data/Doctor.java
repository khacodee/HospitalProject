/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools , Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class Doctor implements Comparable<Doctor> {

    private String doctorID;
    private String doctorName;
    private Boolean sex;
    private String address;
    private String departmentID;
    private Date createDate;
    private Date lastUpdateDate;

    public Doctor() {
    }

    public Doctor(String doctorID, String doctorName, Boolean sex, String address, String departmentID, Date createDate, Date lastUpdateDate) {
        setDoctorID(doctorID);
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    Doctor(String doctorID) {
        this.doctorID = doctorID; //To change body of generated methods, choose Tools , Templates.
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        
        if(!doctorID.isEmpty()&& doctorID != null)this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptID() {
        return departmentID;
    }

    public void setDeptID(String deptID) {
        this.departmentID = deptID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.doctorID.equalsIgnoreCase(((Doctor) obj).getDoctorID());
    }

    @Override
    public String toString() {
        return "DOC {" + doctorID + "," + doctorName + "," + sex + "," + address + "," + departmentID + ","
                + MyTool.convertDateFormat(createDate) + "," + MyTool.convertDateFormat(lastUpdateDate) + "}";
    }

    @Override
    public int compareTo(Doctor o) {
        return this.getDoctorID().compareToIgnoreCase(o.getDoctorID()); //To change body of generated methods, choose Tools , Templates.
    }

}

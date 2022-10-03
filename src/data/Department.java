/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class Department implements Comparable<Department>{
    private String departmentID;
    private String departmentName;
    private Date createDate;
    private Date lastUpdateDate;

    public Department() {
    }

    public Department(String departmentID, String departmentName, Date createDate, Date lastUpdateDate) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    Department(String deptID) {
        this.departmentID = deptID; //To change body of generated methods, choose Tools | Templates.
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
        return this.departmentID.equalsIgnoreCase(((Department)obj).getDepartmentID());
    }

    @Override
    public String toString() {
        return "DEPT {"+departmentID + "," + departmentName + "," + MyTool.convertDateFormat(createDate) + "," + MyTool.convertDateFormat(lastUpdateDate)+"}";
    }

    @Override
    public int compareTo(Department o) {
        return this.getDepartmentID().compareToIgnoreCase(o.getDepartmentID()); //To change body of generated methods, choose Tools | Templates.
    }
}

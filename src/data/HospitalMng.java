/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import tools.MyTool;

/**
 *
 * @author NhiLamHet
 */
public class HospitalMng {

    DepartmentList deptList;
    DoctorList doctorList;
    ExaminationList examinationList;
    PatientList patientList;    

    public HospitalMng() {
        deptList = new DepartmentList();
        doctorList = new DoctorList();
        examinationList = new ExaminationList();
        patientList = new PatientList();
        deptList.loadFromFile("departments.dat");
        doctorList.loadFromFile("doctors.dat");
        examinationList.loadFromFile("examinations.dat");
        patientList.loadFromFile("patients.dat");
    }

    public void showDoctorInfor() {
        if (doctorList.isEmpty()) {
            System.out.println("The doctor is empty");
        } else {
            Collections.sort(doctorList);
            System.out.println("Found " + doctorList.size() + " doctor(s) from the file: ");
            for (Doctor x : doctorList) {
                System.out.println(x);
            }
        }
    }

    public void showDeptInfor() {
        if (deptList.isEmpty()) {
            System.out.println("The department is empty");

        } else {
            Collections.sort(deptList);
            System.out.println("Found " + deptList.size() + " departments(s) from the file: ");
            for (Department x : deptList) {
                System.out.println(x);
            }
        }
    }

    public void showExaminationInFor() {
        if (examinationList.isEmpty()) {
            System.out.println("The examination is empty");

        } else {
            Collections.sort(examinationList);
            System.out.println("Found " + examinationList.size() + " examination(s) from the file: ");
            for (Examination x : examinationList) {
                System.out.println(x);
            }
        }
    }

    public void showPatientInfor() {
        if (patientList.isEmpty()) {
            System.out.println("The patient is empty");

        } else {
            Collections.sort(patientList);
            System.out.println("Found " + patientList.size() + " patient(s) from the file: ");
            for (Patient x : patientList) {
                System.out.println(x.toString());
            }
        }
    }

    public void addDoctor() {
        String doctorID, doctorName, address, deptID;
        Boolean sex, check;
        Date createDate, lastUpdateDate;
        int pos;
        do {
            doctorID = MyTool.getID("Input doctor ID(DOCxxxxx): ", "Invalid!", "DOC[0-9]{5}"); //"^[a-zA-Z\\s]+"
            pos = doctorList.indexOf(new Doctor(doctorID));
            if (pos >= 0) {
                System.out.println("The doctor id already exists. " 
                        + "Input another one!");
            }
        } while (pos != -1);
        doctorName = MyTool.getName("Input doctor name: ", "Invalid!", "^[a-zA-Z\\s]+");
        sex = MyTool.getBoolean("Female? (Y/N): ", "Invalid!", false);
        address = MyTool.getString("Input the address: ", "Invalid!", false);
        do {
            deptID = MyTool.getID("Input department ID(DEPTxxxxx): ", "Department ID is invalid!", "DEPT[0-9]{5}");
            check = containsDepartment(deptID);
            if (!check) {
                System.out.println("The department ID is not existed in the department list. "
                        + "Input another one!");
            }
        } while (!check);
        createDate = MyTool.getDate("Input day create: ", "Invalid!");
        lastUpdateDate = null;
        doctorList.add(new Doctor(doctorID, doctorName, sex, address, deptID, createDate, lastUpdateDate));
        System.out.println("A doctor is added sucessfully!");
    }

    public void addDepartment() {
        String deptID, deptName;
        Date createDate, lastUpdateDate;
        int pos;
        do {
            deptID = MyTool.getID("Input department ID(DEPTxxxxx): ", "Department ID is  invalid!", "DEPT[0-9]{5}"); // DEPT12345
            pos = deptList.indexOf(new Department(deptID));
            if (pos >= 0) {
                System.out.println("The department ID already exists. "
                        + "Input another one!");
            }
        } while (pos != -1);
        deptName = MyTool.getString("Input department name:  ", "Invalid!", false);
        createDate = MyTool.getDate("Input create date: ", "Invalid!");
        lastUpdateDate = null;
        deptList.add(new Department(deptID, deptName, createDate, lastUpdateDate));
        System.out.println("A department is added sucessfully!");
    }

    public void addPatient() {
        String patientID;
        String patientName;
        int age;
        String address;
        int pos;
        do {
            patientID = MyTool.getID("Input patient ID(PATxxxxx): ", "Patient ID is  invalid!", "PAT[0-9]{5}");
            pos = patientList.indexOf(new Patient(patientID));
            if (pos >= 0) {
                System.out.println("The patient id already exists. "
                        + "Input another one!");
            }
        } while (pos != -1);
        patientName = MyTool.getName("Input patient name: ", "Invalid!", "^[a-zA-Z\\\\s]+");
        age = MyTool.getAnInteger("Input age patient: ", "Invalid!", 1, 120);
        address = MyTool.getString("Input the address: ", "Invalid!", false);
        patientList.add(new Patient(patientID, patientName, age, address));
        System.out.println("A patient is added sucessfully!");
    }

    public void addExaminaton() {
        String examinationID;
        String doctorID;
        String patientID;
        String result;
        Date date;
        int pos;
        boolean check;
        do {
            examinationID = MyTool.getID("Input examination ID(EXAMxxxxx): ", "Examination ID is  invalid!", "EXAM[0-9]{5}");
            pos = examinationList.indexOf(new Examination(examinationID));
            if (pos >= 0) {
                System.out.println("The examination id already exists. "
                        + "Input another one!");
            }
        } while (pos != -1);
        do {
            doctorID = MyTool.getID("Input doctor ID(DOCxxxxx): ", "Doctor ID is invalid!", "DOC[0-9]{5}");
            check = containsDoctor(doctorID);
            if (!check) {
                System.out.println("The doctor ID is not existed in the doctor list. "
                        + "Input another one!");
            }
        } while (!check);
        do {
            patientID = MyTool.getID("Input patient ID(PATxxxxx): ", "patient ID is invalid!", "PAT[0-9]{5}");
            check = containsPatient(patientID);
            if (!check) {
                System.out.println("The patient ID is not existed in the patient list. "
                        + "Input another one!");
            }
        } while (!check);
        date = MyTool.getDate("Input create date: ", "Invalid!");
        result = MyTool.getString("Input result: ", "Invalid!", false);
        examinationList.add(new Examination(null, null, patientID, result, date));
        examinationList.add(new Examination(examinationID, doctorID, patientID, result, date));
        examinationList.add(new Examination(examinationID, doctorID, patientID, result, date));
        examinationList.add(new Examination(examinationID, doctorID, patientID, result, date));
        System.out.println("A examination is added sucessfully!");
    }

    public boolean containsDepartment(String deptID) {
        for (Department x : deptList) {
            if (deptID.equalsIgnoreCase(x.getDepartmentID())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDoctor(String doctorID) {
        for (Doctor x : doctorList) {
            if (doctorID.equalsIgnoreCase(x.getDoctorID())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPatient(String patientID) {
        for (Patient x : patientList) {
            if (patientID.equalsIgnoreCase(x.getPatientID())) {
                return true;
            }
        }
        return false;
    }

    public void updateDoctor() {
        String doctorID, doctorName, address, deptID;
        Boolean sex;
        Date lastUpdateDate;
        doctorID = MyTool.getID("Input doctor ID do you want update(DOCxxxxx): ", "Doctor ID is invalid!", "DOC[0-9]{5}");
        int pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos == -1) {
            System.out.println("Doctor does not exist");
            return;
        }
        doctorName = MyTool.getName("Input doctor name: ", "Invalid!", "^[a-zA-Z\\s]+");
        sex = MyTool.getBoolean("Female? (Y/N)", "Invalid!", true); //kiểm tra lại trường hợp bỏ trống
        address = MyTool.getString("Input the address: ", "Invalid!", true);
        do {
            deptID = MyTool.getID("Input department ID(DEPTxxxxx): ", "Department ID is invalid!", "DEPT[0-9]{5}");
            if (deptID.isEmpty()) {
                break; //nếu bỏ trống thì không kiểm tra có tồn tại hay không
            }
            pos = deptList.indexOf(new Department(deptID));
            if (pos == -1) {
                System.out.println("The departmentID is not existed in the department list"
                        + "Input another one!");
            }
        } while (pos == -1);
        lastUpdateDate = MyTool.getDate("Input last update date: ","Invalid!" );
        if (!doctorName.isEmpty()) {
            doctorList.get(pos).setDoctorName(doctorName);
        }
        if (!address.isEmpty()) {
            doctorList.get(pos).setAddress(address);
        }
        if (!deptID.isEmpty()) {
            doctorList.get(pos).setDeptID(deptID);
        }
        if (sex != null) {
            doctorList.get(pos).setSex(sex);
        }
        doctorList.get(pos).setLastUpdateDate(lastUpdateDate);
        System.out.println("The doctor information after update: ");
        System.out.println(doctorList.get(pos).toString());
    }

    public void updateDepartment() {
        String deptID, deptName;
        Date lastUpdateDate;
        deptID = MyTool.getID("Input department ID do you want update(DEPTxxxxx): ", "Department ID is  invalid!", "DEPT[0-9]{5}");
        int pos = deptList.indexOf(new Department(deptID));
        if (pos == -1) {
            System.out.println("“Department does not exist");
            return;
        }
        deptName = MyTool.getString("Input department name: ", "Invalid!", false);
        lastUpdateDate = MyTool.getDate("Input last update date: ", "Invalid!");
        if (!deptName.isEmpty()) {
            deptList.get(pos).setDepartmentName(deptName);
        }
        deptList.get(pos).setLastUpdateDate(lastUpdateDate);
        System.out.println("The department information after update: ");
        System.out.println(deptList.get(pos).toString());

    }

    public void updatePatient() {
        String patientID;
        String patientName;
        int age;
        String address;
        patientID = MyTool.getID("Input patient ID do you want update(DEPTxxxxx): ", "Patient ID is  invalid!", "DEPT[0-9]{5}");
        int pos = patientList.indexOf(new Patient(patientID));
        if (pos == -1) {
            System.out.println("Department does not exist");
            return;
        }
        patientName = MyTool.getName("Input patient name: ", "Invalid!", "^[a-zA-Z\\s]+");
        age = MyTool.getAnInteger("Input age: ", "Invalid!", 1, 120);
        address = MyTool.getString("Input address: ", "Invalid!", true);
        if (!patientName.isEmpty()) {
            patientList.get(pos).setPatientName(patientName);
        }
        if (age > 0 && age < 120) {
            patientList.get(pos).setAge(age);
        }
        if (!address.isEmpty()) {
            patientList.get(pos).setAddress(address);
        }
        System.out.println("The patient information after update: ");
        System.out.println(patientList.get(pos).toString());

    }

    public void updateExamination() {
        String examinationID;
        String doctorID;
        String patientID;
        String result;
        Date date;
        examinationID = MyTool.getID("Input examination ID do you want update(EXAMxxxxx): ", "examination ID is invalid!", "EXAM[0-9]{5}");
        int pos = examinationList.indexOf(new Examination(examinationID));
        if (pos == -1) {
            System.out.println("Examination does not exist");
            return;
        }
        do {
            doctorID = MyTool.getID("Input doctor ID(DOCxxxxx): ", "Doctor ID is invalid!", "DOC[0-9]{5}");
            if (doctorID.isEmpty()) {
                break; //nếu bỏ trống thì không kiểm tra có tồn tại hay không
            }
            pos = doctorList.indexOf(new Doctor(doctorID));
            if (pos == -1) {
                System.out.println("The doctorID is not existed in the doctor list"
                        + "Input another one!");
            }
        } while (pos == -1);
        do {
            patientID = MyTool.getID("Input patient ID(PATxxxxx): ", "Patient ID is invalid!", "PAT[0-9]{5}");
            if (patientID.isEmpty()) {
                break; //nếu bỏ trống thì không kiểm tra có tồn tại hay không
            }
            pos = patientList.indexOf(new Patient(patientID));
            if (pos == -1) {
                System.out.println("The patientID is not existed in the patient list"
                        + "Input another one!");
            }
        } while (pos == -1);
        date = MyTool.getDate("Input examination date: ", "Invalid!");
        result = MyTool.getString("Input the result: ", "Invalid!", true);
        if (!doctorID.isEmpty()) {
            examinationList.get(pos).setDoctorID(doctorID);
        }
        if (!patientID.isEmpty()) {
            examinationList.get(pos).setPatientID(patientID);
        }
        if (!result.isEmpty()) {
            examinationList.get(pos).setResult(result);
        }
        examinationList.get(pos).setDate(date);
        System.out.println("The examination information after update: ");
        System.out.println(doctorList.get(pos).toString());
    }

    //delete
    public void removeDoctor() {
        String doctorID = MyTool.getID("Input doctor ID do you want delete(DOCxxxxx): ", "Doctor ID is invalid!", "DOC[0-9]{5}");
        int pos = doctorList.indexOf(new Doctor(doctorID));
        boolean checkDoctorID = false;
        if (pos == -1) {
            System.out.println("Doctor does not exist");
            return;
        }
        for (Examination x : examinationList) { //kiểm tra xem nó có tồn tại trong doctor list ko, nếu có thì ko xóa
            if (doctorID.equalsIgnoreCase(x.getDoctorID())) {
                checkDoctorID = doctorID.equalsIgnoreCase(x.getDoctorID());
                break;
            }
        }
        boolean confirm = MyTool.getBoolean("Do you want remove this doctor? (Y/N) ", "Invalid!", false);
        if (confirm) {
            doctorList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }

    public void removeDepartment() {
        String deptID = MyTool.getID("Input department ID do you want delete(DEPTxxxxx): ", "Department ID is invalid!", "DEPT[0-9]{5}");
        int pos = deptList.indexOf(new Department(deptID));
        boolean checkDeptID = false;
        if (pos == -1) {
            System.out.println("Department does not exist");
            return;
        }
        for (Doctor x : doctorList) { //kiểm tra xem nó có tồn tại trong doctor list ko, nếu có thì ko xóa
            if (deptID.equalsIgnoreCase(x.getDeptID())) {
                checkDeptID = deptID.equalsIgnoreCase(x.getDeptID());
                break;
            }
        }
        boolean confirm = MyTool.getBoolean("Do you want remove this department? (Y/N): ", "Invalid!", false);
        if (confirm && !checkDeptID) {
            deptList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }

    public void removePatient() {
        String patientID = MyTool.getID("Input patient ID do you want delete(PATxxxxx): ", "Patient ID is invalid!", "PAT[0-9]{5}");
        int pos = patientList.indexOf(new Patient(patientID));
        boolean checkPatientID = false;
        if (pos == -1) {
            System.out.println("Patient does not exist");
            return;
        }
        for (Examination x : examinationList) { //kiểm tra xem nó có tồn tại trong doctor list ko, nếu có thì ko xóa
            if (patientID.equalsIgnoreCase(x.getPatientID())) {
                checkPatientID = patientID.equalsIgnoreCase(x.getPatientID());
                break;
            }
        }
        boolean confirm = MyTool.getBoolean("Do you want remove this patient? (Y/N) ", "Invalid!", false);
        if (confirm) {
            patientList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }

    public void removeExamination() {
        String examinationID = MyTool.getID("Input examination ID do you want delete(EXAMxxxxx): ", "Examination ID is invalid!", "EXAM[0-9]{5}");
        int pos = examinationList.indexOf(new Examination(examinationID));
        if (pos == -1) {
            System.out.println("Examination does not exist");
            return;
        }
        boolean confirm = MyTool.getBoolean("Do you want remove this examination? (Y/N) ", "Invalid!", false);
        if (confirm) {
            examinationList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }

    //search
    public ArrayList<Doctor> searchDoctorById(String doctorId) {
        ArrayList<Doctor> result = new ArrayList();
        for (Doctor x : doctorList) {
            if (doctorId.equalsIgnoreCase(x.getDoctorID())) {
                result.add(x);
            }

        }
        return result;
    }

    public void searchDoctor() {
        String doctorId = MyTool.getID("Input doctor ID(DOCxxxxx): ", "Invalid!", "DOC[0-9]{5}");
        ArrayList<Doctor> result = searchDoctorById(doctorId);
        if (result.isEmpty()) {
            System.out.println("Not found!");
        } else {
            for (Doctor x : result) {
                System.out.println(x.toString());
            }
        }
    }

    public ArrayList<Department> searchDepartmentById(String deptId) {
        ArrayList<Department> result = new ArrayList();
        for (Department x : deptList) {
            if (deptId.equalsIgnoreCase(x.getDepartmentID())) {
                result.add(x);
            }
        }

        return result;
    }

    public void searchDepartment() {
        String deptId = MyTool.getID("Input department Id do you want search(DEPTxxxxx): ", "Invalid", "DEPT[0-9]{5}");
        ArrayList<Department> result = searchDepartmentById(deptId);
        for (Department x : result) {
            System.out.println(x.toString());

        }
    }

    public ArrayList<Patient> searchPatientById(String patientId) {
        ArrayList<Patient> result = new ArrayList();
        for (Patient x : patientList) {
            if (patientId.equalsIgnoreCase(x.getPatientID())) {
                result.add(x);
            }
        }

        return result;
    }

    public void searchPatient() {
        String patientId = MyTool.getID("Input patient Id do you want search(PATxxxxx): ", "Invalid", "PAT[0-9]{5}");
        ArrayList<Patient> result = searchPatientById(patientId);
        for (Patient x : result) {
            System.out.println(x.toString());

        }
    }

    public ArrayList<Examination> searchExaminationById(String examinationId) {
        ArrayList<Examination> result = new ArrayList();
        for (Examination x : examinationList) {
            if (examinationId.equalsIgnoreCase(x.getExaminationID())) {
                result.add(x);
            }
        }

        return result;
    }

    public void searchExamination() {
        String examinationId = MyTool.getID("Input examination Id do you want search(EXAMxxxxx): ", "Invalid", "EXAM[0-9]{5}");
        ArrayList<Examination> result = searchExaminationById(examinationId);
        for (Examination x : result) {
            System.out.println(x.toString());

        }
    }
    /*public void printFromfileDoctor(){
        DoctorList tmp = new DoctorList();
        tmp.loadFromFile("doctors.dat");
        Collections.sort(tmp);
        if (tmp.isEmpty()) {
            System.out.println("The file is empty.");
        } else {
            for (Doctor doctor : tmp) {
                System.out.println(doctor);
            }
    }
    }*/
    //search name
   /* public int searchDoctorName(String name) {
        name = MyTool.getName("Enter name: ", "Name is invalid!", "[a-zA-Z]{5,}");
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getDoctorName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    //get index from input name
    public int[] searchNames(String name) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getDoctorName().contains(name)) {
                index.add(i);
            }
        }
        int[] idx = new int[index.size()];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = index.get(i);
        }
        return idx;
    }*/
    //store data
    public void saveData() {
        doctorList.writeToFile("doctors.dat");
        deptList.writeToFile("departments.dat");
        patientList.writeToFile("patients.dat");
        examinationList.writeToFile("examinations.dat");
        System.out.println("Store data sucessfully!"); //xem lại, có try catch bên DoctorList và DeptList rồi
    }
}

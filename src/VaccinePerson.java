/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SY NGUYEN
 */
public class VaccinePerson {
    
    protected String name;
    protected String code;
    protected String gender;
    protected int age;
    protected String phoneNumber;
    protected String address;
    protected String typeOfVaccine;
    protected String soLanTiem;
    protected String isSymptom;

    public VaccinePerson() {
    }

    public VaccinePerson(String name, String code, String gender, int age, String phoneNumber, String address, String typeOfVaccine, String soLanTiem, String isSymptom) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.typeOfVaccine = typeOfVaccine;
        this.soLanTiem = soLanTiem;
        this.isSymptom = isSymptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }

    public void setTypeOfVaccine(String typeOfVaccine) {
        this.typeOfVaccine = typeOfVaccine;
    }

    public String getSoLanTiem() {
        return soLanTiem;
    }

    public void setSoLanTiem(String soLanTiem) {
        this.soLanTiem = soLanTiem;
    }

    public String getIsSymptom() {
        return isSymptom;
    }

    public void setIsSymptom(String isSymptom) {
        this.isSymptom = isSymptom;
    }
    
    

    @Override
    public String toString() {
        return "Thông tin người tiêm chủng: " + "\n-Họ Tên: " + name + "\n-Mã: " + code + "\n-Giới tính: " + gender + "\n-Tuổi: " + age + "\n-Số điện thoại: " + phoneNumber + "\n-Địa chỉ: " + address + "\n-Loại Vaccine: " + typeOfVaccine +"\n-Số lần tiêm chủng: " + soLanTiem + "\n-Triệu chứng sau tiêm: " + isSymptom + "\n==========\n";
    }
    
   
    
    
    
}


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SY NGUYEN
 */
public class ManagerList extends ArrayList<VaccinePerson> {

    public ManagerList() {
        super();
    }
    
    public VaccinePerson search(String code) {
        code = code.trim().toUpperCase();
        for (VaccinePerson i : this) {
            if (i.getCode().equals(code)) {
                return i; // trả về i nếu tìm thấy
            }
        }
        return null; // trả về null nếu không tìm thấy
    }

    private boolean isCodeDuplicated(String code) { // check xem code có trùng hay không
        code = code.trim().toUpperCase();
        return search(code) != null;
    }
    
    public void addPerson() { // add new student
        String newCode, newName, newGender, newPhone, newAddress, newtypeOfVaccine, newSoLanTiem;
        int newAge;
        boolean codeDuplicated = false;
        do {
            newCode = InputterPerson.inputPattern("Mời bạn nhập mã số tiêm chủng V0000: ", "[vV][\\d]{4}"); // parttern: "[vV][\\d]{4}"
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode); // check xem code có trùng với code cữ hay không
            if (codeDuplicated) {
                System.out.println("Mã này đã bị trùng!");
            }
        } while (codeDuplicated == true);
        // create new student
        newName = InputterPerson.inputNoBlankStr("Mời bạn nhập Họ tên: ");
        newName = newName.toUpperCase();
        newGender = InputterPerson.inputNoBlankStr("Mời bạn nhập giới tính (NU/NAM): ");
        newGender = newGender.toUpperCase();
        newAge = InputterPerson.inputInt("Mời bạn nhập tuổi ", 16, 99); //mark = {12...99}
        newPhone = InputterPerson.inputNoBlankStr("Mời bạn nhập số điện thoại: ");
        newAddress = InputterPerson.inputNoBlankStr("Mời bạn nhập địa chỉ: ");
        newAddress = newAddress.toUpperCase();
        newtypeOfVaccine = InputterPerson.inputNoBlankStr("Mời bạn nhập loại vaccine phù hợp muốn tiêm sau: " + "\n" + "AstraZeneca (2 liều/hiệu nghiệm: 65-95%" + "\n" + "Pfizer (2 liều/hiệu nghiệm: 95.3%" + "\n" + "Moderna (2 liều/hiệu nghiệm: 90%" + "\n" + "Sputnik V (2 liều/hiệu nghiệm: 92%");
        newtypeOfVaccine = newtypeOfVaccine.toUpperCase();
        newSoLanTiem = InputterPerson.inputNoBlankStr("Mời bạn nhập số tiêm: ");
        VaccinePerson p = new VaccinePerson(newName, newCode, newGender, newAge, newPhone, newAddress, newtypeOfVaccine, newSoLanTiem);
        this.add(p); // add new person tiêm vaccine
        System.out.println("\nBạn " + newName + ", Mã" + newCode + " đã đăng kí tiêm vaccine " + newtypeOfVaccine + " thành công.");
    }
    
    public void searchPerson() { //search student by code
        if (this.isEmpty()) {
            System.out.println("Empty list, No search can be performed!");
        } else {
            String sCode = InputterPerson.inputStr("Mời bạn nhập mã số tiêm chủng: ");
            VaccinePerson st = this.search(sCode);
            if (st == null) {
                System.out.println("Người có mã " + sCode + " không tồn tại!");
            } else {
                System.out.println("Tìm thấy mã: " + sCode + "\n" + st);
            }
        }
    }

    /*public void updateStudent() { //update name and mark of student's by code
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uCode = InputterPerson.inputStr("Input code of updated student: ");
            VaccinePerson st = this.search(uCode); //search student
            if (st == null) {
                System.out.println("Student " + uCode + " doesn't existed!");
            } else {
                String oldName = st.getName(); // updated name
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = InputterPerson.inputNoBlankStr(msg);
                st.setName(newName);
                int oldMark = st.getMark(); // updated mark
                msg = "Old mark: " + oldMark + ", new mark 0...10: ";
                int newMark = InputterPerson.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Studenrs " + uCode + " has been updated.");
            }
        }
    }*/

    public void removeStudent() { //remove name and mark of student's by code
        if (this.isEmpty()) {
            System.out.println("Empty list. No remove can be performed!");
        } else {
            String rCode = InputterPerson.inputStr("Input code of removed student: ");
            VaccinePerson st = this.search(rCode); //search student
            if (st == null) {
                System.out.println("Student " + rCode + " doesn't existed!");
            } else {
                this.remove(st); // gọi đến hàm remove trong ArrayList
                System.out.println("Student " + rCode + " has been removed");
            }
        }
    }
    
    public void displayAll() { //in ra màn hình list person tiêm vaccine
        if (this.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            System.out.println("\n" + "==================== Danh sách người tiêm chủng, đang chờ tiêm chủng Vaccine Convid-19 ====================");
            for (VaccinePerson p : this) {
                System.out.println(p);
            }
            System.out.println("Total: " + this.size() + " người.");
        }
    }
    
    
    
    
}

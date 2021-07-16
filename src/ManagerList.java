
import java.util.ArrayList;
import java.util.Scanner;

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
    
    Scanner sc = new Scanner(System.in);

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

    public void khaiBaoThongTin() { // add new student
        String newCode, newName, newGender, newPhone, newAddress, newtypeOfVaccine, newSoLanTiem, newIsSymton;
        int newAge;
        boolean codeDuplicated = false;
        do {
            newCode = InputterManager.inputPattern("Mời bạn nhập mã số tiêm chủng V0000: ", "[vV][\\d]{4}"); // parttern: "[vV][\\d]{4}"
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode); // check xem code có trùng với code cữ hay không
            if (codeDuplicated) {
                System.out.println("Mã này đã bị trùng!");
            }
        } while (codeDuplicated == true);
        // create new student
        newName = InputterManager.inputNoBlankStr("Mời bạn nhập họ tên: ");
        newName = newName.toUpperCase();
        newGender = InputterManager.inputNoBlankStr("Mời bạn nhập giới tính (NU/NAM): ");
        newGender = newGender.toUpperCase();
        newAge = InputterManager.inputInt("Mời bạn nhập tuổi ", 16, 99);
        newPhone = InputterManager.inputNoBlankStr("Mời bạn nhập số điện thoại: ");
        newAddress = InputterManager.inputNoBlankStr("Mời bạn nhập địa chỉ: ");
        newAddress = newAddress.toUpperCase();
        newtypeOfVaccine = InputterManager.inputNoBlankStr("Mời bạn nhập loại vaccine tiêm phù hợp sau: " + "\n" + "AstraZeneca (2 liều/hiệu nghiệm: 65-95%" + "\n" + "Pfizer (2 liều/hiệu nghiệm: 95.3%" + "\n" + "Moderna (2 liều/hiệu nghiệm: 90%" + "\n" + "Sputnik V (2 liều/hiệu nghiệm: 92%");
        newtypeOfVaccine = newtypeOfVaccine.toUpperCase();
        newSoLanTiem = InputterManager.inputNoBlankStr("Mời bạn nhập số lần tiêm: ");
        newIsSymton = InputterManager.inputNoBlankStr("Mời bạn nhập triệu chứng sau tiêm: ");
        VaccinePerson vp = new VaccinePerson(newName, newCode, newGender, newAge, newPhone, newAddress, newtypeOfVaccine, newSoLanTiem, newIsSymton);
        this.add(vp); // add new person tiêm vaccine
        System.out.println("\nBạn: " + newName + ", Mã: " + newCode + " đã thêm vào danh sách tiêm vaccine: " + newtypeOfVaccine + " thành công.");
    }

    public void searchPerson() { //search student by code
        if (this.isEmpty()) {
            System.out.println("Danh sách trống, không có dữ liệu tìm kiếm!");
        } else {
            String sCode = InputterManager.inputStr("Mời bạn nhập mã số tiêm chủng: ");
            VaccinePerson vp = this.search(sCode);
            if (vp == null) {
                System.out.println("Người có mã " + sCode + " không tồn tại!");
            } else {
                System.out.println("Tìm thấy mã: " + sCode + "\n" + vp);
            }
        }
    }
    
    public void SearchUpdate() {
        if (this.isEmpty()) {
            System.out.println("Danh sách trống, không có dữ liệu để cập nhật!");
        } else {
            String uCode = InputterManager.inputStr("Mời bạn nhập mã số tiêm chủng muốn cập nhật: ");
            VaccinePerson vp = this.search(uCode); //search person
            if (vp == null) {
                System.out.println("Mã " + uCode + " không tồn tại!");
            } else {
                System.out.println("Hệ thống tìm thấy mã: " + uCode);
                System.out.println(vp);
            }
        }

    }

    public void AcceptUpdatePerson() { //update name and mark of student's by code
        if (this.isEmpty()) {
            System.out.println("Danh sách trống, không có dữ liệu để cập nhật!");
        } else {
            String uCode = InputterManager.inputStr("Mời bạn nhập lại mã số tiêm chủng muốn cập nhật để xác nhận cập nhật: ");
            VaccinePerson vp = this.search(uCode); //search person
            if (vp == null) {
                System.out.println("Hệ thống xóa không thành công");
            } else {
                int oldAge = vp.getAge();
                String ups = "Tuổi cũ: " + oldAge + ", tuổi hiện tại: ";
                int newAge = InputterManager.inputInt(ups, 16, 99);
                vp.setAge(newAge);
                String oldPhone = vp.getPhoneNumber();
                ups = "Số điện thoại cũ: " + oldPhone + ", số điện thoại hiện tại: ";
                String newPhone = InputterManager.inputNoBlankStr(ups);
                vp.setPhoneNumber(newPhone);
                String oldAddress = vp.getAddress();
                ups = "Địa chỉ cũ: " + oldAddress + ", địa chỉ hiện tại: ";
                String newAddress = InputterManager.inputNoBlankStr(ups);
                vp.setAddress(newAddress);
                String oldSoLanTiem = vp.getSoLanTiem();
                ups = "Số lần đã tiêm : " + oldSoLanTiem + ", số lần tiêm hiện tại hiện tại: ";
                String newSoLanTiem = InputterManager.inputNoBlankStr(ups);
                vp.setSoLanTiem(newSoLanTiem);
                String oldSymton = vp.getIsSymptom();
                ups = "Triệu chứng cũ: " + oldSymton + ", triệu chứng hiện tại: ";
                String newSymton = InputterManager.inputNoBlankStr(ups);
                vp.setIsSymptom(newSymton);
                System.out.println("Mã " + uCode + " đã được hệ thống cập nhật thành công!");
                System.out.println(vp);
            }
        }
    }

    public void SearchRemovePerson() { //tìm remove người tiêm theo mã code khỏi hệ thống
        if (this.isEmpty()) {
            System.out.println("Danh sách trống, không có dữ liệu để xóa!");
        } else {
            String SrCode = InputterManager.inputStr("Mời bạn nhập mã số tiêm chủng muốn xóa: ");
            VaccinePerson vp = this.search(SrCode); //search person
            if (vp == null) {
                System.out.println("Mã: " + SrCode + " không tồn tại!");
            } else {
                System.out.println("Hệ thống tìm thấy mã: " + SrCode);
                System.out.println(vp);
            }
        }
    }
    
    public void AcceptRemovePerson() { //remove người tiêm theo mã code khỏi hệ thống
        if (this.isEmpty()) {
            System.out.println("Danh sách trống, không có dữ liệu để xóa!");
        } else {
            String ArCode = InputterManager.inputStr("Mời bạn nhập lại mã để xác nhận xóa: ");
            VaccinePerson vp = this.search(ArCode); //search person
            if (vp == null) {
                System.out.println("Hệ thống xóa không thành công!");
            } else {
                this.remove(vp);
                System.out.println("Hệ thống đã xóa mã: " + ArCode + " thành công!");
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

    void initSampleData() {
        VaccinePerson vp1 = new VaccinePerson("Nguyen Van Sy", "V1234", "Nam", 20, "0346823016", "Hai Phong", "Pfizer", "2", "Sức khỏe tốt.");
        this.add(vp1);
        VaccinePerson vp2 = new VaccinePerson("Ngo Doan Luan", "V4321", "Nam", 20, "0225374432", "Hai Phong", "AstraZeneca", "2", "Sức khỏe tốt.");
        this.add(vp2);
        this.displayAll();
    }

}

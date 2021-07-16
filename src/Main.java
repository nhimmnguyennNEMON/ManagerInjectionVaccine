
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManagerList list = new ManagerList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Chào mừng bạn đến với hệ thống 'Quản lí tiêm Vaccine Covid-19 version 2021' của OneTeam =====\n");
            System.out.println("Các chúc năng của hệ thống:");
            System.out.println("0. Khởi tạo người tiêm Vaccin Covid-19 có sẵn.");
            System.out.println("1. Khai báo thông tin người tiêm Vaccin Covid-19.");
            System.out.println("2. Tìm kiếm thông tin người tiêm Vaccin Covid-19.");
            System.out.println("3. Toàn bộ danh sách những người đã tiêm Vaccin Covid-19");
            System.out.println("4. Cập nhật thông tin người đãctiêm Vaccin Covid-19.");
            System.out.println("5. Xóa thông tin người đã tiêm Vaccin Covid-19 ");
            System.out.println("6. Thoát hệ thống");
            System.out.print("Mời nhập chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    list.initSampleData();
                    break;
                case 1:
                    list.khaiBaoThongTin();
                    break;
                case 2:
                    list.searchPerson();
                    break;
                case 3:
                    list.displayAll();
                    break;
                case 4:
                    list.SearchUpdate();
                    Scanner scu = new Scanner(System.in);
                    System.out.println("Vì lí đồng bộ thông tin phải chính xác với hệ thống bộ.");
                    System.out.println("Nên bạn chỉ có thể cập nhât: Tuổi, số điện thoại, địa chỉ, số lần tiêm, triệu chứng.");
                    System.out.println("Bạn có muốn cấp nhật thông tin người đã tiêm Vaccine này không? (c|k)");
                    System.out.print("Trả lời: ");
                    if (scu.nextLine().equalsIgnoreCase("c")) {
                        list.AcceptUpdatePerson();
                    }
                    else {
                        System.out.println("Hệ thống cập nhật không thành công!");
                    }
                    break;
                case 5:
                    list.SearchRemovePerson();
                    Scanner scr = new Scanner(System.in);
                    System.out.println("Bạn có muốn xóa người đã tiêm Vaccine này không? (c|k)");
                    System.out.print("Trả lời: ");
                    if (scr.nextLine().equalsIgnoreCase("c")) {
                        list.AcceptRemovePerson();
                    }
                    else {
                        System.out.println("Hệ thống xóa không thành công!");
                    }
                    break;
            }
        } while (choice <= 5);
    }

}

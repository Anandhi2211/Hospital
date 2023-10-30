package main.java.com.solvd.hospital.department;

public class Department {
    private String departmentName;
    private String departmentCode;


    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
   /* public static void main(String[] args) {

    if (args != null) {
        for (int argInx = 0; argInx < args.length; argInx++) {
            System.out.println("Arg " + argInx + " : " + args[argInx]);
        }
    }

        System.out.println("Hello world!");
    }*/
}

package model;
public class NhanVien {
    public int nvId;
    public String name;
    public String email;
    public String address;
    public int phoneNumber;
    public int salary;
    public String department;
    public NhanVien(String name, String email, String address, int phoneNumber, int salary, String department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }
    public NhanVien(int id, String name, String email, String address, int phoneNumber, int salary, String department) {
        this.nvId = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }
    public int getNvId() {
        return nvId;
    }
    public void setNvId(int nvId) {
        this.nvId = nvId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author black
 */
public class User {

    private int id;
    private int roleId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String fullName;
    private String city;
    private String district;
    private String ward;
    private String avatar;

    public User() {
    }

    public User(int id, int roleId, String username, String password, String email, String phoneNumber, String address, String fullName, String city, String district, String ward, String avatar) {
        this.id = id;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.fullName = fullName;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.avatar = avatar;
    }

    public User(String username, String email, String fullName, String avatar) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.avatar = avatar;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", roleId=" + roleId + ", username=" + username + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", fullName=" + fullName + ", city=" + city + ", district=" + district + ", ward=" + ward + ", avatar=" + avatar + '}';
    }

}

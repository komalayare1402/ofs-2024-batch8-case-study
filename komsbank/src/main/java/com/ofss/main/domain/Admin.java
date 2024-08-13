package com.ofss.main.domain;

public class Admin {
    private int adminId;
    private int adminLoginId;
    private String adminPassword;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getAdminLoginId() {
        return adminLoginId;
    }

    public void setAdminLoginId(int adminLoginId) {
        this.adminLoginId = adminLoginId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
    
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}

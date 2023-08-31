package com.wint.User.Entitys;

public enum UserRoleENUM {
    USER("user");

    private String role;

    UserRoleENUM(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

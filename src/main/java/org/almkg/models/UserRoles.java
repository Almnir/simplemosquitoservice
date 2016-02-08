package org.almkg.models;

/**
 * Created by yarnykh on 02.02.2016.
 * Таблица ролей
 */
public class UserRoles {

    public static final String TABLE_NAME = "user_roles";
    public static final String ID_FIELD = "role_id";
    public static final String USER_FIELD = "user_id";
    public static final String ROLE_FIELD = "role";

    private int role_id;

    private int user_id;
    private int role;

    public UserRoles(int user_id, int role) {
        this.user_id = user_id;
        this.role = role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}

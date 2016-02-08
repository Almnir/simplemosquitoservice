package org.almkg.models;

/**
 * Created by yarnykh on 02.02.2016.
 * Сущность определяет те действия, которые разрешены ролям
 */
public class RolesPermissions {
    public static final String TABLE_NAME = "roles_perms";
    public static final String ID_FIELD = "rp_id";

    public static final String ROLE_FIELD = "role";
    public static final String PERMISSSION_FIELD = "perm";

    private int rp_id;

    private int role_id;
    private int perm;

    public RolesPermissions(int role_id, int perm) {
        this.role_id = role_id;
        this.perm = perm;
    }

    public int getRp_id() {
        return rp_id;
    }

    public void setRp_id(int rp_id) {
        this.rp_id = rp_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }
}

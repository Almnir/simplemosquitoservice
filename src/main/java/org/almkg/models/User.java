package org.almkg.models;

/**
 * Created by yarnykh on 26.01.2016.
 * Таблица пользователей
 */
public class User {

    public static final String TABLE_NAME = "users";
    public static final String ID_FIELD = "id";
    public static final String LOGIN_FIELD = "login";
    public static final String PASSWORD_FIELD = "passwd";
    public static final String PASSWORD_SALT_FIELD = "passwd_salt";
    public static final String NAME_FIELD = "name";

    private int id;
    private String login;
    private String password;
    private String passwordSalt;
    private String name;

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.name = builder.name;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getPasswordSalt() { return passwordSalt; }
    public String getName() {
        return name;
    }
    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static class UserBuilder {
        private int id;
        private String login;
        private String password;
        private String passwordSalt;
        private String name;

        public UserBuilder(int id) {
            this.id = id;
        }
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder setPasswordSalt(String passwordSalt) {
            this.passwordSalt = passwordSalt;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}

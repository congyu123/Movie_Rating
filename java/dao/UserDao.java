package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    public User findUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanHandler<>(User.class), username);
        }
    }

    public void saveUser(User user) throws SQLException {
        String sql = "INSERT INTO users(username, password, gender, email, telephone, introduce, activeCode, state, role, registTime) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRole(), user.getRegistTime());
        }
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET password = ?, gender = ?, email = ?, telephone = ?, introduce = ?, activeCode = ?, state = ?, role = ?, registTime = ? WHERE username = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRole(), user.getRegistTime(), user.getUsername());
        }
    }
}

package dao;

import entity.Comment;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentDao {

    public List<Comment> findCommentsByMovie(String movieName) throws SQLException {
        String sql = "SELECT * FROM comments WHERE movieName = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanListHandler<>(Comment.class), movieName);
        }
    }

    public void saveComment(Comment comment) throws SQLException {
        String sql = "INSERT INTO comments(userName, movieName, description, addTime) VALUES(?,?,?,?)";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, comment.getUserName(), comment.getMovieName(), comment.getDescription(), comment.getAddTime());
        }
    }

    public void deleteComment(String userName, String movieName) throws SQLException {
        String sql = "DELETE FROM comments WHERE userName = ? AND movieName = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, userName, movieName);
        }
    }
}

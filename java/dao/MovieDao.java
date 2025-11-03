package dao;

import entity.Movie;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MovieDao {

    public List<Movie> findAllMovies() throws SQLException {
        String sql = "SELECT * FROM allmovies GROUP BY name";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanListHandler<>(Movie.class));
        }
    }

    public List<Movie> findMoviesByCategoryWithLimit(String category) throws SQLException {
        String sql = "SELECT * FROM allmovies WHERE type = ? LIMIT 0,12";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanListHandler<>(Movie.class), category);
        }
    }

    public Movie findMovieById(int id) throws SQLException {
        String sql = "SELECT * FROM allmovies WHERE id = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanHandler<>(Movie.class), id);
        }
    }

    public void deleteMovieById(int id) throws SQLException {
        String sql = "DELETE FROM allmovies WHERE id = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, id);
        }
    }
}

package dao;

import entity.Collection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CollectionDao {

    public List<Collection> findCollectionsByUser(String userName) throws SQLException {
        String sql = "SELECT * FROM collection WHERE userName = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new BeanListHandler<>(Collection.class), userName);
        }
    }

    public void saveCollection(Collection collection) throws SQLException {
        String sql = "INSERT INTO collection(userName, movieName, addTime) VALUES(?,?,?)";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, collection.getUserName(), collection.getMovieName(), collection.getAddTime());
        }
    }

    public void deleteCollection(String userName, String movieName) throws SQLException {
        String sql = "DELETE FROM collection WHERE userName = ? AND movieName = ?";
        try (Connection conn = DataBaseUtils.getConnection()) {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, userName, movieName);
        }
    }
}

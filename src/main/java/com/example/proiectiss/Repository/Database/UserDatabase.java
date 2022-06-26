package com.example.proiectiss.Repository.Database;

import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Repository.JdbcUtils;
import com.example.proiectiss.Repository.RepoUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//public class AngajatDatabase implements Repo<Long, Angajat> {
public class UserDatabase implements RepoUser {


    private static final Logger logger = LogManager.getLogger();
    private JdbcUtils dbUtils;

    public UserDatabase(Properties props) {
        logger.info("Initializing UserRepo with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public User findOne(Long id2) {

        return null;
    }

    @Override
    public Iterable<User> findAll() {

        return null;
    }

    @Override
    public void save(User elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into User (username,password,rol) values (?,?,?)")) {
            preStmt.setString(1, elem.getUsername());
            preStmt.setString(2, elem.getPassword());
            preStmt.setString(3, elem.getRol());
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB" + ex);
        }
        logger.traceExit();


    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, User elem) {

    }

    public User findOneByUsername(String name) {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from User")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    String rol = result.getString("rol");


                    if (username.equals(name)) {
                        User user = new User(username, password, rol);
                        user.setId(Long.valueOf(id));
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit();
        return null;
    }


}

package com.example.proiectiss.Repository.Database;

import com.example.proiectiss.Domain.Loc;
import com.example.proiectiss.Repository.JdbcUtils;
import com.example.proiectiss.Repository.RepoLoc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//public class LocDatabase implements Repo<Long, Loc> {
public class LocDatabase implements RepoLoc {


    private static final Logger logger = LogManager.getLogger();
    private JdbcUtils dbUtils;

    public LocDatabase(Properties props) {
        logger.info("Initializing EventRepo with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public Loc findOne(Long id2) {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Locuri")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    int loc = result.getInt("loc");
                    int loja = result.getInt("loja");
                    int rand = result.getInt("rand");
                    String disponibilitate = result.getString("disponibilitate");
                    int pret = result.getInt("pret");


                    if (id == id2) {
                        Loc l = new Loc(loc, loja, rand, disponibilitate, pret);
                        l.setId(Long.valueOf(id));
                        return l;
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

    @Override
    public Iterable<Loc> findAll() {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Loc> locuri = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Locuri")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    int loc = result.getInt("loc");
                    int loja = result.getInt("loja");
                    int rand = result.getInt("rand");
                    String disponibilitate = result.getString("disponibilitate");
                    int pret = result.getInt("pret");
                    Loc l = new Loc(loc, loja, rand, disponibilitate, pret);
                    l.setId(Long.valueOf(id));
                    locuri.add(l);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit(locuri);
        return locuri;


    }

    @Override
    public void save(Loc elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into Locuri (loc, loja, rand, disponibilitate, pret) values (?,?,?,?,?)")) {
            preStmt.setLong(1, elem.getLoc());
            preStmt.setLong(2, elem.getLoja());
            preStmt.setLong(3, elem.getRand());
            preStmt.setString(4, elem.getDisponibilitate());
            preStmt.setLong(5, elem.getPret());
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

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM Locuri WHERE id=(?)")) {
            preStmt.setLong(1, id);
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB" + ex);
        }
        logger.traceExit();


    }

    @Override
    public void update(Long id, Loc elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("update Locuri set loc=(?),loja=(?),rand=(?),disponibilitate=(?),pret=(?) where id=(?)")) {
            preStmt.setLong(1, elem.getLoc());
            preStmt.setLong(2, elem.getLoja());
            preStmt.setLong(3, elem.getRand());
            preStmt.setString(4, elem.getDisponibilitate());
            preStmt.setLong(5, elem.getPret());
            preStmt.setLong(6, id);
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB" + ex);
        }
        logger.traceExit();


    }


    @Override
    public Loc findOneByLoc(Long locnr) {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Locuri")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    int loc = result.getInt("loc");
                    int loja = result.getInt("loja");
                    int rand = result.getInt("rand");
                    String disponibilitate = result.getString("disponibilitate");
                    int pret = result.getInt("pret");


                    if (loc == locnr) {
                        Loc l = new Loc(loc, loja, rand, disponibilitate, pret);
                        l.setId(Long.valueOf(id));
                        return l;
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

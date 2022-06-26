package com.example.proiectiss.Repository.Database;

import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Repository.JdbcUtils;
import com.example.proiectiss.Repository.RepoRezervare;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//public class RezervareDatabase implements Repo<Long, Rezervare> {
public class RezervareDatabase implements RepoRezervare {


    private static final Logger logger = LogManager.getLogger();
    private JdbcUtils dbUtils;

    public RezervareDatabase(Properties props) {
        logger.info("Initializing EventRepo with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public Rezervare findOne(Long id2) {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Rezervare")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String prenume = result.getString("prenume");
                    String locuri = result.getString("locuri");
                    int pret = result.getInt("pret");
                    String paid = result.getString("paid");


                    if (id == id2) {
                        Rezervare rez = new Rezervare(nume, prenume, locuri, pret, paid);
                        rez.setId(Long.valueOf(id));
                        return rez;
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
    public Iterable<Rezervare> findAll() {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Rezervare> rezervari = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Rezervare")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String prenume = result.getString("prenume");
                    String locuri = result.getString("locuri");
                    int pret = result.getInt("pret");
                    String paid = result.getString("paid");

                    Rezervare rez = new Rezervare(nume, prenume, locuri, pret, paid);
                    rez.setId(Long.valueOf(id));
                    rezervari.add(rez);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit(rezervari);
        return rezervari;


    }

    @Override
    public void save(Rezervare elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into Rezervare (nume, prenume, locuri,pret, paid) values (?,?,?,?,?)")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getPrenume());
            preStmt.setString(3, elem.getLocuri());
            preStmt.setLong(4, elem.getPret());
            preStmt.setString(5, elem.getPaid());
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
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM Rezervare WHERE id=(?)")) {
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
    public void update(Long id, Rezervare elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("update Rezervare set nume=(?),prenume=(?),locuri=(?),pret=(?),paid=(?) where id=(?)")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getPrenume());
            preStmt.setString(3, elem.getLocuri());
            preStmt.setLong(4, elem.getPret());
            preStmt.setString(5, elem.getPaid());
            preStmt.setLong(6, id);
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB" + ex);
        }
        logger.traceExit();


    }

    public Rezervare findOneByLocuri(String locuri1) {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Rezervare")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String prenume = result.getString("prenume");
                    String locuri = result.getString("locuri");
                    int pret = result.getInt("pret");
                    String paid = result.getString("paid");


                    if (locuri1.equals(locuri)) {
                        Rezervare rez = new Rezervare(nume, prenume, locuri, pret, paid);
                        rez.setId(Long.valueOf(id));
                        return rez;
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

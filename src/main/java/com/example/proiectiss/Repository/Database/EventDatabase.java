package com.example.proiectiss.Repository.Database;

import com.example.proiectiss.Domain.Event;
import com.example.proiectiss.Repository.JdbcUtils;
import com.example.proiectiss.Repository.RepoEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//public class EventDatabase implements Repo<Long, Event> {
public class EventDatabase implements RepoEvent {


    private static final Logger logger = LogManager.getLogger();
    private JdbcUtils dbUtils;

    public EventDatabase(Properties props) {
        logger.info("Initializing EventRepo with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public Event findOne(Long id2) {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Event")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String descriere = result.getString("descriere");
                    int locuri = result.getInt("locuri");


                    if (id == id2) {
                        Event ev = new Event(nume, descriere, Math.toIntExact(locuri));
                        ev.setId(Long.valueOf(id));
                        return ev;
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
    public Iterable<Event> findAll() {

        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Event> events = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Event")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String descriere = result.getString("descriere");
                    int locuri = result.getInt("locuri");

                    Event ev = new Event(nume, descriere, Math.toIntExact(locuri));
                    ev.setId(Long.valueOf(id));
                    events.add(ev);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit(events);
        return events;


    }

    @Override
    public void save(Event elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into Event (nume, descriere, locuri) values (?,?,?)")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getDescriere());
            preStmt.setLong(3, elem.getLocuri());
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
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM Event WHERE id=(?)")) {
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
    public void update(Long id, Event elem) {

        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("update Event set nume=(?),descriere=(?),locuri=(?) where id=(?)")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getDescriere());
            preStmt.setLong(3, elem.getLocuri());
            preStmt.setLong(4, id);
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB" + ex);
        }
        logger.traceExit();


    }


}

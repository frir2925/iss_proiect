package com.example.proiectiss.Service;

import com.example.proiectiss.Domain.Event;
import com.example.proiectiss.Domain.Loc;
import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Domain.User;

public class SuperService {
    private UserService userService;
    private EventService eventService;
    private LocService locService;
    private RezervareService rezervareService;

    public SuperService(UserService userService, EventService eventService, LocService locService, RezervareService rezervareService) {
        this.userService = userService;
        this.eventService = eventService;
        this.locService = locService;
        this.rezervareService = rezervareService;

    }


    public User getUserByUsername(String username) {
        return userService.getByUsername(username);
    }

    public void saveUser(User user) {
        userService.save(user);
    }

    public void saveEvent(String nume, String descriere, int locuri) {
        eventService.save(new Event(nume, descriere, locuri));
    }

    public Iterable<Event> getAllEvents() {
        return eventService.getAll();
    }

    public void clearEvent() {
        eventService.clearEvent();
    }

    public void updateEvent(Long id, Event event) {
        eventService.update(id, event);
    }

    public void saveLoc(Loc loc) {
        locService.save(loc);
    }

    public Loc getLocByLoc(Long loc) {
        return locService.findOneByLoc(loc);
    }

    public Iterable<Loc> getAllLocuri() {
        return locService.getAll();
    }

    public Iterable<Rezervare> getAllRezervari() {
        return rezervareService.getAll();
    }

    public void saveRezervare(Rezervare rez) {
        rezervareService.save(rez);
    }

    public void updateLoc(Long id, Loc elem) {
        locService.update(id, elem);
    }

    public void deleteRezervare(Long id) {
        rezervareService.delete(id);
    }

    public void updateRezervare(Long id, Rezervare elem) {
        rezervareService.update(id, elem);
    }

    public Rezervare findOneRezervareByLocuri(String locuri) {
        return rezervareService.findOneByLocuri(locuri);
    }
}

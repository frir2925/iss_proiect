package com.example.proiectiss.Service;

import com.example.proiectiss.Domain.Event;
import com.example.proiectiss.Repository.RepoEvent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EventService {
    private RepoEvent eventRepository;

    public EventService(RepoEvent eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    public void clearEvent() {
        List<Event> result = StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        if (result.size() == 1) {
            Event first = result.get(0);
            eventRepository.delete(first.getId());
        }
    }

    public void update(Long id, Event event) {
        eventRepository.update(id, event);
    }


}

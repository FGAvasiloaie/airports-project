package ro.favasiloaie.airports.service.implementation;

import org.springframework.stereotype.Service;
import ro.favasiloaie.airports.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public String transformName(final String name) {
        return name.toUpperCase();
    }
}

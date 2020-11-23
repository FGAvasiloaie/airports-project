package ro.favasiloaie.airports.service;

import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Message;
import ro.favasiloaie.airports.model.Search;

import java.util.List;

public interface MessageService {
    Message insertIntoDatabase(Message message);

}

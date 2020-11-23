package ro.favasiloaie.airports.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.favasiloaie.airports.model.Message;
import ro.favasiloaie.airports.repository.MessageRepository;
import ro.favasiloaie.airports.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message insertIntoDatabase(final Message message) {
        return messageRepository.save(message);
    }

}

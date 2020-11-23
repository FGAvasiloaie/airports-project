package ro.favasiloaie.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}

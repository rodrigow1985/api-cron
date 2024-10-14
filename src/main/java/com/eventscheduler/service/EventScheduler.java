import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventScheduler {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

    @Scheduled(fixedRate = 60000)  // Cada minuto
    public void checkAndTriggerEvents() {
        List<Event> events = eventRepository.findByEventTimeBefore(LocalDateTime.now());

        for (Event event : events) {
            kafkaMessageSender.sendMessage("Evento disparado: " + event.getCode());
            eventRepository.delete(event);  // Elimina el evento después de dispararlo
        }
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id).get();
    }

    /* TODO */
    /* @GetMapping("/{app}")
    public User getUserById(@PathVariable Long id) {
        //return userRepository.get;
    }*/

    @PostMapping
    public Event createEvent(@RequestParam String code, @RequestParam String app, @RequestParam LocalDateTime time) {
        Event event = new Event();
        event.setCode(code);
        event.setApp(app);
        event.setTime(time);  // Asegúrate de enviar el tiempo en el formato correcto
        return eventRepository.save(event);
    }
}

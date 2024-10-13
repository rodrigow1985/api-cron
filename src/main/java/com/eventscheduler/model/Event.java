import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="code")
    private String code;

    @Column(name="app")
    private String app;
    
    @Column(name="time")
    private LocalDateTime eventTime;  // La hora en la que debe ser disparado el evento

    // Getters y setters
    public Long getId() {
        return this.id;
    }
    public Long getCode() {
        return this.Code;
    }
    public Long getTime() {
        return this.time;
    }
    public Long setId(id) {
        this.id = Long id;
    }
    public Long setCode(code) {
        this.code = Long code;
    }
    public Long setId(time) {
        this.time = Long time;
    }
}
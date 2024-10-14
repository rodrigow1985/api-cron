import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Table;

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
    private LocalDateTime time;  // La hora en la que debe ser disparado el evento

    // Getters y setters
    public Long getId() {
        return this.id;
    }
    public String getCode() {
        return this.code;
    }
    public String getApp() {
        return this.app;
    }
    public LocalDateTime getTime() {
        return this.time;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setApp(String app) {
        this.app = app;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
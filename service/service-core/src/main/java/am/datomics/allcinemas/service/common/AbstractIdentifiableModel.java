package am.datomics.allcinemas.service.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractIdentifiableModel {

    @Id
    private String id;

    private LocalDateTime created;

    private LocalDateTime updated;

}

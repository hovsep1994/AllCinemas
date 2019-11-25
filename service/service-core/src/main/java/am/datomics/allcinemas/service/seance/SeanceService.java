package am.datomics.allcinemas.service.seance;

import am.datomics.allcinemas.service.seance.dto.SeanceDto;
import am.datomics.allcinemas.service.seance.model.Seance;

public interface SeanceService {

    Seance create(SeanceDto seanceDto);

}

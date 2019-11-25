package am.datomics.allcinemas.scraper;

import am.datomics.allcinemas.service.seance.dto.SeanceDto;

public interface Scraper {

    SeanceDto scrape();

}

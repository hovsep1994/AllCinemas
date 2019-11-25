package am.datomics.allcinemas.scraper;

import am.datomics.allcinemas.service.seance.dto.SeanceDto;
import org.springframework.stereotype.Component;

@Component
public class KinoparkScraper implements Scraper{

    @Override
    public SeanceDto scrape() {
        return null;
    }

}

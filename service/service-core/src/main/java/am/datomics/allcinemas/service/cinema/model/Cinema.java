package am.datomics.allcinemas.service.cinema.model;

import am.datomics.allcinemas.service.common.AbstractIdentifiableModel;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cinema extends AbstractIdentifiableModel {

    private String name;


}

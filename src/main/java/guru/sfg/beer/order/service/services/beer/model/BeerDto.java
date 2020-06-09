package guru.sfg.beer.order.service.services.beer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by frank on 27.11.19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {

    static final long serialVersionUID = 614366374635289534L;

    private UUID id = null;
    private Integer version = null;

    @Null
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private String beerStyle;
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Integer quantityOnHand;
}

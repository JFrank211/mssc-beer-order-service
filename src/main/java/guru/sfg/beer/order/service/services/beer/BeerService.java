package guru.sfg.beer.order.service.services.beer;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by frank on 09.06.20
 */

public interface BeerService {

    Optional<BeerDto> getBeerById(UUID beerId);

    Optional<BeerDto> getBeerByUpc(String upc);
}

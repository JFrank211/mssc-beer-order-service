package guru.sfg.beer.order.service.services.beer;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by frank on 09.06.20
 */

@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)
@Component

public class BeerServiceRestTemplateImpl implements BeerService {

    private final String BEER_PATH = "/api/v1/beer/";
    private final String BEER_UPC_PATH = "/api/v1/beerUpc/";

    private RestTemplate restTemplate;

    private String beerServiceHost;

    public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID beerId) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_PATH + beerId, BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        log.debug("getBeerByUpc(" + upc + ")");
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH + upc, BeerDto.class));
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }
}

//package org.example;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.List;
//import java.util.UUID;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class ClassUnderTest {
//    private final TestConfig testConfig;
//    private final WebClient client;
//
//    public Mono<List<Ranks>> getRanksForId(UUID id) {
//        log.info("Calling Endpoint for id {}", id);
//        Instant start = Instant.now();
//        return client.get()
//            .uri(testConfig.getUri() + "/testpath",
//                uri -> uri.queryParam("simple_id", id).build())
//            .accept(MediaType.APPLICATION_JSON).header("x-api-key", testConfig.getApiKey())
//            .retrieve().bodyToMono(new ParameterizedTypeReference<List<Ranks>>() {
//            })
//            .doOnNext(r -> log.info("Endpoint time taken {}ms for id {}",
//                ChronoUnit.MILLIS.between(start, Instant.now()), id))
//            .doOnError(e -> log.error("Endpoint call ran into an error for id {}", id, e));
//    }
//}

package hyperpaint.nerf_exporter;

import hyperpaint.nerf_exporter.config.NerfExporterConfig;
import hyperpaint.nerf_exporter.dto.Populations;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@RestController
public class AppController {
    private final NerfExporterConfig nerfExporterConfig;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/metrics")
    public ResponseEntity<String> metrics() {
        final ResponseEntity<Populations> responseEntity = restTemplate.getForEntity(nerfExporterConfig.getApi(), Populations.class);

        if (responseEntity.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseEntity.getBody().toMetrics(), HttpStatus.OK);
    }
}

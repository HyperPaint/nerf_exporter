package hyperpaint.nerf_exporter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class Populations implements Serializable {
    private List<Population> populations;

    @Getter
    @AllArgsConstructor
    public static class Population implements Serializable {
        private final String species;
        private final int count;
    }

    public String toMetrics() {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("# HELP nerf_dinosaur_population_count Dinosaur population count\n")
                .append("# TYPE nerf_dinosaur_population_count gauge\n");
        populations.forEach(population -> {
                    stringBuilder
                            .append("nerf_dinosaur_population_count{species=\"")
                            .append(population.getSpecies())
                            .append("\"} ")
                            .append(population.getCount())
                            .append("\n");
                }
        );

        return stringBuilder.toString();
    }
}

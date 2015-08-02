

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Created by finnetrolle on 02.08.2015.
 */
public class Application {


    public static void main(String[] args) {

        List<CarBrandDTO> carBrandDTOs = loadJson();

        Map<String, ModelDTO> modelsByModelName = getModelsByModelName(carBrandDTOs);
        Map<String, CarBrandDTO> brandsByModelName = getBrandsByModelName(carBrandDTOs);
        Map<MultiKey, EngineDTO> enginesByModelNameAndEngineName = getEnginesByModelNameAndEngineName(carBrandDTOs);

        List<Pair<String, String>> report = new ArrayList<>();
        report.add(new Pair<>("Land Cruiser Prado", "1KZ-T"));
        report.add(new Pair<>("Accord", "A20A1"));
        report.add(new Pair<>("Corsa", "4A-FE"));
        report.add(new Pair<>("Land Cruiser Prado", "1KZ-TE"));
        report.add(new Pair<>("Mark II", "1G-FE'90"));

        report.forEach(pair -> {
            StringBuilder sb = new StringBuilder()
                    .append(brandsByModelName.get(pair.getFirst())).append(", ")
                    .append(modelsByModelName.get(pair.getFirst())).append(", ")
                    .append(enginesByModelNameAndEngineName.get(new MultiKey(pair.getFirst(), pair.getSecond())));
            System.out.println(sb.toString());
        });

    }

    public static Map<String, ModelDTO> getModelsByModelName(List<CarBrandDTO> brands) {
        return brands.stream()
                .flatMap(brand -> brand.getModels().stream())
                .collect(Collectors.toMap(ModelDTO::getModelName, model -> model));
    }

    public static Map<String, CarBrandDTO> getBrandsByModelName(List<CarBrandDTO> brands) {
        return brands.stream()
                .flatMap(brand -> brand.getModels().stream()
                        .map(model -> new Pair<>(model.getModelName(), brand)))
                .collect(toMap(Pair::getFirst, Pair::getSecond));
    }

    public static Map<MultiKey, EngineDTO> getEnginesByModelNameAndEngineName(List<CarBrandDTO> brands) {
        return brands.stream()
                .flatMap(brand -> brand.getModels().stream()
                        .map(model -> new Pair<>(brand, model)))
                .flatMap(modelPair -> modelPair.getSecond().getEngines().stream()
                        .map(engine -> new Pair<>(modelPair, engine)))
                .map(enginePair -> new Pair<>(new MultiKey(enginePair.getFirst().getSecond().getModelName(),
                                     enginePair.getSecond().getEngineName()), enginePair.getSecond()))
                .collect(toMap(Pair::getFirst, Pair::getSecond));
    }

    public static List<CarBrandDTO> loadJson() {
        try {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            File file = new File(loader.getResource("world.json").getFile());
            return new Gson().fromJson(new FileReader(file), CarWorldDTO.class).getBrands();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}



























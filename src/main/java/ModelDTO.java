import java.util.List;

/**
 * Created by finnetrolle on 02.08.2015.
 */
public class ModelDTO {

    private String modelName;

    private List<EngineDTO> engines;

    public ModelDTO(String modelName, List<EngineDTO> engines) {
        this.modelName = modelName;
        this.engines = engines;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<EngineDTO> getEngines() {
        return engines;
    }

    public void setEngines(List<EngineDTO> engines) {
        this.engines = engines;
    }

    @Override
    public String toString() {
        return "ModelDTO{" +
                "modelName='" + modelName + '\'' +
                '}';
    }
}

/**
 * Created by finnetrolle on 02.08.2015.
 */
public class EngineDTO {

    private String engineName;

    @Override
    public String toString() {
        return "EngineDTO{" +
                "engineName='" + engineName + '\'' +
                '}';
    }

    public EngineDTO(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
}

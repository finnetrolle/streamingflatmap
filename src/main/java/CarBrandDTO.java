import java.util.List;

/**
 * Created by finnetrolle on 02.08.2015.
 */
public class CarBrandDTO {

    private String brandName;

    private List<ModelDTO> models;

    public CarBrandDTO(String brandName, List<ModelDTO> models) {
        this.brandName = brandName;
        this.models = models;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "CarBrandDTO{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}

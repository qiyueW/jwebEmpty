package configuration;

public class WebConfigModel extends system.web.config.temp.WebConfigModel {

    public static final String JSONKEY = "jsonkey";

    @Override
    public void config(system.web.config.temp.WebConfig config) {
        config.HM_SUFFIX = "*.jw";
    }

    static {
        system.web.validate.model.ValidateJsonModel.getJsonKey = JSONKEY;
    }
}

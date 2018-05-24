package configuration.mvc;

import configuration.file.ImgFileModel;
import javax.servlet.http.HttpServletRequest;
import system.web.file.FI;
import system.web.file.engine.FileEngine;

/**
 *
 * @author wo
 */
public class FileService {

    public static FI upOneImg(HttpServletRequest reqeust) {
        FileEngine file = new FileEngine(reqeust);
        FI upOne = file.upOne(ImgFileModel.class);
        return upOne;
    }
}

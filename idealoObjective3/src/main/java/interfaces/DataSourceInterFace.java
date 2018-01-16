package interfaces;

import java.io.IOException;
import java.util.List;

/**
 * Created by MAC Windows on 1/15/2018.
 */
public interface DataSourceInterFace {

    public List<String> getAllWords() throws IOException;
}

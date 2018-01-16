package factories;

import constants.Constants;
import implementations.FileDataSource;
import interfaces.DataSourceInterFace;

/**
 * Created by MAC Windows on 1/15/2018.
 */
public class DataSourceFactory {
    public DataSourceInterFace getDataSource(String dataSource){
        if(dataSource == null){
            return null;
        }
        if(dataSource.equalsIgnoreCase(Constants.FILE_DATA_SOURCE)){
            return new FileDataSource();
        }
        // continue with other data sources
        return null;
    }
}

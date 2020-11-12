package util;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import java.security.InvalidParameterException;

public class DataStoreProcessor {

    public enum DataStoreType {
        SCENARIO,
        SPEC,
        SUITE
    }

    public static void save(String text, String variableName, DataStoreType dataStoreType) {
        switch (dataStoreType) {
            case SCENARIO:
                DataStoreFactory.getScenarioDataStore().put(variableName, text);
                break;
            case SPEC:
                DataStoreFactory.getSpecDataStore().put(variableName, text);
                break;
            case SUITE:
                DataStoreFactory.getSuiteDataStore().put(variableName, text);
                break;
            default:
                throw new InvalidParameterException("Invalid data store type");
        }
    }

    public static String read(String variableName, DataStoreType dataStoreType) {
        String value;
        switch (dataStoreType) {
            case SCENARIO:
                value = (String) DataStoreFactory.getScenarioDataStore().get(variableName);
                break;
            case SPEC:
                value = (String) DataStoreFactory.getSpecDataStore().get(variableName);
                break;
            case SUITE:
                value = (String) DataStoreFactory.getSuiteDataStore().get(variableName);
                break;
            default:
                throw new InvalidParameterException("Invalid data store type");
        }
        Gauge.writeMessage(variableName + " of " + dataStoreType.toString() + " contains \"" + value + "\"");
        return value;
    }
}

package gr.siggouroglou.db_transferData.controller;

import gr.siggouroglou.db_transferData.model.DBConnection;
import gr.siggouroglou.db_transferData.model.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Mar 5, 2014
 * @author syggouroglou@gmail.com
 */
public final class PropertyLoader {
    private final Logger logger = Logger.getLogger(PropertyLoader.class.getName());
    private List<Query> queryList;

    public PropertyLoader() {
        this.queryList = new ArrayList<>();
    }

    public List<Query> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<Query> queryList) {
        this.queryList = queryList;
    }

    public boolean load(Properties properties) {
        int dbcount = -1;
        int querycount = -1;
        
        // Read db and query count.
        try {
            dbcount = Integer.parseInt(properties.getProperty("dbcount"));
        } catch (NumberFormatException ex){
            logger.log(Level.FATAL, "Parameter dbcount not found or not having an integer value.");
            return false;
        }
        try {
            querycount = Integer.parseInt(properties.getProperty("querycount"));
        } catch (NumberFormatException ex){
            logger.log(Level.FATAL, "Parameter querycount not found or not having an integer value.");
            return false;
        }
        
        // Read all the db connections.
        DBConnection dBConnection = null;
        List<DBConnection> dBConnectionList = new ArrayList<>(5);
        for(int i = 0; i < dbcount; i++){
            dBConnection = new DBConnection();
            dBConnection.setName(properties.getProperty("name"));
            dBConnection.setSystem(properties.getProperty("system"));
            dBConnection.setConnectionstring(properties.getProperty("connectionstring"));
            dBConnection.setUsername(properties.getProperty("username"));
            dBConnection.setPassword(properties.getProperty("password"));
        }
        
        return true;
    }

}

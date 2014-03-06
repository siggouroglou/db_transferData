package gr.siggouroglou.db_transferData;

import gr.siggouroglou.db_transferData.controller.PropertyLoader;
import gr.siggouroglou.db_transferData.controller.SqlWorker;
import gr.siggouroglou.db_transferData.model.Query;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author siggouroglou
 */
public class Init {

    // Log4j is a library to use for logging. Is very popular.
    private static final Logger logger = Logger.getLogger(gr.siggouroglou.db_transferData.Init.class.getName());
    // Properties class is used for getting and setting configurations to files. Or more general for storing key value pers. Everything is String.
    private static final Properties properties = new Properties();

    // Local final information.
    private static final String PATH_TO_CONF = "." + File.separator + "conf" + File.separator;
    private static final String LOG_FILENAME = "logging.properties";
    private static final String CONFIGURE_FILENAME = "dbbackup.properties";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isEverythingOK = true;

        // Set the correct path for the logging properties. This properties configures the logger library. (log4j)
        try {

            File loggingFile = new File(PATH_TO_CONF + LOG_FILENAME);
            if (loggingFile.exists() && loggingFile.isFile()) {
                PropertyConfigurator.configure(loggingFile.toString());
                logger.log(Level.INFO, "-----------------------------------------");
                logger.log(Level.INFO, "The logger initialized with happyness.");
            } else {
                throw new FileNotFoundException("The system cannot find the file specified:" + PATH_TO_CONF + LOG_FILENAME);
            }
        } catch (Exception ex) {
            isEverythingOK = false;
            System.out.println(ex);
            System.exit(1);
        }

        // Load Properties from the properties (conf) file. You can place there everything you want to be configured outside of the software.
        try {
            properties.load(new FileInputStream(PATH_TO_CONF + CONFIGURE_FILENAME));
            logger.log(Level.INFO, "The configuration loaded with happyness.");
        } catch (IOException ex) {
            isEverythingOK = false;
            logger.log(Level.FATAL, ex);
        }
        
        // Load properties.
        PropertyLoader loader = new PropertyLoader();
        isEverythingOK = loader.load(properties);

        // If everything is Ok start the threads. Else shutdown.
        if (isEverythingOK) {
            SqlWorker sqlWorker = null;
            for(Query query : loader.getQueryList()) {
                sqlWorker = new SqlWorker(query, "SqlWorker_" + query.getName());
                sqlWorker.start();
            }
        } else {
            logger.log(Level.FATAL, "I am shuting down my self... Sorry!");
        }
    }
}

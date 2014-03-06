package gr.siggouroglou.db_transferData.model;

/**
 * Mar 5, 2014
 *
 * @author syggouroglou@gmail.com
 */
public class DBConnection {

    private String name;
    private String system;
    private String connectionstring;
    private String username;
    private String password;

    public DBConnection() {
        this.name = "";
        this.system = "";
        this.connectionstring = "";
        this.username = "";
        this.password = "";
    }

    //<editor-fold defaultstate="collapsed" desc="Getters-Setters">
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getConnectionstring() {
        return this.connectionstring;
    }

    public void setConnectionstring(String connectionstring) {
        this.connectionstring = connectionstring;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

}

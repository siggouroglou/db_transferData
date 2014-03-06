package gr.siggouroglou.db_transferData.controller;

import gr.siggouroglou.db_transferData.model.Query;

/**
 * Mar 5, 2014
 * @author syggouroglou@gmail.com
 */
public class SqlWorker extends Thread {
    private Query query;

    public SqlWorker(Query query, String name) {
        this.query = query;
        setName(name);
    }
    
    @Override
    public void start(){
        // TO DO
    }

}

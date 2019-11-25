package Controller;

import java.sql.Connection;

public class ExecuteSQL {
    
    private Connection cont;
    
    public ExecuteSQL(Connection con){
        setCon(con);
    }

    public Connection getCon() {
        return cont;
    }

    public void setCon(Connection con) {
        this.cont = con;
    }
    
    
}
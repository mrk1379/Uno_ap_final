package com.company.athenticationService;

import java.io.Serializable;


public class user implements Serializable {
    private String name;
    private String pass;

    public user(String name, String pass) {
        this.name = name;
        this.pass = pass;

    }
    /**
     * return name
     * @return name
     */

    public String getName() {

        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {

        this.name = name;
    }
    /**
     * return pass
     * @return pass
     */

    public String getPass() {

        return pass;
    }

    /**
     * set pass
     * @param pass
     */
    public void setPass(String pass) {

        this.pass = pass;
    }

    public String toString (){

        return String.format(this.name + "\t" + pass);
    }


}

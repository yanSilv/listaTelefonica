/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.myapp;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author programador
 */
@ApplicationPath("rest")
public class MyApp  extends ResourceConfig{
    
    public MyApp () {
        packages("com.listatelefonica.controller");
    }
    
}

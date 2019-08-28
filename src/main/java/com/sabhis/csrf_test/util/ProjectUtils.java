/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.util;

import java.util.UUID;

/**
 *
 * @author Sabhis231
 */
public class ProjectUtils {
    
    
    public static String generateRandomString() {
        return UUID.randomUUID().toString();
    }
    
}

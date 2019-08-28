/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.action;

import com.sabhis.csrf_test.interfaces.UserDetailsInterface;
import com.sabhis.csrf_test.model.UserDetails;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sabhis231
 */
@Component
public class GlobalAction {

    @Autowired
    UserDetailsInterface userDetailsInterface;

    public JSONObject saveData(UserDetails ud) {
        JSONObject object = new JSONObject();
        try {
            if (userDetailsInterface.saveOrUpdateData(ud) != null) {
                object.put("responseCode", true);
                object.put("msg", "Data Saved");
            } else {
                object.put("responseCode", false);
                object.put("msg", "Data Not Saved");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("responseCode", false);
            object.put("msg", "Error Catch Block !");
        }
        return object;
    }
}

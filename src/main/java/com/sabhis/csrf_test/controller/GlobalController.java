/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.controller;

import com.sabhis.csrf_test.action.GlobalAction;
import com.sabhis.csrf_test.model.UserDetails;
import com.sabhis.csrf_test.util.ProjectUtils;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Sabhis231
 */
@Controller
@RequestMapping("/")
public class GlobalController {

    @Autowired
    HttpSession session;

    @Autowired
    GlobalAction globalAction;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String redirectToHomePage() {
        session.setAttribute("_CSRF", ProjectUtils.generateRandomString());
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST, produces = "application/json")
    public String saveData(HttpServletRequest request) {

        if (request.getParameter("_csrf").equals((session.getAttribute("_CSRF")))) {
            session.setAttribute("_CSRF", ProjectUtils.generateRandomString());
            UserDetails ud = new UserDetails();
            ud.setCity("xyz");
            ud.setState("xyz");
            ud.setUCollegename("xyz");
            ud.setUName(request.getParameter("_name"));
            return globalAction.saveData(ud).toString();
        } else {
            session.setAttribute("_CSRF", ProjectUtils.generateRandomString());
            JSONObject object = new JSONObject();
            object.put("responseCode", false);
            object.put("msg", "CRSF Token Match Failed");
            return object.toString();
        }
    }
}

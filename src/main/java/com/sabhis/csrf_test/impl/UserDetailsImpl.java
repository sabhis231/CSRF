/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.impl;

import com.sabhis.csrf_test.dao.UserDetailsDAO;
import com.sabhis.csrf_test.interfaces.UserDetailsInterface;
import com.sabhis.csrf_test.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sabhis231
 */
@Service("UserDetailsImpl")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserDetailsImpl implements UserDetailsInterface{

    @Autowired
    UserDetailsDAO userDetailsDAO;
    
    @Override
    public UserDetails saveOrUpdateData(UserDetails ud) {
        return userDetailsDAO.saveOrUpdateData(ud);
    }
    
}

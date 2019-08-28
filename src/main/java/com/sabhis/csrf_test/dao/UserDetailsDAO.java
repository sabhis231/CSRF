/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabhis.csrf_test.dao;

import com.sabhis.csrf_test.abstractClass.AbstractDao;
import com.sabhis.csrf_test.model.UserDetails;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sabhis231
 */
@Repository("UserDetailsDAO")
public class UserDetailsDAO extends AbstractDao<UserDetails> {

    public UserDetails saveOrUpdateData(UserDetails ud) {
        return saveOrUpdate(ud);
    }

}

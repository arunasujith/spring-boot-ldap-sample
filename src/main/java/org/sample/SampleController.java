package org.sample;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aruna on 11/5/16.
 */
@RestController
public class SampleController {


    @RequestMapping
    public Authentication hello() {
        return LdapSecurity.getAuthentication();
    }

}

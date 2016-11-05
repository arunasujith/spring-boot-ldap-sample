package org.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aruna on 11/5/16.
 */
@RestController
public class SampleController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "Authenticated using LDAP successfully!!!";
    }
}

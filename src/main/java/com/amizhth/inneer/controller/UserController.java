
package com.amizhth.inneer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amizhth.inneer.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

}

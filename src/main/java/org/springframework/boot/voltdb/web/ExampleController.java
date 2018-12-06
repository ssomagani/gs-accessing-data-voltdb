package org.springframework.boot.voltdb.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ExampleController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return System.getenv("VCAP_SERVICES");
//		return "Root context";
	}
}

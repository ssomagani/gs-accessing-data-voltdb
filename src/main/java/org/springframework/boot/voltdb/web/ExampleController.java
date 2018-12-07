package org.springframework.boot.voltdb.web;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ExampleController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		jdbcTemplate.execute("update visitors set unique_count = unique_count+1");
		int countFromDB = jdbcTemplate
				.query(
						"select unique_count from visitors", 
						new SimpleRowMapper()).get(0);
		
		return "You are visitor number " + countFromDB;
	}
	
	private class SimpleRowMapper implements RowMapper<Integer> {
		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getInt(1);
		}
	}
}

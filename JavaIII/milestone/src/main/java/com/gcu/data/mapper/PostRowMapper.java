package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.PostEntity;

public class PostRowMapper implements RowMapper<PostEntity>{

	@Override
	public PostEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PostEntity(rs.getString("image_url"), rs.getString("title"), rs.getString("description"), rs.getString("date"), rs.getInt("Users_id"));
	}

}

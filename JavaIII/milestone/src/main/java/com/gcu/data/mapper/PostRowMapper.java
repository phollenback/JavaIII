package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.PostEntity;

/**
 * RowMapper implementation for mapping a ResultSet to a PostEntity object.
 */
public class PostRowMapper implements RowMapper<PostEntity> {

	/**
	 * Maps a single row of the ResultSet to a PostEntity object.
	 *
	 * @param rs     The ResultSet to map.
	 * @param rowNum The number of the current row.
	 * @return A PostEntity object mapped from the ResultSet.
	 * @throws SQLException If a database access error occurs or this method is
	 *                      called on a closed result set.
	 */
	@Override
	public PostEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PostEntity(
				rs.getString("image_url"),
				rs.getString("title"),
				rs.getString("description"),
				rs.getString("date"),
				rs.getInt("Users_id"));
	}
}

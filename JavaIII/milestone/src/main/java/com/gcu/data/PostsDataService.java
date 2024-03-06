package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.PostModel;

public class PostsDataService<T> implements DataAccessInterface<T> {
    @Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public PostsDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	 
	@Override
    public List<T> findAll() {
        String sql = "SELECT * FROM ORDERS";
        List<T> posts = new ArrayList<>();
        return posts;
    }
	
	@Override
    public T findById(int id) {
        return null;
    }

	@Override
    public boolean create(T posts) {
        
        return false;
    }

	@Override
	public boolean update(T t) {
		return false;
	}

	@Override
	public boolean delete(T t) {
		return false;
	}
}

package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.SignUpModel;

@Service
public class UsersDataService implements DataAccessInterface<SignUpModel> 
{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public UsersDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<SignUpModel> findAll() {
        String sql = "SELECT * FROM users"; // Correct table name
        // Perform database query to fetch users
        List<SignUpModel> users = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                users.add(new SignUpModel(srs.getString("first_name"),
                        srs.getString("last_name"),
                        srs.getString("email"),
                        srs.getString("phone_number"),
                        srs.getString("username"),
                        srs.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace(); // For now, just print stack trace
        }

        // Populate users list from database
        return users;
    }

    @Override
    public SignUpModel findById(int id) {
        // Implement logic to find user by id from the database
        return null;
    }

    @Override
    public boolean create(SignUpModel user) {
        String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USERNAME, PASSWORD) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getPhoneNumber(), user.getUsername(), user.getPassword());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(SignUpModel user) {
        // Implement logic to update a user in the database
        // Example:
        String sql = "UPDATE USERS SET username=?, email=? WHERE id=?";
        int updatedRows = jdbcTemplateObject.update(sql, user.getUsername(), user.getEmail());
        return updatedRows > 0;
    }

    @Override
    public boolean delete(SignUpModel user) {
        // Implement logic to delete a user from the database
        return false;
    }
}

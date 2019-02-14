package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.UserDao;
import jdbspractise.model.Developer;
import jdbspractise.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl extends AbstractDao implements UserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addUser(User user) {
        final String INSERT_USERS =
                "INSERT INTO users(name, email, password, login)  VALUE (?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_USERS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getLogin());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long id) {
        final String GET_USER_BY_ID =
                "SELECT name, email, password, login FROM users WHERE users_id =? ";
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            user.setUser_id(resultSet.getLong("user_id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setLogin(resultSet.getString("login"));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        final String UPDATE_USER =
                "UPDATE users SET name=?, email=?, password=?, login=? WHERE id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getLogin());
            statement.setLong(5, user.getUser_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(Long id) {
        final String DELETE_USER =
                "DELETE FROM users WHERE id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);

            statement.setLong(1, id);
            statement.execute();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByUsername(String login) {
        final String SELECT = "SELECT * FROM users WHERE login = " + login + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);

            return rs.next() ? getUser(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getLong("user_id"));
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));

        return user;
    }
}

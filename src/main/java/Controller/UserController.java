package Controller;

import Connection.connectionStrings;
import Model.UserModel;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.sql.Connection;

import static CheckPassword.passwordCheck.verifyPassword;

public class UserController {

    public List<UserModel> userModelList()
    {
        String query = "SELECT * FROM tbl_customer_test";
        List<UserModel> lists = new ArrayList<UserModel>();

        try(Connection connection = connectionStrings.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setPhoneNo(resultSet.getString("PhoneNo"));
                user.setAmount(resultSet.getBigDecimal("Amount"));
                lists.add(user);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return lists;
    }
    public void CreateUser(UserModel model)
    {
        String query = "INSERT INTO tbl_customer_test (Name, PhoneNo, Password, Amount, Salt) VALUES(?,?,?,?,?)";

        try(Connection connection = connectionStrings.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

//            statement.setString();
            statement.setString(1, model.getName());
            statement.setString(2, model.getPhoneNo());
            statement.setString(3, model.getPassword());
            statement.setBigDecimal(4, model.getAmount());
            statement.setString(5, model.getSalt());

            int result = statement.executeUpdate();

            String message = result > 0 ? "Sign Up Successful" : "Sign Up Failed";
            JOptionPane.showMessageDialog(null, message);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean UserLogin(String PhoneNo, String Password)
    {
        String query = "SELECT Password,Salt FROM tbl_customer_test WHERE PhoneNo = ?";

        try(Connection connection = connectionStrings.getConnection();
            PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, PhoneNo);
            ResultSet rs = statement.executeQuery();
            UserModel user = new UserModel();
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null, "User not found!");
                return false;
            }
            user.setPassword(rs.getString("Password"));
            user.setSalt(rs.getString("Salt"));
            byte[] salt = Base64.getDecoder().decode(user.getSalt());

            return verifyPassword(Password, user.getPassword(), salt);
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

package UserLists;

import Controller.UserController;
import Model.UserModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserLst {

    public UserLst() {
        SwingUtilities.invokeLater(() -> {
            UserController userController = new UserController();

            List<UserModel> userModelList = userController.userModelList();

            DefaultTableModel tableModel = new DefaultTableModel();

            tableModel.addColumn("ID");
            tableModel.addColumn("Name");
            tableModel.addColumn("Phone number");
            tableModel.addColumn("Amount");

            // Fetch data from the userModelList and add rows to the table model
            for (UserModel userModel : userModelList) {
                Object[] row = new Object[4];
                row[0] = userModel.getId();
                row[1] = userModel.getName();
                row[2] = userModel.getPhoneNo();
                row[3] = userModel.getAmount();
                tableModel.addRow(row);
            }

            JTable table = new JTable(tableModel);

            JScrollPane scrollPane = new JScrollPane(table);

            JFrame frame = new JFrame("User Data Display");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,600);
            frame.setLocation(350,100);
            frame.setResizable(false);
            frame.setLayout(new BorderLayout());
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}

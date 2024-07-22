public class Main {
    public static void main(String[] args) {
//        UserController userController = new UserController();
//
//        List<UserModel> userModelList = userController.userModelList();
//
//        for (UserModel userModel : userModelList)
//        {
//            System.out.print(userModel.getId()+"\t");
//            System.out.print(userModel.getName()+"\t");
//            System.out.print(userModel.getPassword()+"\t");
//            System.out.print(userModel.getPhoneNo()+"\t");
//            System.out.print(userModel.getAmount());
//            System.out.println();
//        }


//        SwingUtilities.invokeLater(() -> {
//            UserController userController = new UserController();
//
//            List<UserModel> userModelList = userController.userModelList();
//
//            DefaultTableModel tableModel = new DefaultTableModel();
//
//            tableModel.addColumn("ID");
//            tableModel.addColumn("Name");
//            tableModel.addColumn("Email");
//            tableModel.addColumn("Password");
//
//            // Fetch data from the userModelList and add rows to the table model
//            for (UserModel userModel : userModelList) {
//                Object[] row = new Object[4];
//                row[0] = userModel.getId();
//                row[1] = userModel.getName();
//                row[2] = userModel.getEmail();
//                row[3] = userModel.getPassword();
//                tableModel.addRow(row);
//            }
//
//            // Create a JTable with the table model
//            JTable table = new JTable(tableModel);
//
//            // Add the table to a JScrollPane (for scrolling)
//            JScrollPane scrollPane = new JScrollPane(table);
//
//            // Create a JFrame and add the scroll pane to it
//            JFrame frame = new JFrame("User Data Display");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLayout(new BorderLayout());
//            frame.setResizable(false);
//            frame.add(scrollPane, BorderLayout.CENTER);
//
//            frame.setSize(800, 600);
//            frame.setVisible(true);
//        });

//        new GUILogin();

//        try {
//            String password = "ayeayekhaing";
//
//            // Generate salt
//            byte[] salt = PasswordHasher.generateSalt();
//
//            // Hash the password with the salt
//            String hashedPassword = PasswordHasher.hashPassword(password, salt);
//
            // Print the salt and hashed password
//            System.out.println("Salt: " + Hex.encodeHexString(salt));
//            System.out.println("Hashed Password: " + hashedPassword);
//        } catch (NoSuchAlgorithmException e)
//        {
//            e.printStackTrace();
//        }
//        new GUIAccCreate();
        new GUILogin();
    }
}

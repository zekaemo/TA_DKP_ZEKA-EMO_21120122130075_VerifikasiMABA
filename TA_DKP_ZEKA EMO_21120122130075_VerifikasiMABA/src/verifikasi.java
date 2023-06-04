import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;



public class verifikasi extends JFrame {

    private Queue<String[]> inputDataQueue;
    private JLabel labelNama;
    private JTextField textFieldNama;
    private JComboBox<String> prodiComboBox;
    private JRadioButton radioButtonSNBP;
    private JRadioButton radioButtonSNBT;
    private JRadioButton radioButtonSBUB;
    private JRadioButton radioButtonUM;
    private JRadioButton radioButtonMK;
    private ButtonGroup buttonGroup;
    private JRadioButton radioButtonLakiLaki;
    private JRadioButton radioButtonPerempuan;
    private ButtonGroup ButtonGroup;
    private JCalendar calendar;
    private JFrame inputWindow;


    public verifikasi() {
        inputDataQueue = new LinkedList<>();
        mainWindow();
    }

    private void mainWindow() {
        setTitle("Verifikasi Mahasiswa Baru");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create buttons
        JButton createButton = new JButton("Verifikasi Mahasiswa Baru");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputWindow();
            }
        });

        JButton seeButton = new JButton("Data Mahasiswa Baru");
        seeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataWindow();
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(seeButton);

        // Add button panel to the main window
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private void inputWindow() {
        JFrame inputFrame = new JFrame("Verifikasi Mahasiswa Baru");
        inputFrame.setResizable(true);
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setLayout(new BoxLayout(inputFrame.getContentPane(), BoxLayout.Y_AXIS));

        // nama
        JPanel namaPanel = new JPanel();
        namaPanel.setAlignmentX(LEFT_ALIGNMENT);
        labelNama = new JLabel("Nama:");
        labelNama.setFont(new Font("Arial", Font.PLAIN, 15));
        namaPanel.add(labelNama);

        textFieldNama = new JTextField();
        textFieldNama.setFont(new Font("Arial", Font.PLAIN, 15));
        textFieldNama.setColumns(15);
        namaPanel.add(textFieldNama);

        inputFrame.add(namaPanel);
        inputFrame.add(Box.createVerticalStrut(10));

        // Tahun Lahir selection
        JPanel calendarPanel = new JPanel();
        calendarPanel.setAlignmentX(LEFT_ALIGNMENT);
        calendarPanel.add(new JLabel("Tanggal Lahir:"));

        calendar = new JCalendar();
        calendar.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("calendar")) {
                    GregorianCalendar selectedCalendar = (GregorianCalendar) e.getNewValue();
                    Calendar cal = Calendar.getInstance();


                }
            }
        });
        calendarPanel.add(calendar);

        inputFrame.add(calendarPanel);
        inputFrame.add(Box.createVerticalStrut(10));

        // prodi selection
        JPanel prodiPanel = new JPanel();
        prodiPanel.setAlignmentX(LEFT_ALIGNMENT);
        prodiPanel.add(new JLabel("Program Studi:"));
        prodiComboBox = new JComboBox<>();
        prodiComboBox.addItem("Teknik Sipil");
        prodiComboBox.addItem("Arsitektur");
        prodiComboBox.addItem("Teknik Kimia");
        prodiComboBox.addItem("Perencanaan Wilayah dan Kota");
        prodiComboBox.addItem("Teknik Mesin");
        prodiComboBox.addItem("Teknik Elektro");
        prodiComboBox.addItem("Teknik Industri");
        prodiComboBox.addItem("Teknik Lingkungan");
        prodiComboBox.addItem("Teknik Perkapalan");
        prodiComboBox.addItem("Teknik Geologi");
        prodiComboBox.addItem("Teknik Geodesi");
        prodiComboBox.addItem("Teknik Komputer");
        prodiPanel.add(prodiComboBox);

        inputFrame.add(prodiPanel);
        inputFrame.add(Box.createVerticalStrut(10));

        // jalur masuk selection
        JPanel jalurMasukPanel = new JPanel();
        jalurMasukPanel.setAlignmentX(LEFT_ALIGNMENT);
        jalurMasukPanel.setLayout(new BoxLayout(jalurMasukPanel, BoxLayout.Y_AXIS));
        JLabel labelJK = new JLabel("Jalur masuk:");
        labelJK.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(labelJK);

        radioButtonSNBP = new JRadioButton("SNBP");
        radioButtonSNBP.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(radioButtonSNBP);

        radioButtonSNBT = new JRadioButton("SNBT");
        radioButtonSNBT.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(radioButtonSNBT);

        radioButtonSBUB = new JRadioButton("SBUB");
        radioButtonSBUB.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(radioButtonSBUB);

        radioButtonUM = new JRadioButton("UJIAN MANDIRI");
        radioButtonUM.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(radioButtonUM);

        radioButtonMK= new JRadioButton("MANDIRI KEMITRAAN");
        radioButtonMK.setFont(new Font("Arial", Font.PLAIN, 15));
        jalurMasukPanel.add(radioButtonMK);

        // Add radio buttons to button group
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonSNBP);
        buttonGroup.add(radioButtonSNBT);
        buttonGroup.add(radioButtonSBUB);
        buttonGroup.add(radioButtonUM);
        buttonGroup.add(radioButtonMK);

        inputFrame.add(jalurMasukPanel);
        inputFrame.add(Box.createVerticalStrut(10));

        JPanel genderPanel = new JPanel();
        genderPanel.setAlignmentX(LEFT_ALIGNMENT);
        genderPanel.add(new JLabel("Jenis Kelamin:"));

        radioButtonLakiLaki = new JRadioButton("Laki-Laki");
        radioButtonPerempuan = new JRadioButton("Perempuan");

        ButtonGroup = new ButtonGroup();
        ButtonGroup.add(radioButtonLakiLaki);
        ButtonGroup.add(radioButtonPerempuan);

        genderPanel.add(radioButtonLakiLaki);
        genderPanel.add(radioButtonPerempuan);

        inputFrame.add(prodiPanel);
        inputFrame.add(Box.createVerticalStrut(10));
        inputFrame.add(genderPanel);


        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                afterSubmit();
            }
        });

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputFrame.dispose();
                setVisible(true);
            }
        });

        // Add components to the input frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);

        inputFrame.add(buttonPanel);

        inputFrame.setVisible(true);
        inputFrame.pack();
    }

    private void afterSubmit(){
        String name = textFieldNama.getText();
        String prodi = (String) prodiComboBox.getSelectedItem();
        Date selectedDate = calendar.getDate();
        String gender = radioButtonPerempuan.isSelected() ? "Perempuan" : "Laki-laki";
        String jalurMasuk = "";
        String selectedYear = String.valueOf(calendar.getCalendar().get(Calendar.YEAR));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ttl = dateFormat.format(selectedDate);

        if (radioButtonSNBP.isSelected()) {
            jalurMasuk = "SNBP";
        } else if (radioButtonSNBT.isSelected()) {
            jalurMasuk = "SNBT";
        } else if (radioButtonSBUB.isSelected()) {
            jalurMasuk = "SBUB";
        } else if (radioButtonUM.isSelected()) {
            jalurMasuk = "UJIAN MANDIRI";
        } else if (radioButtonMK.isSelected()) {
            jalurMasuk = "MANDIRI KEMITRAAN";
        }

        if (name.isEmpty()) {
            showError("Masukkan nama anda.");
            return;
        } else if (!selectedYear.equals("2002") && !selectedYear.equals("2003") && !selectedYear.equals("2004")
                && !selectedYear.equals("2005") && !selectedYear.equals("2006")) {
            showError("Masukkan tanggal lahir yang sesuai.");
            return;
        } else if (!radioButtonSNBP.isSelected() && !radioButtonSNBT.isSelected() && !radioButtonSBUB.isSelected() && !radioButtonUM.isSelected() && !radioButtonMK.isSelected()) {
            showError("Pilih jalur masuk anda.");
            return;
        } else if (!radioButtonPerempuan.isSelected() && !radioButtonLakiLaki.isSelected()) {
            showError("Masukkan jenis kelamin anda.");
            return;
        }

        // gender selection
        ImageIcon profileIcon = new ImageIcon();
        if (gender.equals("Perempuan")) {
            profileIcon = new ImageIcon("images/female_profile_icon.png");
        } else if (gender.equals("Laki-laki")) {
            profileIcon = new ImageIcon("images/male_profile_icon.png");
        }

        String[] inputData = {name, prodi, ttl, jalurMasuk, gender};
        inputDataQueue.add(inputData);
        resultWindow(inputData, profileIcon);

        setVisible(true);
    }

    public JFrame getInputWindow() {
        return inputWindow;
    }

    public Queue<String[]> getInputDataQueue() {
        return inputDataQueue;
    }


    private void resultWindow(String[] inputData, ImageIcon profileIcon) {
        StringBuilder number = new StringBuilder();

        // Generate number logic
        // Teknik
        if (inputData[1].equalsIgnoreCase("Teknik Komputer") || inputData[1].equalsIgnoreCase("Teknik Geologi") || inputData[1].equalsIgnoreCase("Teknik Geodesi")) {
            number.append("211");
        } else {
            number.append("210");
        }

        // prodi
        if (inputData[1].equalsIgnoreCase("Teknik Sipil")) {
            number.append("101");
        } else if (inputData[1].equalsIgnoreCase("Arsitektur")) {
            number.append("201");
        } else if (inputData[1].equalsIgnoreCase("Teknik Kimia")) {
            number.append("301");
        } else if (inputData[1].equalsIgnoreCase("Perencanaan Wilayah dan Kota")) {
            number.append("401");
        } else if (inputData[1].equalsIgnoreCase("Teknik Mesin")) {
            number.append("501");
        } else if (inputData[1].equalsIgnoreCase("Teknik Elektro")) {
            number.append("601");
        } else if (inputData[1].equalsIgnoreCase("Teknik Industri")) {
            number.append("701");
        } else if (inputData[1].equalsIgnoreCase("Teknik Lingkungan")) {
            number.append("801");
        } else if (inputData[1].equalsIgnoreCase("Teknik Perkapalan")) {
            number.append("901");
        } else if (inputData[1].equalsIgnoreCase("Teknik Geologi")) {
            number.append("001");
        } else if (inputData[1].equalsIgnoreCase("Teknik Geodesi")) {
            number.append("101");
        } else if (inputData[1].equalsIgnoreCase("Teknik Komputer")) {
            number.append("201");
        }

        //tahun masuk
        number.append("23");

        // jalur masuk
        if (inputData[3].equalsIgnoreCase("SNBP")) {
            number.append("130");
        } else if (inputData[3].equalsIgnoreCase("SNBT")) {
            number.append("130");
        } else if (inputData[3].equalsIgnoreCase("SBUB")) {
            number.append("140");
        } else if (inputData[3].equalsIgnoreCase("UJIAN MANDIRI")) {
            number.append("140");
        } else if (inputData[3].equalsIgnoreCase("MANDIRI KEMITRAAN")) {
            number.append("140");
        }

        // Generate random number
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        number.append(String.format("%03d", randomNumber));

        if (getInputWindow() != null) {
            getInputWindow().dispose();
        }

        // Create a new JFrame to display the generated number
        JFrame resultFrame = new JFrame("Verifikasi Mahasiswa Baru Teknik");
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setLayout(new BorderLayout()); // Use BorderLayout instead of GridLayout

        JPanel padding = new JPanel();
        padding.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 20)); // Set the margin
        padding.setLayout(new BorderLayout());
        resultFrame.getContentPane().add(padding, BorderLayout.CENTER);


        // Adjusting the size of the new window
        resultFrame.setSize(550, 175);
        resultFrame.setResizable(true);

        // Create a new font for the labels
        Font fontTitle = new Font("Arial", Font.BOLD, 16);
        Font font = new Font ("Arial", Font.PLAIN, 16);

        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));


        JLabel resultLabel2 = new JLabel("Selamat datang, " + inputData[0] + "!");
        resultLabel2.setFont(fontTitle);
        resultLabel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        labelsPanel.add(resultLabel2); // Add the label to the NORTH position

        JLabel resultLabel1 = new JLabel("Berikut adalah Nomor Induk Mahasiswa anda: " + number.toString());
        resultLabel1.setFont(font);
        resultLabel1.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        labelsPanel.add(resultLabel1); // Add the label to the CENTER position

        resultFrame.add(labelsPanel, BorderLayout.CENTER);

        // Create a new ImageIcon with the desired width and height
        Image image = profileIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        // Add profile icon
        JPanel profilePanel = new JPanel(new BorderLayout());
        JLabel profileLabel = new JLabel(resizedIcon);
        profilePanel.add(profileLabel, BorderLayout.EAST);
        resultFrame.add(profilePanel, BorderLayout.NORTH);


        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);

        resultFrame.add(profilePanel, BorderLayout.NORTH);

        resultFrame.setVisible(true);

    }

    private void dataWindow() {
        JFrame dataFrame = new JFrame("Data Mahasiswa Baru");
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setLayout(new BorderLayout());

        // Create table model
        DefaultTableModel dataTable = new DefaultTableModel();
        dataTable.addColumn("Nama");
        dataTable.addColumn("Program Studi");
        dataTable.addColumn("Tanggal Lahir");
        dataTable.addColumn("Jalur Masuk");
        dataTable.addColumn("Jenis Kelamin");

        // Add data to table model
        for (String[] data : getInputDataQueue()) {
            dataTable.addRow(data);
        }

        // Create JTable with the table model
        JTable table = new JTable(dataTable);
        table.setEnabled(false); // Disable editing

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        dataFrame.add(scrollPane, BorderLayout.CENTER);

        dataFrame.pack();
        dataFrame.setLocationRelativeTo(null);
        dataFrame.setVisible(true);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new verifikasi();
            }
        });
    }
}
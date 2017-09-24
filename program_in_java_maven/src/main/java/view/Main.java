package view;

import control.entityextend.*;
import entities.TableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.jdesktop.swingx.prompt.PromptSupport;

public class Main extends JPanel {
    private JScrollPane entityScrollPane;
    private JScrollPane studentScrollPane;

    private JTable entityTable;
    private JTable studentTable;

    private JFrame frame;
    private JPanel panel;

    private JButton btnStudent;
    private JButton btnMajor;
    private JButton btnBath;
    private JButton btnCourse;
    private JButton btnEntityAdd;
    private JButton btnStudentAdd;

    private TableModel entityTableModel;
    private TableModel studentTableModel;

    private JTextField txtEntityCode;
    private JTextField txtEnitityName;
    private JTextField txtStudentCode;
    private JTextField txtStudentName;
    private JLabel whiteSpaceLabel;
    private JTextField txtSearch;

    private JComboBox<String> comboBoxBath;
    private JComboBox<String> comboBoxCourse;
    private JComboBox<String> comboBoxMajor;
    private JComboBox<String> comboBoxAssessment;

    private MajorControl majorControl;
    private BathControl bathControl;
    private CourseControl courseControl;
    private StudentControl studentControl;
    private AssessmentControl assessmentControl;

    private int showEntity;

    private void init() {
        majorControl = new MajorControl();
        bathControl = new BathControl();
        courseControl = new CourseControl();
        studentControl = new StudentControl();
        assessmentControl = new AssessmentControl();

        frame = new JFrame("Student manager");
        panel = new JPanel();
        panel.setSize(1195, 672);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        btnStudent = new JButton("Student");
        btnMajor = new JButton("Major");
        btnMajor.setPreferredSize(new Dimension(100, 30));
        btnBath = new JButton("Bath");
        btnBath.setPreferredSize(new Dimension(100, 30));
        btnCourse = new JButton("Course");
        btnCourse.setPreferredSize(new Dimension(100, 30));
        whiteSpaceLabel = new JLabel("");
        whiteSpaceLabel.setPreferredSize(new Dimension(520, 30));
        txtSearch = new JTextField();
        PromptSupport.setPrompt("Search...", txtSearch);
        txtSearch.setPreferredSize(new Dimension(250, 30));

        entityTableModel = new TableModel();
        entityTableModel.setColumnNames(new String[]{" ", "Code", "Name", "Update", "Delete"});
        entityTableModel.setData(majorControl.getObjAll());
        showEntity = 1;

        entityTable = new JTable(entityTableModel);
        entityScrollPane = new JScrollPane(entityTable);
        entityTable.setPreferredSize(new Dimension(1155, 150));
        entityScrollPane.setPreferredSize(new Dimension(1155, 150));

        txtEntityCode = new JTextField();
        PromptSupport.setPrompt("Code", txtEntityCode);
        txtEntityCode.setPreferredSize(new Dimension(250, 30));
        txtEnitityName = new JTextField();
        PromptSupport.setPrompt("Name", txtEnitityName);
        txtEnitityName.setPreferredSize(new Dimension(250, 30));
        btnEntityAdd = new JButton("Add/Update");
        btnEntityAdd.setPreferredSize(new Dimension(150, 30));

        studentTableModel = new TableModel();
        studentTableModel.setColumnNames(new String[]{" ", "Code", "Name", "Bath code", "Major Code", "Courses Code", "Assessments", "Update", "Delete"});
        studentTableModel.setData(studentControl.getObjAll());

        studentTable = new JTable(studentTableModel);
        studentScrollPane = new JScrollPane(studentTable);
        studentTable.setPreferredSize(new Dimension(1155, 370));
        studentScrollPane.setPreferredSize(new Dimension(1155, 370));

        txtStudentCode = new JTextField();
        txtStudentCode.setPreferredSize(new Dimension(200, 30));
        PromptSupport.setPrompt("Code", txtStudentCode);
        txtStudentName = new JTextField();
        txtStudentName.setPreferredSize(new Dimension(200, 30));

        PromptSupport.setPrompt("Name", txtStudentName);
        comboBoxBath = new JComboBox<>(bathControl.getArrCode());
        comboBoxBath.setPreferredSize(new Dimension(120, 30));
        comboBoxMajor = new JComboBox<>(majorControl.getArrCode());
        comboBoxMajor.setPreferredSize(new Dimension(120, 30));
        comboBoxCourse = new JComboBox<>(courseControl.getArrCode());
        comboBoxCourse.setPreferredSize(new Dimension(120, 30));
        comboBoxAssessment = new JComboBox<>(assessmentControl.getArrCode());
        comboBoxAssessment.setPreferredSize(new Dimension(120, 30));
        btnStudentAdd = new JButton("Add/Update");
        btnStudentAdd.setPreferredSize(new Dimension(150, 30));

//        panel.add(btnStudent);
        panel.add(btnMajor);
        panel.add(btnBath);
        panel.add(btnCourse);
        panel.add(whiteSpaceLabel);
        panel.add(txtSearch);

        panel.add(entityScrollPane);
        panel.add(txtEntityCode);
        panel.add(txtEnitityName);
        panel.add(btnEntityAdd);
        panel.add(studentScrollPane);

        panel.add(txtStudentCode);
        panel.add(txtStudentName);
        panel.add(comboBoxBath);
        panel.add(comboBoxMajor);
        panel.add(comboBoxCourse);
        panel.add(comboBoxAssessment);
        panel.add(btnStudentAdd);

        frame.setSize(1195, 672);
        frame.add(panel);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void listen() {
        btnMajor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entityTableModel.setData(majorControl.getObjAll());
                entityTableModel.fireTableDataChanged();
                if (!txtEntityCode.isEditable()) {
                    txtEntityCode.setText("");
                    txtEnitityName.setText("");
                    txtEntityCode.setEditable(true);
                }
                showEntity = 1;
            }
        });

        btnBath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entityTableModel.setData(bathControl.getObjAll());
                entityTableModel.fireTableDataChanged();
                if (!txtEntityCode.isEditable()) {
                    txtEntityCode.setText("");
                    txtEnitityName.setText("");
                    txtEntityCode.setEditable(true);
                }
                showEntity = 2;
            }
        });

        btnCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entityTableModel.setData(courseControl.getObjAll());
                entityTableModel.fireTableDataChanged();
                if (!txtEntityCode.isEditable()) {
                    txtEntityCode.setText("");
                    txtEnitityName.setText("");
                    txtEntityCode.setEditable(true);
                }
                showEntity = 3;
            }
        });

        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentTableModel.setData(studentControl.getObjAll());
                studentTableModel.fireTableDataChanged();
            }
        });

        btnEntityAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCode = txtEntityCode.getText();
                String txtName = txtEnitityName.getText();
                if (txtEntityCode.isEditable()) {
                    boolean boo = false;
                    switch (showEntity) {
                        case 1:
                            boo = majorControl.insert(txtCode, txtName);
                            break;
                        case 2:
                            boo = bathControl.insert(txtCode, txtName);
                            break;
                        case 3:
                            boo = courseControl.insert(txtCode, txtName);
                            break;
                        default:
                            break;
                    }
                    if (boo) {
                        JOptionPane.showMessageDialog(panel, "Add Success!");
                        switch (showEntity) {
                            case 1:
                                btnMajor.doClick();
                                comboBoxMajor.addItem(txtCode);
                                break;
                            case 2:
                                btnBath.doClick();
                                comboBoxMajor.addItem(txtCode);
                                break;
                            case 3:
                                btnCourse.doClick();
                                comboBoxCourse.addItem(txtCode);
                                break;
                            default:
                                break;
                        }
                    }
                    if (!boo) {
                        JOptionPane.showMessageDialog(panel, "Add Fail!");
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(panel, "Are you sure update: " + txtCode) == 0) {
                        boolean boo = false;
                        switch (showEntity) {
                            case 1:
                                boo = majorControl.update(txtCode, txtName);
                                btnMajor.doClick();
                                break;
                            case 2:
                                boo = bathControl.update(txtCode, txtName);
                                btnBath.doClick();
                                break;
                            case 3:
                                boo = courseControl.update(txtCode, txtName);
                                btnCourse.doClick();
                                break;
                            default:
                                break;
                        }

                        if (boo) {
                            JOptionPane.showMessageDialog(panel, "Update Success!");
                            txtEntityCode.setText("");
                            txtEnitityName.setText("");
                            txtEntityCode.setEditable(true);
                        } else {
                            JOptionPane.showMessageDialog(panel, "Update Fail!");
                        }
                    }
                }
            }
        });

        txtEntityCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!txtEntityCode.isEditable()) {
                    boolean boo = JOptionPane.showConfirmDialog(panel, "Do you want disable update mode ?") == 0;
                    if (boo) {
                        txtEntityCode.setText("");
                        txtEnitityName.setText("");
                        txtEntityCode.setEditable(true);
                    }
                }
            }
        });

        btnStudentAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtCode = txtStudentCode.getText();
                String txtName = txtStudentName.getText();
                String cbBath = comboBoxBath.getSelectedItem().toString();
                String cbMajor = comboBoxMajor.getSelectedItem().toString();
                String cbCourse = comboBoxCourse.getSelectedItem().toString();
                String cbAss = comboBoxAssessment.getSelectedItem().toString();
                if (txtStudentCode.isEditable()) {
                    if (studentControl.insertStudent(txtCode, txtName, cbBath, cbMajor, cbCourse, cbAss)) {
                        JOptionPane.showMessageDialog(panel, "Add Success!");
                        btnStudent.doClick();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Add Fail!");
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(panel, "Are you sure update: " + txtCode) == 0) {
                        if (studentControl.updateStu(txtCode, txtName, cbBath, cbMajor, cbCourse, cbAss)) {
                            JOptionPane.showMessageDialog(panel, "Update Success!");
                            btnStudent.doClick();
                            txtStudentCode.setText("");
                            txtStudentName.setText("");
                            txtStudentCode.setEditable(true);
                        } else {
                            JOptionPane.showMessageDialog(panel, "Update Fail!");
                        }
                    }
                }

            }
        });

        studentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedColumn = studentTable.getSelectedColumn();
                if (selectedColumn == 8) {
                    int rowNumber = studentTable.getSelectedRow();
                    Object[][] select = studentTableModel.getData();
                    String code = select[rowNumber][1].toString();
                    int boo = JOptionPane.showConfirmDialog(panel, "Are you sure delete row : " + code);
                    if (boo == 0) {
                        if (studentControl.delete(code)) {
                            JOptionPane.showMessageDialog(panel, "Success!");
                            btnStudent.doClick();
                        } else {
                            JOptionPane.showMessageDialog(panel, "Fail!");
                        }
                    }
                }
                if (selectedColumn == 7) {
                    int rowNumber = studentTable.getSelectedRow();
                    Object[][] select = studentTableModel.getData();
                    txtStudentCode.setText(select[rowNumber][1].toString());
                    txtStudentName.setText(select[rowNumber][2].toString());
                    comboBoxBath.setSelectedItem(select[rowNumber][3].toString());
                    comboBoxMajor.setSelectedItem(select[rowNumber][4].toString());
                    comboBoxCourse.setSelectedItem(select[rowNumber][5].toString());
                    comboBoxAssessment.setSelectedItem(select[rowNumber][6].toString());
                    txtStudentCode.setEditable(false);
                }
            }
        });

        txtStudentCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!txtStudentCode.isEditable()) {
                    boolean boo = JOptionPane.showConfirmDialog(panel, "Do you want disable update mode ?") == 0;
                    if (boo) {
                        txtStudentCode.setText("");
                        txtStudentName.setText("");
                        txtStudentCode.setEditable(true);
                    }
                }
            }
        });

        entityTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedColumn = entityTable.getSelectedColumn();
                if (selectedColumn == 4) {
                    int rowNumber = entityTable.getSelectedRow();
                    Object[][] select = entityTableModel.getData();
                    String code = select[rowNumber][1].toString();
                    int num = JOptionPane.showConfirmDialog(panel, "Are you sure delete row : " + code);
                    boolean boo = false;
                    if (num == 0) {
                        switch (showEntity) {
                            case 1:
                                boo = majorControl.delete(code);
                                if (boo) {
                                    comboBoxMajor.removeAllItems();
                                    String[] items = majorControl.getArrCode();
                                    for (int i = 0; i < items.length; i++) {
                                        comboBoxMajor.addItem(items[i]);
                                    }
                                }
                                btnMajor.doClick();
                                break;
                            case 2:
                                boo = bathControl.delete(code);
                                if (boo) {
                                    comboBoxBath.removeAllItems();
                                    String[] items = bathControl.getArrCode();
                                    for (int i = 0; i < items.length; i++) {
                                        comboBoxBath.addItem(items[i]);
                                    }
                                }
                                btnBath.doClick();
                                break;
                            case 3:
                                boo = courseControl.delete(code);
                                if (boo) {
                                    comboBoxCourse.removeAllItems();
                                    String[] items = courseControl.getArrCode();
                                    for (int i = 0; i < items.length; i++) {
                                        comboBoxCourse.addItem(items[i]);
                                    }
                                }
                                btnCourse.doClick();
                                break;
                            default:
                                break;
                        }
                        if (boo) {
                            JOptionPane.showMessageDialog(panel, "Success!");
                        } else {
                            JOptionPane.showMessageDialog(panel, "Fail!");
                        }
                    }
                }
                if (selectedColumn == 3) {
                    int rowNumber = entityTable.getSelectedRow();
                    Object[][] select = entityTableModel.getData();
                    txtEntityCode.setText(select[rowNumber][1].toString());
                    txtEnitityName.setText(select[rowNumber][2].toString());
                    txtEntityCode.setEditable(false);
                }
            }
        });

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String searchText = txtSearch.getText();
                studentTableModel.setData(studentControl.searchStu(searchText));
                studentTableModel.fireTableDataChanged();
                switch (showEntity) {
                    case 1:
                        entityTableModel.setData(majorControl.getObjSearch(searchText));
                        entityTableModel.fireTableDataChanged();
                        break;
                    case 2:
                        entityTableModel.setData(bathControl.getObjSearch(searchText));
                        entityTableModel.fireTableDataChanged();
                        break;
                    case 3:
                        entityTableModel.setData(courseControl.getObjSearch(searchText));
                        entityTableModel.fireTableDataChanged();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void run() {
        init();
        listen();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

}

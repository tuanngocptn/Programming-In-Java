package model;

import entities.Entity;
import entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbProGramInJava";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static final String ORD_STRING = "_ord";
    private static final String CODE_STRING = "_code";
    private static final String NAME_STRING = "_name";
    private static final String BATH_CODE_STRING = "_bathCode";
    private static final String MAJOR_CODE_STRING = "_majorCode";
    private static final String CAURSE_CODE_STRING = "_caurseCode";
    private static final String ASSESSMENT_CODE_STRING = "_assessmentsCode";


    private static Statement statement = null;
    private static Connection connection = null;
    private static ResultSet resultSet = null;

    private static ResultSet getResultSet(String sql) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static boolean excute(String sql) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            return (statement.executeUpdate(sql) == 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Entity> getEntity(String sql) {
        List<Entity> list = new ArrayList<Entity>();
        ResultSet rs = getResultSet(sql);
        try {
            while (rs.next()) {
                list.add(new Entity(rs.getInt(ORD_STRING), rs.getString(CODE_STRING), rs.getString(NAME_STRING)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return list;
    }

    public static List<Student> getStudent(String sql) {
        List<Student> list = new ArrayList<Student>();
        ResultSet rs = getResultSet(sql);
        try {
            while (rs.next()) {
                Student student = new Student();
                student.set_ord(rs.getInt(ORD_STRING));
                student.set_code(rs.getString(CODE_STRING));
                student.set_name(rs.getString(NAME_STRING));
                student.set_bathCode(rs.getString(BATH_CODE_STRING));
                student.set_majorCode(rs.getString(MAJOR_CODE_STRING));
                student.set_caurseCode(rs.getString(CAURSE_CODE_STRING));
                student.set_assessmentsCode(rs.getString(ASSESSMENT_CODE_STRING));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return list;
    }
}

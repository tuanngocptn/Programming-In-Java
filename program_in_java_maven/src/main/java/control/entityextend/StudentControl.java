package control.entityextend;

import control.AbEntity;
import entities.Entity;
import entities.Student;
import model.DBConnect;

import java.util.List;

public class StudentControl extends AbEntity {


    public List<Student> getLstAllStu(){
        return DBConnect.getStudent("SELECT * FROM TblStudent");
    }

    @Override
    public List<Entity> getLstAll() {
        return null;
    }

    @Override
    public boolean insert(String code, String name) {
        return false;
    }

    @Override
    public boolean delete(String code) {
        String sql = "DELETE FROM TblStudent WHERE _code = '" + code +"'";
        return DBConnect.excute(sql);
    }

    @Override
    public boolean update(String code, String name) {
        return false;
    }

    @Override
    public List<Entity> search(String txtSearch) {
        return null;
    }

    public boolean updateStu(String code, String name, String bath, String major, String course, String ass) {
        if(code.isEmpty() || name.isEmpty()){
            return false;
        }
        String sql = "UPDATE TblStudent SET _name = '"+ name +"', _bathCode = '"+ bath +"' , _majorCode = '"+ major +"', _caurseCode = '"+ course +"', _assessmentsCode = '"+ ass +"' WHERE _code = '"+ code +"'";
        return DBConnect.excute(sql);
    }

    @Override
    public Object[][] getObjAll(){
        List<Student> list = this.getLstAllStu();
        Object[][] objects = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            objects[i][0] = student.get_ord();
            objects[i][1] = student.get_code();
            objects[i][2] = student.get_name();
            objects[i][3] = student.get_bathCode();
            objects[i][4] = student.get_majorCode();
            objects[i][5] = student.get_caurseCode();
            objects[i][6] = student.get_assessmentsCode();
            objects[i][7] = "update";
            objects[i][8] = "delete";
        }
        return objects;
    }

    public boolean insertStudent(String code, String name, String bath, String major, String course, String ass){
        if(code.isEmpty() || name.isEmpty()){
            return false;
        }
        String sql = "INSERT INTO TblStudent (_code, _name, _bathCode, _majorCode, _caurseCode, _assessmentsCode) VALUES ('"+ code +"','"+ name +"','"+ bath +"','"+ major +"','"+ course +"','"+ ass+"')";
        return DBConnect.excute(sql);
    }

    public Object[][] searchStu(String txtSearch){
        String sql = "SELECT * FROM TblStudent WHERE _code LIKE '%"+ txtSearch +"%' OR _name LIKE '%"+ txtSearch +"%' OR _bathCode LIKE '%"+ txtSearch +"%' OR _majorCode LIKE '%"+ txtSearch +"%' OR _caurseCode LIKE '%"+ txtSearch +"%' OR _assessmentsCode LIKE '%"+ txtSearch +"%'";
        List<Student> list = DBConnect.getStudent(sql);
        Object[][] objects = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            objects[i][0] = student.get_ord();
            objects[i][1] = student.get_code();
            objects[i][2] = student.get_name();
            objects[i][3] = student.get_bathCode();
            objects[i][4] = student.get_majorCode();
            objects[i][5] = student.get_caurseCode();
            objects[i][6] = student.get_assessmentsCode();
            objects[i][7] = "update";
            objects[i][8] = "delete";
        }
        return objects;
    }

}

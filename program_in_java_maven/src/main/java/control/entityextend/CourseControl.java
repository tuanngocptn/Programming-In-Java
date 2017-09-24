package control.entityextend;

import control.AbEntity;
import entities.Entity;
import model.DBConnect;

import java.util.List;

public class CourseControl extends AbEntity {

    @Override
    public List<Entity> getLstAll(){
        return DBConnect.getEntity("SELECT * FROM TblCourse");
    }

    @Override
    public boolean insert(String code, String name){
        if(code.isEmpty() || name.isEmpty()){
            return false;
        }
        String sql = "INSERT INTO TblCourse(_code,_name) VALUES('"+ code +"','"+ name +"')";
        return DBConnect.excute(sql);
    }

    @Override
    public boolean delete(String code) {
        String sql = "DELETE FROM TblCourse WHERE _code = '" + code +"'";
        return DBConnect.excute(sql);
    }

    @Override
    public boolean update(String code, String name) {
        if(code.isEmpty() || name.isEmpty()){
            return false;
        }
        String sql = "UPDATE TblCourse SET _name = '"+ name +"' WHERE _code = '"+ code +"'";
        return DBConnect.excute(sql);
    }

    @Override
    public  List<Entity> search(String txtSearch) {
        String sql = "SELECT * FROM TblCourse WHERE _code LIKE '%"+ txtSearch +"%' OR _name LIKE '%"+ txtSearch +"%'";
        return DBConnect.getEntity(sql);
    }
}

package control.entityextend;

import control.AbEntity;
import entities.Entity;
import model.DBConnect;

import java.util.List;

public class AssessmentControl extends AbEntity {
    @Override
    public List<Entity> getLstAll() {
        return  DBConnect.getEntity("SELECT * FROM TblAssessments");
    }

    @Override
    public boolean insert(String code, String name) {
        return false;
    }

    @Override
    public boolean delete(String code) {
        return false;
    }

    @Override
    public boolean update(String code, String name) {
        return false;
    }

    @Override
    public List<Entity> search(String txtSearch) {
        return null;
    }
}

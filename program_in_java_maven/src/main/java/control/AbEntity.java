package control;

import entities.Entity;

import java.util.List;

public abstract class AbEntity {
    public abstract List<Entity> getLstAll();
    public abstract boolean insert(String code, String name);
    public abstract boolean delete(String code);
    public abstract boolean update(String code, String name);
    public abstract  List<Entity> search(String txtSearch);

    public Object[][] getObjSearch(String txtSearch){
        List<Entity> list = this.search(txtSearch);
        Object[][] objects = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Entity IEntity = list.get(i);
            objects[i][0] = IEntity.get_ord();
            objects[i][1] = IEntity.get_code();
            objects[i][2] = IEntity.get_name();
            objects[i][3] = "update";
            objects[i][4] = "delete";
        }
        return objects;
    }
    public Object[][] getObjAll(){
        List<Entity> list = this.getLstAll();
        Object[][] objects = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Entity IEntity = list.get(i);
            objects[i][0] = IEntity.get_ord();
            objects[i][1] = IEntity.get_code();
            objects[i][2] = IEntity.get_name();
            objects[i][3] = "update";
            objects[i][4] = "delete";
        }
        return objects;
    }
    public String[] getArrCode(){
        List<Entity> list = this.getLstAll();
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).get_code();
        }
        return arr;
    }
}

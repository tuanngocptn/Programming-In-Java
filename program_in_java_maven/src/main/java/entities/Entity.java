package entities;

public class Entity {
    private int _ord;
    private String _code;
    private String _name;

    public Entity() {
    }

    public Entity(int _ord, String _code, String _name) {
        this._ord = _ord;
        this._code = _code;
        this._name = _name;
    }

    public int get_ord() {
        return _ord;
    }

    public void set_ord(int _ord) {
        this._ord = _ord;
    }

    public String get_code() {
        return _code;
    }

    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    @Override
    public String toString() {
        return "AbEntity{" +
                "_ord=" + _ord +
                ", _code='" + _code + '\'' +
                ", _name='" + _name + '\'' +
                '}';
    }
}

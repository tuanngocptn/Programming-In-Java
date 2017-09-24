package entities;

public class Student {
    private int _ord;
    private String _code;
    private String _name;
    private String _bathCode;
    private String _majorCode;
    private String _caurseCode;
    private String _assessmentsCode;

    public Student() {
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

    public String get_bathCode() {
        return _bathCode;
    }

    public void set_bathCode(String _bathCode) {
        this._bathCode = _bathCode;
    }

    public String get_majorCode() {
        return _majorCode;
    }

    public void set_majorCode(String _majorCode) {
        this._majorCode = _majorCode;
    }

    public String get_caurseCode() {
        return _caurseCode;
    }

    public void set_caurseCode(String _caurseCode) {
        this._caurseCode = _caurseCode;
    }

    public String get_assessmentsCode() {
        return _assessmentsCode;
    }

    public void set_assessmentsCode(String _assessmentsCode) {
        this._assessmentsCode = _assessmentsCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_ord=" + _ord +
                ", _code='" + _code + '\'' +
                ", _name='" + _name + '\'' +
                ", _bathCode='" + _bathCode + '\'' +
                ", _majorCode='" + _majorCode + '\'' +
                ", _caurseCode='" + _caurseCode + '\'' +
                ", _assessmentsCode='" + _assessmentsCode + '\'' +
                '}';
    }
}

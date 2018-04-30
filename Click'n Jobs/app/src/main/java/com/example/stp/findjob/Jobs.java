package com.example.stp.findjob;

public class Jobs {
    private int _id;
    private String _jobTitle;
    private String _description;
    private String _category;

    public Jobs(){

    }

    public Jobs(String jobTitle, String description, String category) {
        this._jobTitle = jobTitle;
        this._description = description;
        this._category = category;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_jobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public int get_id() {
        return _id;
    }

    public String get_jobTitle() {
        return _jobTitle;
    }

    public String get_description() {
        return _description;
    }

    public String get_category() {
        return _category;
    }
}

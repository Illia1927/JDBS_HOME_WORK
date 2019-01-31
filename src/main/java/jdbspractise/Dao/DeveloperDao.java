package jdbspractise.Dao;

import jdbspractise.Model.Developer;

public interface DeveloperDao {

    //create
    void addDeveloper(Developer developer);
    //read
    Developer getDeveloperById(Long id);
    //upate
    void updateDeveloper(Developer developer);
    //delete
    void removeDeveloper(Long id);
}

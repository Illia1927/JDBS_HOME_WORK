package jdbspractise.Service;

import jdbspractise.Model.Developer;

public interface DeveloperService {
    //create
    void addDeveloper(Developer developer);
    //read
    Developer getDeveloperById(Long id);
    //upate
    void updateDeveloper(Developer developer);
    //delete
    void removeDeveloper(Long id);
}

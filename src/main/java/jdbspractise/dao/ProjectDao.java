package jdbspractise.dao;

import jdbspractise.model.Project;

public interface ProjectDao {

    void addProject(Project project);

    Project getProjectById(Long id);

    void updateProject(Project project);

    void removeProject(Long id);
}

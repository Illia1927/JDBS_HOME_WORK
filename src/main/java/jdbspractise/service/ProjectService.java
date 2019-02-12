package jdbspractise.service;

import jdbspractise.model.Project;

public interface ProjectService {

    void addProject(Project project);

    Project getProjectById(Long id);

    void updateProject(Project project);

    void removeProject(Long id);
}

package jdbspractise.service.impl;

import jdbspractise.dao.ProjectDao;
import jdbspractise.model.Project;
import jdbspractise.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void addProject(Project project) {
       projectDao.addProject(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return null;
    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void removeProject(Long id) {

    }
}

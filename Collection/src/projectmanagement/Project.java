package projectmanagement;

import java.util.HashSet;

public class Project {
    private int projectId;
    private String projectName;
    private HashSet<Members> teamMembers;

    public Project(){

    }

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.teamMembers = new HashSet<>();
    }



    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public HashSet<Members> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(HashSet<Members> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }

    public void addTeamMember(Members teamMember) {
        teamMembers.add(teamMember);

    }
}

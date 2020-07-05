package main.candidates;

public class CandidateModel {

    int id, votesReceived;
    String ffName, llName, positionClass, positionName;

    public CandidateModel(int id, String fName, String lName, String positionName, String positionClass, int votesReceived) {
        this.id = id;
        this.ffName = fName;
        this.llName = lName;
        this.positionName = positionName;
        this.positionClass = positionClass;
        this.votesReceived = votesReceived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotesReceived() {
        return votesReceived;
    }

    public void setVotesReceived(int votesReceived) {
        this.votesReceived = votesReceived;
    }

    public String getFfName() {
        return ffName;
    }

    public void setFfName(String ffName) {
        this.ffName = ffName;
    }

    public String getLlName() {
        return llName;
    }

    public void setLlName(String llName) {
        this.llName = llName;
    }

    public String getPositionClass() {
        return positionClass;
    }

    public void setPositionClass(String positionClass) {
        this.positionClass = positionClass;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}

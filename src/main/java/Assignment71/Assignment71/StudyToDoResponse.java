package Assignment71.Assignment71;

public class StudyToDoResponse {
    private String studyList;
    private int studyTime;

    public StudyToDoResponse(String studyList, int studyTime) {
        this.studyList = studyList;
        this.studyTime = studyTime;
    }

    public int studyTime() {
        return studyTime;
    }

    public String getStudyList() {
        return studyList;
    }

    public String getTotalStudyTime() {
        return studyTime() + "時間";
    }
}

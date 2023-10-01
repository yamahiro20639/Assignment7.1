package Assignment71.Assignment71;

public class CreateStudyListRequest {

    private String learningContent;
    private int studyTime;

    public CreateStudyListRequest(String learningContent, int studyTime) {
        this.learningContent = learningContent;
        this.studyTime = studyTime;
    }

    public String getLearningContent() {
        return learningContent;
    }

    public int getStudyTime() {
        return studyTime;
    }
}

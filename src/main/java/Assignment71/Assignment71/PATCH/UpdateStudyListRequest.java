package Assignment71.Assignment71.PATCH;


public class UpdateStudyListRequest {

    private String learningContent;

    private int studyTime;

    public UpdateStudyListRequest(String learningContent, int studyTime) {
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

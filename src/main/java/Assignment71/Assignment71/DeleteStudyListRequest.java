package Assignment71.Assignment71;

public class DeleteStudyListRequest {
    private String learningContent;

    public DeleteStudyListRequest(String learningContent) {
        this.learningContent = learningContent;
    }

    public DeleteStudyListRequest() {

    }

    public String getLearningContent() {
        return learningContent;
    }

}

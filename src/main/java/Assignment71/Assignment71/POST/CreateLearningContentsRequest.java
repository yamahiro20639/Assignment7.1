package Assignment71.Assignment71.POST;

import jakarta.validation.constraints.NotBlank;

public class CreateLearningContentsRequest {
    @NotBlank
    private String learningContents;
    private int studyTime;

    public CreateLearningContentsRequest(String learningContents, int studyTime) {
        this.learningContents = learningContents;
        this.studyTime = studyTime;
    }

    public String getLearningContents() {

        return learningContents;
    }

    public int getStudyTime() {

        return studyTime;
    }
}

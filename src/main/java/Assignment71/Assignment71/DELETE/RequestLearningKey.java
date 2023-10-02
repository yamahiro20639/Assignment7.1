package Assignment71.Assignment71.DELETE;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class RequestLearningKey {
    @NotBlank
    @Length(min = 1, max = 10)
    private String learningKey;
    
    @Range(min = 1, max = 10)
    private int keyPasscode;

    RequestLearningKey(String learningKey) {
        this.learningKey = learningKey;
        this.keyPasscode = keyPasscode;
    }

    RequestLearningKey() {
    }

    public String getLearningKey() {
        return learningKey;
    }

    public int getKeyPasscode() {
        return keyPasscode;
    }
}

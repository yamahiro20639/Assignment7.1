package Assignment71.Assignment71;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController

//英語学習についてリスニングとリーディング別で学習リストと学習時間を表示
public class ToDoController {
    @GetMapping("/studyOfListening")
    public List<ListeningStudyToDoResponse> getListeningToDoList() {
        List<ListeningStudyToDoResponse> list = List.of(
                new ListeningStudyToDoResponse("ディクテーション", 1),
                new ListeningStudyToDoResponse("英文の音読", 1),
                new ListeningStudyToDoResponse("オーバーラッピング", 2),
                new ListeningStudyToDoResponse("オーバーラッピング", 4)
        );
        return list;
    }

    @GetMapping("/studyOfReading")
    public List<ReadingStudyToDoResponse> getReadingToDoList() {
        List<ReadingStudyToDoResponse> list = List.of(
                new ReadingStudyToDoResponse("単語暗記", 3),
                new ReadingStudyToDoResponse("文法学習", 3),
                new ReadingStudyToDoResponse("精読", 2),
                new ReadingStudyToDoResponse("多読", 3)
        );
        return list;
    }

    //学習項目を入力した場合に必要学習時間が帰ってくるようにする
    @PostMapping("/studytime")
    public String getStudyTime(@RequestBody StudyTimeRequest studyTimeRequest) {
        Map<String, Integer> studyList = new HashMap<>();
        studyList.put("ディクテーション", 1); //ket=学習内容　値＝学習時間
        studyList.put("英文の音読", 1);
        studyList.put("オーバーラッピング", 1);
        studyList.put("単語暗記", 1);
        studyList.put("文法学習", 1);
        studyList.put("精読", 1);
        studyList.put("多読", 1);
        for (String key : studyList.keySet()) {
            if (key == studyTimeRequest) {
                return "学習時間は" + studyTimeRequest.get(key) + "時間です。";
            } else {
                return "リストにない学習項目です";
            }
        }
    }







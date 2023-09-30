package Assignment71.Assignment71;

import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/studytime") //GetMappingに変更　クエリ文字で情報取得する仕様へ変更
    public String getStudyTime(@RequestParam("learningContent") String learningContent) {

        Map<String, Integer> studyList = new HashMap<>();
        studyList.put("ディクテーション", 4); //ket=学習内容　value＝学習時間
        studyList.put("英文の音読", 2);
        studyList.put("オーバーラッピング", 5);
        studyList.put("単語暗記", 6);
        studyList.put("文法学習", 3);
        studyList.put("精読", 7);
        studyList.put("多読", 8);

        for (String key : studyList.keySet()) {
            if (key.equals(learningContent)) {
                return learningContent + "の学習時間は" + studyList.get(learningContent) + "時間";
            } else {
                return "該当する項目がありません。";
            }
        }
    }
}

//String learningContent = studyTimeRequest.getLearningContent();
//int studyTime = studyList.get(learningContent);
//return learningContent + "の学習時間は " + studyTime + " 時間です。";
//} else {
//return "リストにない学習項目";
//}



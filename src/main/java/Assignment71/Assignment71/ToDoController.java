package Assignment71.Assignment71;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.net.URI;
import java.util.ArrayList;

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

    //学習項目を入力した場合に必要学習時間が返ってくるようにする
    @GetMapping("/studyTime") //GetMappingに変更　クエリ文字で情報取得する仕様へ変更
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
            }
        }
        return "該当する項目がありません。";
    }

    //ある学習カテゴリー(StudyCategory)へ学習項目(createStudyList)を追加、その際にlearningContentsId発行/ステータスコード201で返す仕様にする
    @PostMapping("/EnglishStudyList/{StudyCategory}")
    public ResponseEntity<String> createStudyList(
            @PathVariable("StudyCategory") String studyCategory,
            @RequestBody CreateStudyListRequest createStudyListRequest) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/EnglishStudyList/" + studyCategory + "/{learningContentsId}")
                .buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body("learningContents successfully created");
    }

    //学習項目(createStudyList)内のlearningContentsIdを指定して、その中身を修正する
    @PatchMapping("/EnglishStudyList/{StudyCategory}/{learningContentsId}")
    public String updateStudyList(
            @PathVariable("StudyCategory") String studyCategory,
            @PathVariable("learningContentsId") int learningContentsId,
            @RequestBody UpdateStudyListRequest updateStudyListRequest) {
        return "learningContents successfully updated";
    }

    //学習項目を指定してアクセスした場合、連携した学習内容が削除される
    @DeleteMapping("/EnglishStudyList/{learningContents}")
    public String deleteStudyList(
            @PathVariable("learningContents") String learningContents,
            @RequestBody DeleteStudyListRequest deleteStudyListRequest) {

        Map<String, String> studyList = new HashMap<>();
        studyList.put("リスニング1", "ディクテーション");
        studyList.put("リスニング2", "英文の音読");
        studyList.put("リスニング3", "オーバーラッピング");
        studyList.put("リーディング1", "単語暗記");
        studyList.put("リーディング2", "文法学習");
        studyList.put("リーディング3", "精読");

        for (String key : studyList.keySet()) {
            if (key.equals(learningContents)) {
                return studyList.get(learningContents) + " " + "is successfully deleted";
            }
        }
        return "該当のデータはありません";
    }
}





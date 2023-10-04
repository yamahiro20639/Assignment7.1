package Assignment71.Assignment71;

import Assignment71.Assignment71.delete.RequestLearningKey;
import Assignment71.Assignment71.get.ListeningStudyToDoResponse;
import Assignment71.Assignment71.get.ReadingStudyToDoResponse;
import Assignment71.Assignment71.get.ResponseStudyTime;
import Assignment71.Assignment71.patch.UpdateStudyListRequest;
import Assignment71.Assignment71.post.CreateLearningContentsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.net.URI;

@RestController

//英語学習についてリスニングとリーディングでそれぞれ学習リストと学習時間を表示　
public class EnglishStudyController {
    @GetMapping("/studyOfListening")
    public List<ListeningStudyToDoResponse> getListeningToDoList() {
        return List.of(
                new ListeningStudyToDoResponse("ディクテーション", 1),
                new ListeningStudyToDoResponse("英文の音読", 1),
                new ListeningStudyToDoResponse("オーバーラッピング", 2)
        );
    }

    @GetMapping("/studyOfReading")
    public List<ReadingStudyToDoResponse> getReadingToDoList() {
        return List.of(
                new ReadingStudyToDoResponse("単語暗記", 3),
                new ReadingStudyToDoResponse("文法学習", 3),
                new ReadingStudyToDoResponse("精読", 2),
                new ReadingStudyToDoResponse("多読", 3)
        );
    }

    //学習項目を入力した場合に必要学習時間が返ってくるようにする
    //クエリ文字で取得できるように実装
    @GetMapping("/studyTime")
    public Object getStudyTime(@RequestParam("learningContent") String learningContent) {

        Map<String, Integer> studyList = new HashMap<>();
        studyList.put("ディクテーション", 4); //ket=学習内容　value＝学習時間
        studyList.put("英文の音読", 2);
        studyList.put("オーバーラッピング", 5);
        studyList.put("単語暗記", 6);
        studyList.put("文法学習", 3);
        studyList.put("精読", 7);
        studyList.put("多読", 8);

        if (studyList.containsKey(learningContent)) {
            return new ResponseStudyTime(studyList.get(learningContent));
        }
        return "該当する項目がありません。";
    }

    //ある学習カテゴリー(StudyCategory)へ学習内容(learningContents)を追加、その際に番号(learningContentsId)も付与
    //ステータスコード201で返すように実装
    //バリデーション@NotBlankを実装
    @PostMapping("/EnglishStudyList/{StudyCategory}")
    public ResponseEntity<String> createStudyList(
            @PathVariable("StudyCategory") String studyCategory,
            @RequestBody @Validated CreateLearningContentsRequest createLearningContentsRequest) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/EnglishStudyList/" + studyCategory + "/{learningContentsId}")
                .buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(createLearningContentsRequest.getLearningContents() + "has successfully created");
    }

    //learningContentsIdを指定して、Idとリンクする学習内容を修正する
    @PatchMapping("/EnglishStudyList/{StudyCategory}/{learningContentsId}")
    public String updateStudyList(
            @PathVariable("StudyCategory") String studyCategory,
            @PathVariable("learningContentsId") int learningContentsId,
            @RequestBody UpdateStudyListRequest updateStudyListRequest) {
        return "learningContents successfully updated";
    }

    //学習キーを指定してアクセスした場合、連携した学習内容が削除される
    //アクセスする際に文字数１０文字以内の制限かつ空白やNullの場合は無効、数字は10以内と指定されている
    @DeleteMapping("/EnglishStudyList")
    public String deleteStudyList(@RequestBody @Validated RequestLearningKey requestLearningKey) {
        Map<String, String> studyList = new HashMap<>();
        studyList.put("リスニング1", "ディクテーション");
        studyList.put("リスニング2", "英文の音読");
        studyList.put("リスニング3", "オーバーラッピング");
        studyList.put("リーディング1", "単語暗記");
        studyList.put("リーディング2", "文法学習");
        studyList.put("リーディング3", "精読");

        if (studyList.containsKey(requestLearningKey.getLearningKey())) {
            return studyList.get(requestLearningKey.getLearningKey()) + " " + "is successfully deleted";
        }
        return "該当のデータはありません";
    }
}





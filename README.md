# 概要 
GET、POST、PATCH、DELETE、Validationを利用してREST APIを実装しました。
# 動作確認
## GET
1.英語学習についてリスニングとリーディングでそれぞれ学習リストと学習時間を表示
```
 http://localhost:8080/studyOfListening
```

<img width="1436" alt="スクリーンショット 2023-10-02 21 39 54" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/e5c1d994-3b8a-4d26-8eea-42a51666aa93">

```
 http://localhost:8080/studyOfListening
```
<img width="1440" alt="スクリーンショット 2023-10-02 21 41 46" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/244ae732-4f8a-4603-a6f5-6936393c7823">

2.学習項目を入力した場合に必要学習時間が返ってくる/クエリ文字で取得できるように実装
```
http://localhost:8080/studyTime?learningContent=ディクテーション
```
<img width="1435" alt="スクリーンショット 2023-10-02 21 48 21" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/26b0a514-859f-48f4-826c-5a9f3d85dfab">

```
http://localhost:8080/studyTime?learningContent=多読
```
<img width="1438" alt="スクリーンショット 2023-10-02 21 50 16" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/238488f8-f97c-40d2-8eed-b6bb5dc138ba">

```
http://localhost:8080/studyTime?learningContent=英語嫌いだ
```
<img width="1440" alt="スクリーンショット 2023-10-02 21 51 00" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/5640498c-98bb-474f-b705-40861b55e5e9">

## POST
1.ある学習カテゴリー(StudyCategory)へ学習内容(learningContents)を追加、その際に番号(learningContentsId)も付与 <br>
 ステータスコード201で返すように実装/バリデーション@NotBlankを実装
 <img width="1434" alt="スクリーンショット 2023-10-02 22 07 06" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/3fb7db89-4d94-4549-859e-5fc770c98bb4">
<img width="1435" alt="スクリーンショット 2023-10-02 22 08 47" src="https://github.com/yamahiro20639/Assignment7.1/assets/144509349/4e67b86f-535f-47a3-ba0f-bd68356aea60">




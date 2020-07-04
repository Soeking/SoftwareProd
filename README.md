# SoftwareProd
2020年度情報理工学実験Bソフトウェア制作

## 実行方法
### サーバー
```
$./gradlew server:run
$./gradlew server:run --args="ポート番号"
```

### クライアント
```
$./gradlew run
$./gradlew run --args="アドレス"
$./gradlew run --args="アドレス ポート番号"
```

引数がないとデフォルトでlocalhost:8080に繋がる。
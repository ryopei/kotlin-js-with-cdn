# kotlin-js-with-cdn
Kotlin/JSでKotlin自体をCDNから読み込むことでバンドルサイズを小さくするサンプルです。

実行方法
```
./gradlew browserRun
```

ビルド方法
```
./gradlew browserWebpack
```

# やってること
## ソースマップの無効化
build.gradle.ktsのsourceMaps = falseとすることでソースマップを無効化しています。

```kotlin
webpackTask {
    sourceMaps = false
    archiveFileName = "bundle.js"
}
```

## productionビルド

gradle kotlin プラグインでは、プロジェクトのwebpack.config.dフォルダ配下にあるjsファイルがwebpackでのビルド時にマージされるのを利用して、プロダクションビルドを有効にします。
"gradle  browserRun"コマンドで実行した時はconfig.devServerが定義されていますが、"gradle browserWebpack"コマンドでビルドした時はconfig.devServerが定義されていないのを利用してproductionビルドか判断しています。

```javascript
if (config.devServer == null) {
    config.mode = "production"
}
```

## kotinをCDNから取得
まずindex.htmlでkotlinをCDNから読み込むようにします。
```html
<script defer src="https://cdn.jsdelivr.net/npm/kotlin@1.3.50/kotlin.min.js"></script>
```

webpack.config.d/production.jsのconfig.externalsにバンドルからkotlinを除外する設定を追加します。
```
config.externals = {
    'kotlin': 'kotlin'
}
```




### Project for creatiing visualization graphs or bars using Kotlin Library [vico](https://github.com/patrykandpatrick/vico)

Inside Main our central project Bar graph with data  
[Main](https://github.com/Freeze35/GraphTestProject/blob/f8beaffcac0d485f3747061dc6052609932af570/app/src/main/java/com/example/graphproject/MainActivity.kt)

[Link on HorizontalPager](https://www.youtube.com/watch?v=ro3a-GmaLqE&ab_channel=PhilippLackner)

Add
[accompanist ui horizontal pager](https://google.github.io/accompanist/pager/#horizontalpager)<br/>
[Horizontal pager with tab animation](https://www.youtube.com/watch?v=ZdADYzYF7O8&ab_channel=MemoryLeak)

MVVM Structure

OrderEnvirovmentModule
Используя @Binds Создание привязки абстрактного объекта кода  к ViewModelComponent
```
Когда мы используем @InstallIn(ViewModelComponent::class),  
здесь происходит то, что жизненный цикл внедренного объекта  
будет привязан к модели представления, в которую он внедряется.  
И если мы используем аннотацию @ViewModelScoped для объекта,  
это означает, что для этого введенного объекта будет создан один  
экземпляр на протяжении всего жизненного цикла этой ViewModel.  

```

При добавлении приввязки данных через envirovnent в обработке фалов в OrderViewModule

передача данных в график посреством entryModelOf принимает на себя значение только из Array
```
var productsQuantity= mutableListOf<Int>(3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1)

val PositiveGraph = arrayOf(3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1)
val PositiveGraph = productsQuantity.toTypedArray() // or it's

    var entryData = entryModelOf(
        entriesOf(*PositiveGraph)
    entriesOf(1, 3, 1, 2, 3, 1, 3, 1, 2, 3,1, 3, 1, 2, 3, 1, 3, 1, 2, 3,1, 3, 1, 2, 3, 1, 3, 1, 2, 3) //negative data
)

```

## Solving решение несовпадение внутренних врсий зависисмости для библиотеки accomponist
```
compose_version = 1.3.0-alpha03
kotlinCompilerExtensionVersion = 1.3.0
kotlin_version & org.jetbrains.kotlin.android = 1.7.10
Accompanist 0.26.1-alpha
```

and transfer version hilt [hilt:2.44](https://stackoverflow.com/questions/67744002/hilt-unsupported-metadata-version-in-kotlin)

```
в build.gradle на уровне проекта изменить версию

id 'com.google.dagger.hilt.android' version '2.44' apply false

На уровне приложения build.gradle
implementation "com.google.dagger:hilt-android:2.44"
kapt "com.google.dagger:hilt-compiler:2.44"
```
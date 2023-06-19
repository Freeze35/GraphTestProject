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
val PositiveGraph = arrayOf(3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1,3, 2, 2, 3, 1, 3, 2, 2, 3, 1)

    var entryData = entryModelOf(
        entriesOf(*PositiveGraph)
    entriesOf(1, 3, 1, 2, 3, 1, 3, 1, 2, 3,1, 3, 1, 2, 3, 1, 3, 1, 2, 3,1, 3, 1, 2, 3, 1, 3, 1, 2, 3) //negative data
)

```
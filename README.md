### Project for creatiing visualization graphs or bars using Kotlin Library [vico](https://github.com/patrykandpatrick/vico)

Inside Main our central project Bar graph with data  
[Main](https://github.com/Freeze35/GraphTestProject/blob/f8beaffcac0d485f3747061dc6052609932af570/app/src/main/java/com/example/graphproject/MainActivity.kt)

[Link on HorizontalPager](https://www.youtube.com/watch?v=ro3a-GmaLqE&ab_channel=PhilippLackner)

Add
[accompanist ui horizontal pager](https://google.github.io/accompanist/pager/#horizontalpager)<br/>
[Horizontal pager with tab animation](https://www.youtube.com/watch?v=ZdADYzYF7O8&ab_channel=MemoryLeak)

Recommended Date for learning compose kotlin [valueof.io/jetpack-compose](https://www.valueof.io/jetpack-compose)

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

При добавлении привязки данных через envirovnent в обработке фалов в OrderViewModule

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
### Calendar // Time
[Sheets-Compose-Dialogs](https://github.com/maxkeppeler/sheets-compose-dialogs)  
[Doks -> Sheets-Compose-Dialogs](https://maxkeppeler.notion.site/Sheets-Compose-Dialogs-804f0ebcb2c84b98b7afa5f687295aed)

### Date formatter
```
For supportin min version 24 sdk change Date formatter 
Down for different version gradle (coreLibraryDesugaringEnabled / isCoreLibraryDesugaringEnabled)
android {
    defaultConfig {
        // Required when setting minSdkVersion to 20 or lower
        multiDexEnabled = true
    }

    compileOptions {
        // Flag to enable support for the new language APIs

        // For AGP 4.1+
        isCoreLibraryDesugaringEnabled = true
        // For AGP 4.0
        // coreLibraryDesugaringEnabled = true

        // Sets Java compatibility to Java 8
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.2.2")
}

```
[Java 8+ API desugaring support](https://developer.android.com/studio/write/java8-support#kts)

### CoreLibraryDesugaringEnabled
```
If you're using Android Gradle Plugin version >= 4.1, use:

isCoreLibraryDesugaringEnabled = true
For versions before that, use:

coreLibraryDesugaringEnabled = true

```
[CoreLibraryDesugaringEnabled / isCoreLibraryDesugaringEnabled](https://stackoverflow.com/questions/63789699/iscorelibrarydesugaringenabled-not-works-in-gradle-kotlin-dsl-kts)

### Change format date LocalDate to String in return in list format
```
val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

                val result = selectedDates.value.sortedByDescending {
                    LocalDate.parse(it.toString(), dateTimeFormatter)
                }.reversed()
```

### Fix [(current target it 1.8) and kaptGenerateStubsDebugKotlin task (current target is 17)](https://stackoverflow.com/questions/75480173/android-studio-build-error-compiledebugjavawithjavac-task-current-target-it-1)
```
build.gradle(:project)
plugins {
    id 'com.android.application' version '8.0.0' apply false
    id 'com.android.library' version '8.0.0' apply false
    id 'org.jetbrains.kotlin.android' version '1.8.10' apply false
}
build.gradle(:app)
compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = '17'
    }
```

### [Error with Room dao class when using Kotlin coroutines](https://stackoverflow.com/questions/48694449/error-with-room-dao-class-when-using-kotlin-coroutines)

### Fix gradle dependency [Kotlin + hilt error. [Hilt] and java.lang.reflect.InvocationTargetException](https://stackoverflow.com/questions/67811890/kotlin-hilt-error-hilt-and-java-lang-reflect-invocationtargetexception-no)
```
plugins {
   id 'com.android.application'
   id 'kotlin-android'
   id 'kotlin-kapt'
   id 'dagger.hilt.android.plugin'
   id 'kotlin-parcelize'
}

implementation "com.google.dagger:hilt-android:2.28-alpha"
kapt 'com.google.dagger:hilt-android-compiler:2.28-alpha'
```

### Fix-> (Change version above Kotlin version: 1.7.0) LayoutNode should be attached to an owner [Google questions](https://issuetracker.google.com/issues/219545359)

### Login with Basic Auth in Kotlin with a GET requet API [Credentials.basic](https://stackoverflow.com/questions/52392380/how-do-i-make-a-login-with-basic-auth-in-kotlin-with-a-get-requet-api)

### Android Bitmap loader with closed stream [www.cyberforum.ru/java-gui/thread2831085.html](https://www.cyberforum.ru/java-gui/thread2831085.html)
```
private Bitmap getImageBitmap()
    {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(IMAGE_PATH + NET_IMAGE);
 
            BufferedInputStream bis = new BufferedInputStream(fis);
            Bitmap img = BitmapFactory.decodeStream(bis);
 
            bis.close();
            fis.close();
 
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
```

### Read and Write Json File using lib Gson ->[]()
```

Images data getting example -> using ktor

suspend fun getAllImagesData(token: String): List<ImagesDataResponse> {
        return try {
                httpService.client.get {
                    url {
                        protocol = URLProtocol.HTTP
                        host = preferenceService.encryptedSettings.getString(
                            HsConstants.HOST,
                            HsConstants.EMPTY
                        )
                        path("hs", "api", "v1", "product")
                    }

                    headers {
                        append("api_key", token)
                        append("queryType", "all")
                        append("images", "1")
                        /*append("id", id)  // for special call values
                        append("units", "0")
                        append("prices", "0")
                        append("balances", "0")
                        append("barcodes","0")
                        append("videos","0")
                        append("docks","0")*/

                }
            }

        } catch (ex: Exception){
            Log.d("Error getAllImagesData:",ex.toString())
           return listOf<ImagesDataResponse>()
        }
    }
```

``` Write function to Json using read Gson
    suspend fun getAllImagestoJSON(token:String){

        val folder = getAnyDataDir()
        val pathToJson = File(folder, "AllImagesData.json")
        Log.d("Loading JSON started", pathToJson.toString())
        //check existing json file
        if (!pathToJson.exists()) {//check existing folder
            pathToJson.createNewFile() }
        else{
            pathToJson.delete()
            pathToJson.createNewFile()
        }

        // put string List with objects not typed to string
        val urlImagesData = hsService.getAllImagesData(token)

        val gson = Gson()
        try {
            //open file and change it in json
           val json = gson.toJson(urlImagesData)
            pathToJson.writeText(json)
        }
        catch (e: java.lang.Exception) {
            e.printStackTrace()}

        Log.d("DataImagesLoaded","DataImagesLoaded to $pathToJson")
    }
```
### Read function get path from context 
context getting from View model
path = "${context.filesDir.absolutePath}/"
```
fun imagesDataJsonFromStorage(path: String): List<String> {
    return try {
        val f = File(path, "AllImagesData.json") // get access to current file
        val gson = Gson()
        val listImagesData = object : TypeToken<List<ImagesDataResponse>>() {}.type
        val json = f.readText()
        val readedJson:List<ImagesDataResponse> = gson.fromJson(json,listImagesData)
        Log.d("readedJson",readedJson[20].Id.toString())
        listOf()
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
        return listOf()
    } finally {
    }
}
```
### Pager Library examples [riggaroo](https://github.com/riggaroo/compose-playtime/tree/main)
[customizing-compose-pager-with-fun-indicators-and-transitions](https://medium.com/androiddevelopers/customizing-compose-pager-with-fun-indicators-and-transitions-12b3b69af2cc)

### Autoboxing optimization android 
To optimize the autoboxing of data, you should use the flow state, which caches information on transfer, narrowing the memory, and also note that in case of a call outside the @compose structure, you should add collectAsState() to value

```
MutableStateFlow(0)
Month.collectAsState().value
```

### Check String to Double and Int value

```
fun isNumeric(toCheck: String): Boolean {
        val regex = "^[0-9]+\$".toRegex() // for Int
        //val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex() //for Double
        return toCheck.matches(regex)
    }
```

### Problem of DB
Stackoverflow [stackoverflow.com/questions/44197309/room-cannot-verify-the-data](https://stackoverflow.com/questions/44197309/room-cannot-verify-the-data-integrity)  
Room cannot verify the data integrity.   
Looks like you've changed schema but forgot to update the version number.  
You can simply fix this by increasing the version number. Expected identity hash:  
hash: a00f75eb84cd0a6776526242831c5ca4, found: 49bbd539885bc5d6be0e70cdc152e64d
Solutin1:  
android:allowBackup="true->false" Manifest.xml
Remove Old Data for Serialization BD

Sloution2: Create system Migration Android: [developer.android.com](https://developer.android.com/training/data-storage/room#db-migration)
For kapt change version +1 and set AutoMigration ->
```
@Database(
    entities = [Order::class, OrderProduct::class, Payment::class, Reserve::class],
    version = 4,
    autoMigrations = [
        AutoMigration (from = 3, to = 4)
    ]
)
```

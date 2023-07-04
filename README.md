# Symetricx Survey Android SDK

A Survey SDK for your Android applications.

## Implementation

Download repo as zip file. Extract and move **symetricx** folder to your **app** module. Write implementation in **build.gradle** file:
```
dependencies {
    implementation fileTree(dir: 'symetricx', include: ['*.aar', '*.jar'])
}
```
**NOTE:** symetricx.aar library is depended other .aar and .jar files. Also it is using Android's default dependencies:

```
implementation 'androidx.core:core-ktx:1.10.1'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.9.0'
```
Please **do not remove** these implementations. If you already implement other .aar or .jar libraries (gson, lifecycle-viewmodel-ktx etc.) as dependency in gradle. You can remove from **symetricx** folder to avoid **duplication**.

## Usage

For the initialization, add this method in **onCreate()** method in your Application class.

```
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Symetricx.init(
            projectId: Int,
            activationCode: String,
            languageShortCode: String
        )
    }
}
```

You can update **languageShortCode**.

```
Symetricx.updateLanguageShortCode("en")
```

### Showing Survey

After the initialization, you can show a survey dialog with UI customizations by **SurveyUi** object.

```
Symetricx.showSurvey(
    fragmentManager: FragmentManager,
    surveyId: Int,
    surveyOption: SurveyOption,
    showType: ShowType,
    surveySize: SurveySize,
    customerId: Int, // Optional
    customerGuid: String, // Optional
    city: String, // Optional
    mobilePhone: String, // Optional
    processNo: Int, // Optional
    processType: String // Optional
)
```

SurveyUi, ShowType, SurveySize object with optional UI parameters:

```
data class SurveyOption(
    val backgroundRes: Int,
    val stepTextAppearance: Int,
    val questionTextAppearance: Int,
    val inputTextAppearance: Int,
    val charCountTextAppearance: Int,
    val leftTextAppearanceRes: Int,
    val rightTextAppearanceRes: Int,
    val previousButton: SurveyButton,
    val nextButton: SurveyButton,
    val completeButton: SurveyButton,
    val loadingProgressColor: Int,
    val loadingProgressText: String,
    val loadingProgressTextAppearanceRes: Int,
)

data class SurveyButton(
    val iconRes: Int,
    val text: String,
    val textAppearanceRes: Int
)

sealed class ShowType {
    object BottomSheet : ShowType()
    object Dialog : ShowType() 
}

data class SurveySize(
    val width: Int,
    val height: Int
)

object Symetricx {
    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()

    const val MATCH_PARENT = -1
    const val WRAP_CONTENT = -2
}
```

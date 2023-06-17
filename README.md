# Symetricx Survey Android SDK

A Survey SDK for your Android applications.

## Usage
### Initialization

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

You can set a **customerId** for tracking a specific customer on your admin panel.

```
Symetricx.setCustomerId(customerId: Int)
```

Also you can update **languageShortCode**.

```
Symetricx.updateLanguageShortCode("en")
```

### Showing Survey

After the initialization, you can show a survey dialog with UI customizations by **SurveyUi** object.

```
Symetricx.showSurvey(
    fragmentManager: FragmentManager,
    surveyId: Int,
    surveyUi: SurveyUi,
    showType: ShowType,
    surveySize: SurveySize
)
```

SurveyUi object with optional UI parameters:

```
data class SurveyUi(
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

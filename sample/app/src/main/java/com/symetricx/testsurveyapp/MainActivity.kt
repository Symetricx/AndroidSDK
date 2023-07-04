package com.symetricx.testsurveyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.symetricx.survey.Symetricx
import com.symetricx.survey.data.ShowType
import com.symetricx.survey.data.SurveyButton
import com.symetricx.survey.data.SurveyOption
import com.symetricx.survey.data.SurveySize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Symetricx.init(
            projectId = PROJECT_ID,
            activationCode = ACTIVATION_CODE,
            languageShortCode = "tr"
        )

        findViewById<AppCompatButton>(R.id.buttonStartSurvey).setOnClickListener {
            Symetricx.showSurvey(
                fragmentManager = supportFragmentManager,
                surveyId = SURVEY_ID,
                surveyOption = SurveyOption(
                    surveyTitle = "Symetricx Survey",
                    surveyTitleTextAppearance = R.style.Manrope_SemiBold_14_Dark_Gray,
                    backgroundRes = android.R.color.background_light,
                    stepTextAppearance = R.style.Manrope_Bold_12_Light_Gray,
                    questionTextAppearance = R.style.Manrope_SemiBold_14_Dark_Gray_Center,
                    inputTextAppearance = R.style.Manrope_SemiBold_14_Light_Gray,
                    charCountTextAppearance = R.style.Manrope_Bold_12_Light_Gray,
                    leftTextAppearanceRes = R.style.Manrope_SemiBold_14_Light_Gray,
                    rightTextAppearanceRes = R.style.Manrope_SemiBold_14_Light_Gray,
                    previousButton = SurveyButton(
                        iconRes = R.drawable.ic_previous,
                        text = "Geri",
                        textAppearanceRes = R.style.Manrope_Bold_12_Light_Gray
                    ),
                    nextButton = SurveyButton(
                        iconRes = R.drawable.ic_next,
                        text = "İleri",
                        textAppearanceRes = R.style.Manrope_Bold_12_Light_Gray
                    ),
                    completeButton = SurveyButton(
                        iconRes = R.drawable.ic_tick,
                        text = "Tamamla",
                        textAppearanceRes = R.style.Manrope_Bold_12_Light_Gray
                    ),
                    loadingProgressColor = android.R.color.holo_blue_dark,
                    loadingProgressText = "Lütfen Bekleyiniz..",
                    loadingProgressTextAppearanceRes = R.style.Manrope_Bold_12_Light_Gray
                ),
                showType = ShowType.Dialog,
                surveySize = SurveySize(Symetricx.MATCH_PARENT, Symetricx.WRAP_CONTENT),
                customerId = 10,
                customerGuid = "customer_guid",
                city = "Istanbul",
                mobilePhone = "1234",
                processNo = 1,
                processType = "process_type"
            )
        }
    }
}

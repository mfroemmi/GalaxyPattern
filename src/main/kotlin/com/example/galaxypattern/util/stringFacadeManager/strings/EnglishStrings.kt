package com.example.galaxypattern.util.stringFacadeManager.strings

import com.example.galaxypattern.util.stringFacadeManager.IStringManager
import com.example.galaxypattern.util.stringFacadeManager.StringParam

class EnglishStrings : IStringManager {
    override fun getString(string: StringParam): String {
        return when (string) {
            StringParam.Planet_Info_Period -> "days"
            StringParam.Planet_Info_Rotation -> "days"
            StringParam.Planet_Info_Moons -> "No moons"
            StringParam.Planet_Info_Atmosphere -> "No atmosphere"
            StringParam.Scene_Solar_System_Title -> "Solar System"
            StringParam.Scene_Start_Button_Language -> "Language"
            StringParam.Menu_Button_PlayStop -> "Play/Stop"
            StringParam.InfoBox_Button_Close -> "close"
        }
    }
}
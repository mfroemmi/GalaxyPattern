package com.example.galaxypattern.util.stringFacadeManager.strings

import com.example.galaxypattern.util.stringFacadeManager.IStringManager
import com.example.galaxypattern.util.stringFacadeManager.StringParam

class GermanStrings : IStringManager {
    override fun getString(string: StringParam): String {
        return when (string) {
            StringParam.Planet_Info_Period -> "Tage"
            StringParam.Planet_Info_Rotation -> "Tage"
            StringParam.Planet_Info_Moons -> "Keine Monde"
            StringParam.Planet_Info_Atmosphere -> "Keine Atmosphäre"
            StringParam.Scene_Solar_System_Title -> "Sonnensystem"
            StringParam.Scene_Start_Button_Language -> "Sprache"
            StringParam.Menu_Button_PlayStop -> "Abspielen/Stop"
            StringParam.InfoBox_Button_Close -> "schließen"
        }
    }
}
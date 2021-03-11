package com.example.retrofittesting;

import androidx.navigation.NavController;

public class AppNavigation {
    private static NavController m_controller;
    public static void SetAppNavigation(NavController controller){
        m_controller = controller;
    }
    public static NavController getAppNavigation(){
        return m_controller;
    }

}

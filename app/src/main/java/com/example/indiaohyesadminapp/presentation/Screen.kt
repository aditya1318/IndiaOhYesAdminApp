package com.example.indiaohyesadminapp.presentation

sealed class Screen(val route:String){
    object CategoryScreen :Screen("")
    object CategoriesListScreen :Screen("categories_list_screen")
}

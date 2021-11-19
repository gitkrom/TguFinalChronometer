package com.example.tgufinalchronometer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tgufinal.ChronometerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


// сюда сохраняется информация о последнем нажатом элементе
private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM"
private val CHRONOMETER_FRAGMENT = ChronometerFragment().javaClass.name
private val AUTHOR_INFO_FRAGMENT = InfoFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    private var chronometerFragment = ChronometerFragment()
    private var authorInfoFragment = InfoFragment()

    //настройка нижнего меню
    private lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ссылка на верстку нижнего меню
        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        // описание порядка действий при нажатии на кнопку в нижнем меню
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.chronometer -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, CHRONOMETER_FRAGMENT)
                        } ?: chronometerFragment
                }
                R.id.info -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, AUTHOR_INFO_FRAGMENT)
                        } ?: authorInfoFragment
                }
            }
            replaceFragment(fragment!!)

            true

        }
        // Элемент жизненной активности
        // Восстанавливает состояние нижнего меню
        // Знак "?:" проверяет сохранилось ли какое-нибудь сосотояние
        // Если не сохранилсь, то по умолчанию назначается "R.id.chronometer"
        // Вызывается между onStop и onPause автоматически
        bottomNavigationMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.chronometer


    }

    // эта функция отправляет состояние последнего нажатого элемента нижней навигации в строку №9
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    // эта функция заменяет фрагменты при помощи supportFragmentManager
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
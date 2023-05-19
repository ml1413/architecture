package com.ooommm.cleanarchitecture.data.storage.sharedprefs

import android.content.Context
import com.ooommm.cleanarchitecture.data.storage.models.User


private const val SHARED_PREFS_NAME = "sharedPrefsName"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEF_F_NAME = "default first name"
private const val DEF_L_NAME = "default last name"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEF_F_NAME) ?: DEF_F_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEF_L_NAME) ?: DEF_L_NAME
        return User(firstName = firstName, lastName = lastName)

    }
}
package com.ooommm.cleanarchitecture.data.storage.sharedprefs

import com.ooommm.cleanarchitecture.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}
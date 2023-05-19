package com.ooommm.cleanarchitecture.data.repository

import com.ooommm.cleanarchitecture.data.storage.models.User
import com.ooommm.cleanarchitecture.data.storage.sharedprefs.UserStorage
import com.ooommm.cleanarchitecture.domain.models.SaveUserNameParem
import com.ooommm.cleanarchitecture.domain.models.UserName
import com.ooommm.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParem): Boolean {

        val user = User(firstName = saveParam.name, lastName = "")

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}
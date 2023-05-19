package com.ooommm.cleanarchitecture.domain.repository

import com.ooommm.cleanarchitecture.domain.models.SaveUserNameParem
import com.ooommm.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParem): Boolean

    fun getName(): UserName
}
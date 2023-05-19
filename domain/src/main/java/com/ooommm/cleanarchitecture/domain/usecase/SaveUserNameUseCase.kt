package com.ooommm.cleanarchitecture.domain.usecase

import com.ooommm.cleanarchitecture.domain.models.SaveUserNameParem
import com.ooommm.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParem): Boolean {
        val result = userRepository.saveName(saveParam = param)
        return result
    }
}
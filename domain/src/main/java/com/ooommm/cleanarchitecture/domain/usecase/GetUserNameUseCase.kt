package com.ooommm.cleanarchitecture.domain.usecase

import com.ooommm.cleanarchitecture.domain.models.UserName
import com.ooommm.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        val userName = userRepository.getName()
        return userName
    }
}
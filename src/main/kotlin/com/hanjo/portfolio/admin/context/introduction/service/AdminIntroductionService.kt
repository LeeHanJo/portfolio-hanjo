package com.hanjo.portfolio.admin.context.introduction.service

import com.hanjo.portfolio.admin.data.TableDTO
import com.hanjo.portfolio.domain.entity.Achievement
import com.hanjo.portfolio.domain.entity.Introduction
import com.hanjo.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}
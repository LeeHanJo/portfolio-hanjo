package com.hanjo.portfolio.admin.context.skill.service

import com.hanjo.portfolio.admin.data.TableDTO
import com.hanjo.portfolio.domain.entity.Achievement
import com.hanjo.portfolio.domain.entity.Introduction
import com.hanjo.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skiRepository: IntroductionRepository
) {
    fun getSkillTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = skiRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}
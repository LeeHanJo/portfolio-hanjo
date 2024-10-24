package com.hanjo.portfolio.presentation.repository

import com.hanjo.portfolio.domain.entity.*
import com.hanjo.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
) {

    fun getActiveAchievement(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }

    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

}
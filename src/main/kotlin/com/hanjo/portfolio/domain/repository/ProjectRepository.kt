package com.hanjo.portfolio.domain.repository

import com.hanjo.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>
package com.hanjo.portfolio.domain.repository

import com.hanjo.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>
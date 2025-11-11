
package com.joseyaniez.tapanaranja.features.exams.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joseyaniez.tapanaranja.features.exams.model.entity.Question;

/**
 * QuestionRepository
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySectionId(Long sectionId, Pageable pageable);
    List<Question> findBySectionChapterId(Long chapterId, Pageable pageable);
    List<Question> findBySectionChapterCourseId(Long courseId, Pageable pageable);
}

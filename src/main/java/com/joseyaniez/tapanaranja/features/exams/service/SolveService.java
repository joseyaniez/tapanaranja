
package com.joseyaniez.tapanaranja.features.exams.service;

import com.joseyaniez.tapanaranja.features.exams.model.dto.request.SolveRequest;
import com.joseyaniez.tapanaranja.features.exams.model.dto.response.SolveResponse;

/**
 * SolveService
 */
public interface SolveService {
    SolveResponse getSolveByQuestion(Long questionId);
    SolveResponse getSolveById(Long id);
    SolveResponse createSolve(SolveRequest solveRequest);
    SolveResponse updateSolve(Long id, SolveRequest solveRequest);
    void deleteSolve(Long id);
}

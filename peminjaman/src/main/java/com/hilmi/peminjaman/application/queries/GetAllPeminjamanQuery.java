package com.hilmi.peminjaman.application.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hilmi.peminjaman.application.Query;
import com.hilmi.peminjaman.application.QueryHandler;
import com.hilmi.peminjaman.dto.PeminjamanDTO;
import com.hilmi.peminjaman.repository.PeminjamanRepository;

/**
 * Query for getting all Peminjaman
 * Returns DTO list, not raw entities (CQRS compliant)
 */
public class GetAllPeminjamanQuery implements Query<List<PeminjamanDTO>> {
}

/**
 * Handler for GetAllPeminjamanQuery
 */
@Component
class GetAllPeminjamanHandler implements QueryHandler<GetAllPeminjamanQuery, List<PeminjamanDTO>> {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Override
    public List<PeminjamanDTO> handle(GetAllPeminjamanQuery query) {
        return peminjamanRepository.findAll().stream()
                .map(PeminjamanDTO::fromEntity)
                .collect(Collectors.toList());
    }
}

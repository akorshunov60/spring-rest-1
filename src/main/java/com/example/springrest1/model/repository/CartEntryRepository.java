package com.example.springrest1.model.repository;

import com.example.springrest1.model.entity.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {
}

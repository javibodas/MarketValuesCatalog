package com.jgonzalbo.bolsavalores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgonzalbo.bolsavalores.models.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

}

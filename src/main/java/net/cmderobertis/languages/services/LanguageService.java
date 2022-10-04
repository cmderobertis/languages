package net.cmderobertis.languages.services;

import net.cmderobertis.languages.models.Language;
import net.cmderobertis.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // CREATE
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }
    // READ
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
    public Language getOne(Long id) {
        Optional<Language> language = languageRepository.findById(id);
        return language.orElse(null);
    }
    // UPDATE
    public Language update(Language language) {
        Language l = getOne(language.getId());
        l.setName(language.getName());
        l.setCreator(language.getCreator());
        l.setVersion(language.getVersion());
        return languageRepository.save(l);
    }
    //DELETE
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }
}

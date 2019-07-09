package ua.skillsup.practice.service;


import ua.skillsup.practice.dao.ExampleDao;
import ua.skillsup.practice.entity.ExampleEntity;
import ua.skillsup.practice.service.ExampleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.time.Instant;


public class ImplementServ implements ExampleService {
    private boolean storeExam;
    private ExampleDao exampleDao;
    private ExampleEntity exampleEntity;
    private long id = 0;

    public ImplementServ(ExampleDao exampleDao) {
    }
    public void setStoreExam(boolean storeExam) {
        this.storeExam = storeExam;
    }
    public boolean isStoreExam() {
        return storeExam;
    }

    @Override
    public void addNewItem(String title, BigDecimal price) throws Exception {
        Validation validation = new Validation(exampleDao);
        validation.valTitle(title);
        validation.valConect(storeExam);
        validation.valPrice(price);

        Instant instant = Instant.now();
        ExampleEntity entity = new ExampleEntity();
        entity.setTitle(title);
        entity.setPrice(price);
        storeExam = exampleDao.store(entity);

    }


    @Override
    public Map<LocalDate, BigDecimal> getStatistic() {
        exampleDao.findAll();
        return null;
    }
}

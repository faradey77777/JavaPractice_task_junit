package ua.skillsup.practice.service;


import ua.skillsup.practice.dao.ExampleDao;
import ua.skillsup.practice.entity.ExampleEntity;
import ua.skillsup.practice.service.ExampleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.time.Instant;


public class ImplementServ implements ExampleService {

    private long id = 0;

    public ImplementServ(ExampleDao exampleDao) {
    }


    public boolean isStoreExam() {
        return storeExam;
    }

    public void setStoreExam(boolean storeExam) {
        this.storeExam = storeExam;
    }

    private boolean storeExam;
    private ExampleDao exampleDao;
    private ExampleEntity exampleEntity;


    @Override
    public void addNewItem(String title, BigDecimal price) throws Exception {

        if (title.length() < 3 && title.length() > 20) {
            throw new Exception("Title must be contains 3-20");
        }
        if (price.scale() == 3) {
            price.setScale(0, BigDecimal.ROUND_HALF_UP);
        }


        Instant instant = Instant.now();
        ExampleEntity entity = new ExampleEntity();
        entity.setTitle(title);
        entity.setPrice(price);

        storeExam = exampleDao.store(entity);

        if (storeExam == false) {
            throw new Exception("Error connecting to the repository or double");
        }

    }


    @Override
    public Map<LocalDate, BigDecimal> getStatistic() {
        exampleDao.findAll();

        return null;
    }
}

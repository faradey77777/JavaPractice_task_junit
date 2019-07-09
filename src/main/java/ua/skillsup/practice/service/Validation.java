package ua.skillsup.practice.service;


import ua.skillsup.practice.dao.ExampleDao;

import java.math.BigDecimal;

public class Validation {
    ExampleDao exampleDao;

    public Validation(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }

    public void valTitle(String title) {
        if (title.length() < 3 && title.length() > 20) {
            throw new ValidException("Title must be contains 3-20");
        }
    }

    public void valPrice(BigDecimal price) {
        if (price.scale() == 3) {
            price.setScale(0, BigDecimal.ROUND_HALF_UP);
        }
    }

    public void valConect(boolean storeExam){
        if (storeExam == false) {
            throw new ValidException("Error connecting to the repository or double");
        }
    }



}
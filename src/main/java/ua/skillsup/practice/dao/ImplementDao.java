package ua.skillsup.practice.dao;

import ua.skillsup.practice.entity.ExampleEntity;
import ua.skillsup.practice.ExampleNetworkException;

import java.util.ArrayList;
import java.util.List;

public class ImplementDao implements ExampleDao {

    public List<ExampleEntity> exampleEntities = new ArrayList<>();

    @Override
    public boolean store(ExampleEntity entity) throws ExampleNetworkException {
        try {
            if (exampleEntities.contains(entity)) {
                return false;
            } else {
                exampleEntities.add(entity);
            }
            return true;
        } catch (ExampleNetworkException e) {
            System.out.println("Error connect to store");
        }

        return false;
    }



    @Override
    public List<ExampleEntity> findAll() throws ExampleNetworkException {
        if (!exampleEntities.isEmpty()) {
            return exampleEntities;
        }
        else throw new ExampleNetworkException();



    }
}

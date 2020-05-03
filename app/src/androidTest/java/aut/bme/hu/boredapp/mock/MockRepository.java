package aut.bme.hu.boredapp.mock;

import java.util.List;

import aut.bme.hu.boredapp.model.BoredActivityEntity;
import aut.bme.hu.boredapp.repository.BoredRepository;

public class MockRepository extends BoredRepository {

    @Override
    public void add(BoredActivityEntity activity) {
    }

    @Override
    public List<BoredActivityEntity> getAll() {
        return null;
    }

    @Override
    public void delete(BoredActivityEntity boredActivity) {

    }
}

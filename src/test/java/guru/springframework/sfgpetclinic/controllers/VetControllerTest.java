package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    private VetController vetController;
    private VetMapService vetService;

    @BeforeEach
    public void setUp() {
        vetService = new VetMapService(null);
        vetController = new VetController(vetService);

        List.of(
                new Vet(1L, "Bronek", "Weterynarz", Collections.emptySet()),
                new Vet(2L, "Zdzisiek", "Zwierzak", Collections.emptySet())
        ).forEach(
                vetService::save);
    }

    @Test
    void testListVetsReturnValue() {
        ModelImpl model = new ModelImpl();
        String result = vetController.listVets(model);

        assertEquals("vets/index", result);
    }

    @Test
    void testListVetsAddsVetListsToModel() {
        ModelImpl model = new ModelImpl();
        vetController.listVets(model);

       assertEquals(2, ((Set) model.getModel().get("vets")).size());
    }

}

class ModelImpl implements Model {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        throw new UnsupportedOperationException();
    }

    public Map<String, Object> getModel() {
        return map;
    }
}
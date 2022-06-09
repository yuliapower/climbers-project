package ru.ifmo.exams.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.ifmo.exams.climbers.entity.Climber;
import ru.ifmo.exams.climbers.entity.Group;
import ru.ifmo.exams.climbers.entity.Mountain;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormExam");
        EntityManager manager = factory.createEntityManager();

        Mountain everest = new Mountain();
        Mountain elbrus = new Mountain();
        Mountain ararat = new Mountain();

        everest.setMountainName("Everest");
        everest.setCountry("China");
        everest.setHeight(8849);

        elbrus.setMountainName("Elbrus");
        elbrus.setCountry("Russia");
        elbrus.setHeight(5642);

        ararat.setMountainName("Ararat");
        ararat.setCountry("Armenia");
        ararat.setHeight(5165);

        Climber climber1 = new Climber();
        Climber climber2 = new Climber();
        Climber climber3 = new Climber();
        Climber climber4 = new Climber();
        Climber climber5 = new Climber();
        Climber climber6 = new Climber();
        Climber climber7 = new Climber();

        Group group1 = new Group(everest,3);
        Group group2 = new Group(elbrus,3);
        Group group3 = new Group(ararat,3);

        climber1.setName("Ruslan");
        climber1.setAddress("Saint-Petersburg");
        group1.addClimber(climber1);
        climber2.setName("Olya");
        climber2.setAddress("Novosibirsk");
        group1.addClimber(climber2);
        climber3.setName("Eva");
        climber3.setAddress("Saint-Petersburg");
        group1.addClimber(climber3);
        climber4.setName("Alex");
        climber4.setAddress("Moscow");
        group2.addClimber(climber4);
        climber5.setName("Aid");
        climber5.setAddress("Afhens");
        group2.addClimber(climber5);
        climber6.setName("Vasilisa");
        climber6.setAddress("Moscow");
        group3.addClimber(climber6);
        climber7.setName("Vitalina");
        climber7.setAddress("Saint-Petersburg");
        group3.addClimber(climber7);

        manager.getTransaction().begin();
        manager.persist(everest);
        manager.persist(elbrus);
        manager.persist(ararat);
        manager.persist(group1);
        manager.persist(group2);
        manager.persist(group3);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
        //close не забыть для менеджера и фабрики
    }
}

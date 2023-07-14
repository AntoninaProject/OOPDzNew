package family_tree;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human victor = new Human("Виктор", Gender.Male, LocalDate.of(1954, 02, 22));
        Human zoya = new Human("Зоя", Gender.Female, LocalDate.of(1959, 01, 01));
        Human ekaterina = new Human("Екатерина", Gender.Female, LocalDate.of(1986, 10, 30),
                victor, zoya);
        Human antonina = new Human("Антонина", Gender.Female, LocalDate.of(1985, 4, 19),
                victor, zoya);

        tree.add(victor);
        tree.add(zoya);
        tree.setWedding(victor.getId(),zoya.getId());
        
        tree.add(ekaterina);
        tree.add(antonina);

        Human grandMother = new Human("Анна", Gender.Female, LocalDate.of(1938, 6, 23));
        grandMother.addChild(zoya);
        tree.add(grandMother);

        System.out.println(tree);

        FamilyTreeService service = new FamilyTreeService(tree);
        service.setWritable(new FileHandlerForFamilyTree());
        service.save();

        View view = new Console();
        view.start();
    }
}

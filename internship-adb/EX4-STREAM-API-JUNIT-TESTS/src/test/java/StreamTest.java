import com.internship.adb.stream.animal.Animal;
import com.internship.adb.stream.animal.cat.CatHunterSense;
import com.internship.adb.stream.animal.collection.implementation.CustomizedArrayList;
import com.internship.adb.stream.animal.cat.Cat;
import com.internship.adb.stream.animal.dog.Dog;
import com.internship.adb.stream.animal.utils.AnimalUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static com.internship.adb.stream.animal.cat.CatHunterSense.AVERAGE;
import static com.internship.adb.stream.animal.cat.CatHunterSense.MEDIUM;
import static com.internship.adb.stream.animal.cat.CatHunterSense.WEAK;
import static com.internship.adb.stream.animal.dog.DogCommand.*;
import static com.internship.adb.stream.animal.Hairiness.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StreamTest {

    private static final List<Animal> ANIMALS = new CustomizedArrayList<>();
    private static final String ANIMAL_NOT_NULL = "Animal should not be a null.";
    private static final String ANIMAL_NAME_NOT_NULL = "Animal's name should not be a null.";

    @BeforeAll
    public void addAnimals() {
        Dog dog1 = new Dog("Reksio", FUR, 42, List.of(SIT, BARK, GUARD, STAY));
        Dog dog2 = new Dog("Bury", FUR, 50, List.of(SIT, SEARCH, GO_FETCH));
        Dog dog3 = new Dog("Tofik", HAIR, 8, List.of(SIT, GIVE_A_PAW));
        Dog dog4 = new Dog("Bruno", HAIR, 6);
        Dog dog5 = new Dog("Czesław", NONE, 10, List.of(GO_FETCH, BARK));

        Cat cat1 = new Cat("Kitty", NONE, 10, WEAK);
        Cat cat2 = new Cat("Lily", FUR, 12, MEDIUM);
        Cat cat3 = new Cat("Simba", FUR, 9, AVERAGE);
        Cat cat4 = new Cat("Lucyfer", FUR, 15, AVERAGE);
        Cat cat5 = new Cat("Einstein", NONE, 11, MEDIUM);
        Cat cat6 = new Cat("Puszek", FUR, 17, AVERAGE);

        ANIMALS.add(dog1);
        ANIMALS.add(cat5);
        ANIMALS.add(dog2);
        ANIMALS.add(cat1);
        ANIMALS.add(dog3);
        ANIMALS.add(cat4);
        ANIMALS.add(cat3);
        ANIMALS.add(dog5);
        ANIMALS.add(dog4);
        ANIMALS.add(cat2);
        ANIMALS.add(cat6);

        //Added a replicated cat and dogs
        ANIMALS.add(cat3);
        ANIMALS.add(dog2);
        ANIMALS.add(dog2);
        ANIMALS.add(cat4);
        ANIMALS.add(dog5);
    }

    @AfterEach
    public void printSeparator() {
        System.out.println("----------------------------------------" + '\n');
    }

    @Test
    @Order(1)
    @DisplayName("All animals.")
    void printAnimals() {
        ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
        System.out.println(ANIMALS);
    }

    @Test
    @Order(2)
    @DisplayName("Parallel animals.")
        // stream.parallel()
        // parallelStream()
    void parallelAnimals() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            assertTrue(ANIMALS.parallelStream().isParallel());
            assertTrue(ANIMALS.stream().parallel().isParallel());
        });
    }

    @Test
    @Order(3)
    @DisplayName("Distinguished animals.")
        // stream.distinct()
    void printDistinctAnimals() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var distinct = ANIMALS.stream()
                    .distinct()
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                var noRepetition = new CustomizedArrayList<>(new HashSet<>(ANIMALS));
                if (noRepetition.size() == distinct.size()) {
                    return noRepetition.containsAll(distinct);
                } else return false;
            });
            System.out.println(distinct);
        });
    }

    @Test
    @Order(4)
    @DisplayName("Checking if any cat hunts mice.")
        // stream.anyMatch(Predicate<? super Cat>)
    void anyMatchCatHuntsMice() {
        ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
        var cats = AnimalUtils.getCats(ANIMALS);
        assumeFalse(cats.isEmpty());
        boolean anyMatch = cats.stream()
                .anyMatch(cat -> cat.getHunterSense().doesHuntMice());
        assumeTrue(anyMatch);
        System.out.println(true);
    }

    @Test
    @Order(5)
    @DisplayName("Checking if none animal weights 0.")
        // stream.noneMatch(Predicate<? super Animal>)
    void noneMatchAnimalUnweighted() {
        ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
        boolean noneMatch = ANIMALS.stream()
                .noneMatch(animal -> animal.getWeight() == 0);
        assumeTrue(noneMatch);
        System.out.println(true);
    }

    @Test
    @Order(6)
    @DisplayName("Checking if all cats and dogs are named.")
        // stream.allMatch(Predicate<? super Animal>)
    void allMatchCatsDogsAreNamed() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            assertTrue(() -> ANIMALS.stream()
                    .allMatch(animal -> {
                        if (animal instanceof Dog || animal instanceof Cat) {
                            assertNotNull(animal.getName(), ANIMAL_NAME_NOT_NULL);
                        }
                        return true;
                    }));
            System.out.println(true);
        });
    }

    @Test
    @Order(7)
    @DisplayName("Filtering by all hairless animals.")
        // stream.filter(Predicate<? super Animal>)
    void filterByHairless() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var filtered = ANIMALS.stream()
                    .filter(animal -> animal.getHairiness().equals(NONE))
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                var allAnimals = new CustomizedArrayList<>(ANIMALS);
                allAnimals.removeAll(filtered);
                boolean extractedAllHairless = allAnimals.stream()
                        .noneMatch(animal -> animal.getHairiness().equals(NONE));
                boolean onlyHairless = filtered.stream()
                        .allMatch(animal -> animal.getHairiness().equals(NONE));
                return extractedAllHairless && onlyHairless;
            });
            System.out.println(filtered);
        });
    }

    @Test
    @Order(8)
    @DisplayName("Sorting all animals alphabetically by their names.")
        // stream.sorted(Comparator<? super Animal>)
    void sortByName() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var sorted = ANIMALS.stream()
                    .sorted(Comparator.comparing(Animal::getName))
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                String prevName = "";
                for (Animal animal : sorted) {
                    String currentName = animal.getName();
                    if (prevName.compareTo(currentName) > 0) {
                        return false;
                    }
                    prevName = currentName;
                }
                return true;
            });
            System.out.println(sorted);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    @Order(9)
    @DisplayName("Limiting to firsts variable number of all animals.")
        // stream.limit(int)
    void limitExample(int numberOfExclusive) {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var limited = ANIMALS.stream()
                    .limit(numberOfExclusive)
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertEquals(numberOfExclusive, limited.size());
            System.out.println(limited);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 16})
    @Order(10)
    @DisplayName("Skipping firsts variable number of all animals.")
        // stream.skip(int)
    void skipExample(int numberOfSkipped) {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var skipped = ANIMALS.stream()
                    .skip(numberOfSkipped)
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertEquals(ANIMALS.size() - numberOfSkipped, skipped.size());
            System.out.println(skipped);
        });
    }

    @Test
    @Order(11)
    @DisplayName("Counting number of all animals which does not shed.")
        // stream.count()
    void countNonShedding() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var expected = ANIMALS.stream()
                    .filter(animal -> !animal.getHairiness().isShedding())
                    .collect(Collectors.toCollection(HashSet::new))
                    .size();
            long counted = ANIMALS.stream()
                    .filter(animal -> !animal.getHairiness().isShedding())
                    .distinct()
                    .count();
            assertEquals(expected, counted);
            System.out.println(counted);
        });
    }

    @Test
    @Order(12)
    @DisplayName("Finding dog with least number of learnt reactions to commands.")
        // stream.min(Comparator<? super Dog>)
    void findDogMinReactions() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var dogs = AnimalUtils.getDogs(ANIMALS);
            assumeFalse(dogs.isEmpty());
            var minDog = dogs.stream()
                    .min(Comparator.comparing(Dog::countLearntCommands))
                    .get();
            assertTrue(() -> {
                int currentMin = minDog.countLearntCommands();
                for (Dog dog : dogs) {
                    int counted = dog.countLearntCommands();
                    if (counted < currentMin) {
                        return false;
                    }
                }
                return true;
            });
            System.out.println(minDog);
        });
    }

    @Test
    @Order(13)
    @DisplayName("Finding cat with greatest hunter sense.")
        // stream.max(Comparator<? super Cat>)
    void findCatMaxHunterSense() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var cats = AnimalUtils.getCats(ANIMALS);
            assumeFalse(cats.isEmpty());
            var maxCat = cats.stream()
                    .max(Comparator.comparing(Cat::getHunterSensePower))
                    .get();
            assertEquals(CatHunterSense.getMaxPossible(), maxCat.getHunterSense().getSensePower());
            System.out.println(maxCat);
        });
    }

    @RepeatedTest(6)
    @Order(14)
    @DisplayName("Finding any animal.")
        // stream.findAny()
    void findAnyAnimal() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            Collections.shuffle(ANIMALS);
            var anyAnimal = ANIMALS.stream()
                    .findAny();
            assumeTrue(anyAnimal.isPresent());
            var any = anyAnimal.get();
            assertTrue(ANIMALS.contains(any));
            System.out.println(any);
        });
    }

    @RepeatedTest(6)
    @Order(15)
    @DisplayName("Finding first cat that does not hunts birds.")
        // stream.findFirst()
    void findFirstCatNoHuntsBirds() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var cats = AnimalUtils.getCats(ANIMALS);
            assumeFalse(cats.isEmpty());
            var firstCat = cats.stream()
                    .filter(eachCat -> !eachCat.getHunterSense().doesHuntBirds())
                    .findFirst();
            assumeTrue(firstCat.isPresent());
            assertFalse(firstCat.get().getHunterSense().doesHuntBirds());
            System.out.println(firstCat.get());
        });
    }

    @Test
    @Order(16)
    @DisplayName("Mapping distinguished animals to their names and names' length.")
        // stream.map(Function<? super String, ? extends R>)
    void mapToNamesAndLength() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var distinct = ANIMALS.stream()
                    .distinct()
                    .collect(Collectors.toList());
            var names = distinct.stream()
                    .map(animal -> animal.getName() + " - " + animal.getName().length())
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                if (names.size() == distinct.size()) {
                    for (int i = 0; i < names.size(); i++) {
                        String name = names.get(i);
                        String[] split = name.split(" - ");
                        assertDoesNotThrow(() -> split[0]);
                        if (!Objects.equals(split[0], distinct.get(i).getName())) {
                            return false;
                        }
                    }
                    return true;
                } else return false;
            });
            System.out.println(names);
        });
    }

    @Test
    @Order(17)
    @DisplayName("Mapping distinguished animals to their weights(in kgs) only.")
        // stream.mapToInt(ToIntFunction<? super Animal>)
    void mapToIntAnimalsWeights() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var distinct = ANIMALS.stream()
                    .distinct()
                    .collect(Collectors.toList());
            var weights = distinct.stream()
                    .mapToInt(Animal::getWeight)
                    .boxed()
                    .collect(Collectors.toList());
            assertTrue(() -> {
                if (weights.size() == distinct.size()) {
                    for (int i = 0; i < weights.size(); i++) {
                        if (weights.get(i) != distinct.get(i).getWeight()) {
                            return false;
                        }
                    }
                    return true;
                } else return false;
            });
            System.out.println(weights);
        });
    }

    @Test
    @Order(18)
    @DisplayName("Sum of distinguished animals' weights.")
        // stream.reduce(IntBinaryOperation)
    void reduceToAnimalsWeightsSum() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var distinct = ANIMALS.stream().distinct().collect(Collectors.toList());
            var reduced = distinct.stream()
                    .mapToInt(Animal::getWeight)
                    .reduce(Integer::sum);
            reduced.ifPresent(sum -> {
                assertTrue(() -> {
                    int expectedSum = 0;
                    for (Animal animal : distinct) {
                        expectedSum += animal.getWeight();
                    }
                    return expectedSum == sum;
                });
                System.out.println(sum + "kg");
            });
        });
    }

    @ParameterizedTest
    @Order(19)
    @ValueSource(ints = {10, 15, 30, 49, 50})
    @DisplayName("Dropping distinguished animals while their weight <= int.")
        // stream().sorted(Comparator<? super Animal>).dropWhile(Predicate<? super Animal>)
    void dropWhileAnimalWeight(int threshold) {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var dropWhile = ANIMALS.stream()
                    .distinct()
                    .sorted(Comparator.comparingInt(Animal::getWeight))
                    .dropWhile(animal -> animal.getWeight() <= threshold)
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                for (Animal animal : dropWhile) {
                    if (animal.getWeight() <= threshold) {
                        return false;
                    }
                }
                return true;
            });
            System.out.println(dropWhile);
        });
    }

    @ParameterizedTest
    @Order(20)
    @ValueSource(ints = {0, 6, 9, 10, 13})
    @DisplayName("Taking distinguished animals while their weight <= int")
        // stream().sorted(Comparator<? super Animal>).takeWhile(Predicate<? super Animal>)
    void takeWhile(int threshold) {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var takeWhile = ANIMALS.stream()
                    .distinct()
                    .sorted(Comparator.comparingInt(Animal::getWeight))
                    .takeWhile(animal -> animal.getWeight() <= threshold)
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertTrue(() -> {
                for (Animal animal : takeWhile) {
                    if (animal.getWeight() > threshold) {
                        return false;
                    }
                }
                return true;
            });
            System.out.println(takeWhile);
        });
    }

    @Test
    @Order(21)
    @DisplayName("Flat-mapping distinguished dogs to list of all(repeatable) reactions they have learnt.")
        // stream.flatMap(Function<? super Dog, ? extends Stream<? extends R>>)
    void flatMapAnimalsToDogsReactions() {
        assertAll(() -> {
            ANIMALS.forEach(animal -> assertNotNull(animal, ANIMAL_NOT_NULL));
            var distinct = ANIMALS.stream()
                    .distinct()
                    .collect(Collectors.toList());
            List<Dog> dogs = AnimalUtils.getDogs(distinct);
            assumeFalse(dogs.isEmpty());
            var mapped = dogs.stream()
                    .map(Dog::getDogCommands)
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            System.out.println("No flattening: ");
            System.out.println(mapped);
            var expected = mapped.stream()
                    .mapToInt(List::size)
                    .reduce(Integer::sum);
            assumeTrue(expected.isPresent());
            var flatMapped = dogs.stream()
                    .flatMap(dog -> dog.getDogCommands().stream())
                    .collect(Collectors.toCollection(CustomizedArrayList::new));
            assertEquals(expected.getAsInt(), flatMapped.size());
            System.out.println("\n" + "Flattened:");
            System.out.println(flatMapped);
        });
    }
}
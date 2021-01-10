package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    Movie f1 = new Movie(1, 1, "f1", "url", "g1");
    Movie f2 = new Movie(2, 2, "f2", "url", "g1");
    Movie f3 = new Movie(3, 3, "f3", "url", "g1");
    Movie f4 = new Movie(4, 4, "f1", "url", "g1");
    Movie f5 = new Movie(5, 5, "f2", "url", "g1");
    Movie f6 = new Movie(6, 6, "f3", "url", "g1");
    Movie f7 = new Movie(7, 7, "f1", "url", "g1");
    Movie f8 = new Movie(8, 8, "f2", "url", "g1");
    Movie f9 = new Movie(9, 9, "f3", "url", "g1");
    Movie f10 = new Movie(10, 10, "f2", "url", "g1");
    Movie f11 = new Movie(11, 11, "f3", "url", "g1");

    //-----------getLastFilms Tests--------------
    @Test
    public void shouldGetIfLessMax() {

        manager.add(f1);
        manager.add(f2);
        manager.add(f3);
        manager.add(f4);
        manager.add(f5);
        manager.add(f6);
        manager.add(f7);
        manager.add(f8);
        manager.add(f9);

        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{f9, f8, f7, f6, f5, f4, f3, f2, f1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetIfMoreMax() {

        manager.add(f1);
        manager.add(f2);
        manager.add(f3);
        manager.add(f4);
        manager.add(f5);
        manager.add(f6);
        manager.add(f7);
        manager.add(f8);
        manager.add(f9);
        manager.add(f10);
        manager.add(f11);

        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{f11, f10, f9, f8, f7, f6, f5, f4, f3, f2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetIfMax() {

        manager.add(f1);
        manager.add(f2);
        manager.add(f3);
        manager.add(f4);
        manager.add(f5);
        manager.add(f6);
        manager.add(f7);
        manager.add(f8);
        manager.add(f9);
        manager.add(f10);

        Movie[] actual = manager.getLastFilms();
        Movie[] expected = new Movie[]{f10,f9, f8, f7, f6, f5, f4, f3, f2, f1};

        assertArrayEquals(expected, actual);
    }
    //---------------Add Tests------------------
    @Test
    public void shouldAddIfEmpty() {

        manager.add(f1);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{f1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddIfExists() {

        manager.add(f1);
        manager.add(f2);
        manager.add(f3);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{f3, f2, f1};

        assertArrayEquals(expected, actual);
    }

    //-------------Remote Tests--------------------
    @Test
    public void shouldRemoveIfExists() {

        int idToRemove = 1;
        manager.add(f1);
        manager.add(f2);
        manager.add(f3);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{f3, f2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {

        int idToRemove = 4;
        manager.add(f1);
        manager.add(f2);
        manager.add(f3);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{f3, f2, f1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfEmpty() {

        int idToRemove = 4;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

}
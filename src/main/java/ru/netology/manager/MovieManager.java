package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    public static final int DEFAULT_MAX_FILMS = 10;
    private Movie[] items = new Movie[0];

    public void add(Movie item) {
        // создаём новый массив размером на единицу больше
        Movie[] tmp = new Movie[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item; // кладём последним  элемент
        items = tmp;
    }

    public Movie[] getLastFilms() {
        int maxFilms = Math.min(items.length, DEFAULT_MAX_FILMS);
        Movie[] result = new Movie[maxFilms];
        for (int i = 0; i < maxFilms; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        if (items.length == 0) return;
        Movie[] tmp = new Movie[items.length - 1];
        int index = 0;
        boolean flag = false;
        for (Movie item : items) {
            if (item.getId() != id) {
                if (index < tmp.length) {
                    tmp[index] = item;
                    index++;
                }
            } else {
                flag = true;
            }
        }
        // меняем наши элементы
        if (flag) items = tmp;
    }
}

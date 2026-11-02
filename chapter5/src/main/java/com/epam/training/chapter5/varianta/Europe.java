package com.epam.training.chapter5.varianta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Europe {

    private final Set<String> states = new TreeSet<>();
    private final List<TerritorialChange> history = new ArrayList<>();

    public Europe(Collection<String> initialStates) {
        states.addAll(initialStates);
    }

    public TerritorialChange recordChange(int year, String description, List<String> removed, List<String> added) {
        TerritorialChange change = new TerritorialChange(year, description, removed, added);
        change.apply();
        history.add(change);
        return change;
    }

    public List<TerritorialChange> getHistory() {
        return history.stream()
                .sorted(Comparator.comparingInt(TerritorialChange::getYear))
                .toList();
    }

    public Set<String> getStates() {
        return Collections.unmodifiableSet(states);
    }

    public int getStateCount() {
        return states.size();
    }

    public class TerritorialChange {

        private final int year;
        private final String description;
        private final List<String> removed;
        private final List<String> added;

        private TerritorialChange(int year, String description, List<String> removed, List<String> added) {
            this.year = year;
            this.description = description;
            this.removed = List.copyOf(removed);
            this.added = List.copyOf(added);
        }

        private void apply() {
            if (!states.containsAll(removed)) {
                throw new IllegalArgumentException("На карте нет одного из государств: " + removed);
            }
            states.removeAll(removed);
            states.addAll(added);
        }

        public int getYear() {
            return year;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return year + ": " + description + " (исчезли: " + removed + ", появились: " + added + ")";
        }
    }
}

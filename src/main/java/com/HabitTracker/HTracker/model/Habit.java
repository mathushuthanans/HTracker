package com.HabitTracker.HTracker.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate startDate;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    private int nDays;
    private int streak; // new data,

    // for brute-force
    private LocalDate currentDate;
    private LocalDate tempDate;
    private LocalDate lastDate;

    public int getStreak() {
        return streak;
    }
    public void setStreak(int streak) {
        this.streak = streak;
    }
    public LocalDate getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
    public LocalDate getTempDate() {
        return tempDate;
    }
    public void setTempDate(LocalDate tempDate) {
        this.tempDate = tempDate;
    }
    public LocalDate getLastDate() {
        return lastDate;
    }
    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }
    public int getnDays() {
        return nDays;
    }
    public void setnDays(int nDays) {
        this.nDays = nDays;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {  // Return LocalDate directly
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {  // Accept LocalDate
        this.startDate = startDate;
    }
    @Override
    public String toString() {
        return "Habit [id=" + id + ", name=" + name + ", startDate=" + startDate + ", nDays=" + nDays + ", streak="
                + streak + ", currentDate=" + currentDate + ", tempDate=" + tempDate + ", lastDate=" + lastDate + "]";
    }


    



}

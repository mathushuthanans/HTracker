package com.HabitTracker.HTracker.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

import com.HabitTracker.HTracker.Repository.StoreHibernate;
import com.HabitTracker.HTracker.model.Habit;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class HomeController {
    private final StoreHibernate sh;
    public HomeController(StoreHibernate sh) {  
        this.sh = sh;
    }


    @RequestMapping("/")
    public String todayPage(@RequestParam(required = false, defaultValue = "") List<String> selectedHabits, Model m){
        /**
         * The selectedHabits are Optional (as a first Page)
         * But Model is to hold the consistency to next Pages.  It is provided by the Spring Boot 
         */
        List <Habit> habits = sh.retrieve();
        m.addAttribute("habits", habits);
 
        if (selectedHabits != null){
            for (String s : selectedHabits){
                int ind = Integer.parseInt(s);
                /**
                 * JPA Entity can't be managed through Spring Boot as "Beans". 
                 * Manual object creation is required
                 * 
                 * Streams are necessary when one-time access & to avoid the boundErrors
                 */
                Habit habit = habits.stream()                      
                                    .filter(h -> h.getId() == ind)
                                    .findFirst()
                                    .orElse(null);
                if ((habit != null) && (!habit.getCurrentDate().equals(LocalDate.now()))){
                    /** 
                     * To update the count and streak
                     */
                    habit.setCurrentDate(LocalDate.now());
                    habit.setnDays(habit.getnDays() + 1);

                    // streak
                    LocalDate tempLastDate = LocalDate.now();
                    tempLastDate = tempLastDate.minusDays(1);

                    if (habit.getLastDate().equals(tempLastDate)){
                        habit.setStreak(habit.getStreak() + 1);
                    }
                    sh.updated(habit);
                }                   

                
            }            
        }

        return "today";
    }
    

    @RequestMapping("/add")
    public String storePage(Habit habit){
        if (habit.getName() == null || habit.getName().isEmpty()) {
            return "add";
        }

        habit.setLastDate(LocalDate.now().minusDays(1));
        habit.setTempDate(LocalDate.now());
        habit.setCurrentDate(LocalDate.of(1970, 1, 1));
        habit.setStreak(0);
        System.out.println(habit);
        List <Habit> habits = sh.retrieve();
        boolean recorded = false;

        for (Habit rHabit : habits){
            if (rHabit.getName().equals(habit.getName())){
                recorded = true;
            }
        }

        if (!recorded){
            sh.save(habit);
            System.out.println("Saved in the database: " + habit);
        }
        return "add";
        
    }

    @RequestMapping("/display")
    public String displayPage(Model model){
        List <Habit> habits = sh.retrieve();
        model.addAttribute("habits", habits);
        return "display";
                
    }
}
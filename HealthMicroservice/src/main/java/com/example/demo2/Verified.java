package com.example.demo2;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/* Verified Class */
public class Verified {
    @Id
    private int _id;
    private String Week;
    private String Age_group;
    private String Tests_num;
    private String Not_recovered_at_least_2_doses	;
    private String Not_recovered_partially_vaccinated	;
    private String Not_recovered_not_vaccinated;
    private String Cases_among_recoverd_with_vacc;
    private String Cases_among_recovered_without_vacc;

    public Verified() {}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getWeek() {
        return Week;
    }

    @JsonProperty("Week")
    public void setWeek(String week) {
        Week = week;
    }

    public String getAge_group() {
        return Age_group;
    }

    @JsonProperty("Age_group")
    public void setAge_group(String age_group) {
        Age_group = age_group;
    }

    public String getTests_num() {
        return Tests_num;
    }

    @JsonProperty("Tests_num")
    public void setTests_num(String tests_num) {
        Tests_num = tests_num;
    }

    public String getNot_recovered_at_least_2_doses() {
        return Not_recovered_at_least_2_doses;
    }

    @JsonProperty("Not_recovered_at_least_2_doses")
    public void setNot_recovered_at_least_2_doses(String not_recovered_at_least_2_doses) {
        Not_recovered_at_least_2_doses = not_recovered_at_least_2_doses;
    }

    public String getNot_recovered_partially_vaccinated() {
        return Not_recovered_partially_vaccinated;
    }

    @JsonProperty("Not_recovered_partially_vaccinated")
    public void setNot_recovered_partially_vaccinated(String not_recovered_partially_vaccinated) {
        Not_recovered_partially_vaccinated = not_recovered_partially_vaccinated;
    }

    public String getNot_recovered_not_vaccinated() {
        return Not_recovered_not_vaccinated;
    }

    @JsonProperty("Not_recovered_not_vaccinated")
    public void setNot_recovered_not_vaccinated(String not_recovered_not_vaccinated) {
        Not_recovered_not_vaccinated = not_recovered_not_vaccinated;
    }

    public String getCases_among_recoverd_with_vacc() {
        return Cases_among_recoverd_with_vacc;
    }

    @JsonProperty("Cases_among_recoverd_with_vacc")
    public void setCases_among_recoverd_with_vacc(String cases_among_recoverd_with_vacc) {
        Cases_among_recoverd_with_vacc = cases_among_recoverd_with_vacc;
    }

    public String getCases_among_recovered_without_vacc() {
        return Cases_among_recovered_without_vacc;
    }

    @JsonProperty("Cases_among_recovered_without_vacc")
    public void setCases_among_recovered_without_vacc(String cases_among_recovered_without_vacc) {
        Cases_among_recovered_without_vacc = cases_among_recovered_without_vacc;
    }
}
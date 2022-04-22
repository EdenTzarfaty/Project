package com.example.demo2;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/* Recovered Class */
public class Recovered {
    @Id
    private int _id;
    private String age_group;
    private String gender;
    private String month_first_positive;
    private String year_first_positive;
    private String test_indication;
    private String Ind_Re_infection;
    private String Total_vac_dose;
    private String Vac_dose_prior_first_positive;

    public Recovered() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMonth_first_positive() {
        return month_first_positive;
    }

    public void setMonth_first_positive(String month_first_positive) {
        this.month_first_positive = month_first_positive;
    }

    public String getYear_first_positive() {
        return year_first_positive;
    }

    public void setYear_first_positive(String year_first_positive) {
        this.year_first_positive = year_first_positive;
    }

    public String getTest_indication() {
        return test_indication;
    }

    public void setTest_indication(String test_indication) {
        this.test_indication = test_indication;
    }

    public String getInd_Re_infection() {
        return Ind_Re_infection;
    }

    @JsonProperty("Ind_Re_infection")
    public void setInd_Re_infection(String Ind_Re_infection) {
        this.Ind_Re_infection = Ind_Re_infection;
    }

    public String getTotal_vac_dose() {
        return Total_vac_dose;
    }

    @JsonProperty("Total_vac_dose")
    public void setTotal_vac_dose(String Total_vac_dose) {
        this.Total_vac_dose = Total_vac_dose;
    }

    public String getVac_dose_prior_first_positive() {
        return Vac_dose_prior_first_positive;
    }

    @JsonProperty("Vac_dose_prior_first_positive")
    public void setVac_dose_prior_first_positive(String Vac_dose_prior_first_positive) {
        this.Vac_dose_prior_first_positive = Vac_dose_prior_first_positive;
    }
}
